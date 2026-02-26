package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import dto.MemberBean;
import util.DBConnectionMgr;

/**
 * MemberDAO (Data Access Object)
 * 데이터베이스의 member 테이블과 통신하며 회원 관련 데이터 로직을 처리하는 클래스입니다.
 */
public class MemberDAO {

    /**
     * 회원 가입 처리 메서드
     * @param bean 사용자가 입력한 ID와 PW가 담긴 객체
     * @return 성공 시 true, 실패 시 false 반환
     */
    public boolean insertMember(MemberBean bean) {
        // 1. SQL 쿼리 준비: 표준 SQL인 INSERT INTO를 사용합니다.
        // users 테이블의 id와 pwd 컬럼에 데이터를 삽입합니다.
        String sql = "INSERT INTO users(id, pwd) VALUES(?, ?)";
        
        // 2. 비밀번호 암호화 (Salt 처리):
        // BCrypt.gensalt()는 매번 다른 소금(Salt) 값을 생성하여 
        // 동일한 비밀번호라도 서로 다른 해시값이 나오게 만듭니다. (보안성 강화)
        String hashPwd = BCrypt.hashpw(bean.getPwd(), BCrypt.gensalt());

        boolean flag = false;

        // 3. Try-with-resources 문법 사용:
        // Connection과 PreparedStatement를 () 안에 선언하면 
        // 작업이 끝난 후 자동으로 close()되어 메모리 누수를 방지합니다.
        try (Connection conn = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 4. SQL 파라미터 바인딩: ? 자리에 실제 값을 안전하게 채워넣습니다.
            pstmt.setString(1, bean.getId());    // 첫 번째 ? 에 사용자 ID
            pstmt.setString(2, hashPwd);        // 두 번째 ? 에 암호화된 비밀번호

            // 5. 쿼리 실행 및 결과 확인:
            // executeUpdate()는 영향받은 레코드의 개수를 반환합니다.
            // 성공적으로 1개의 행이 삽입되었다면 flag를 true로 설정합니다.
            if (pstmt.executeUpdate() == 1) {
                flag = true;
            }
            
        } catch (Exception e) { 
            // DB 연결 실패, SQL 문법 오류 등 예외 발생 시 콘솔에 에러 내용을 출력합니다.
            e.printStackTrace(); 
        }
        
        // 6. 결과 반환: 서블릿(Controller)으로 성공 여부를 보냅니다.
        return flag;
    }
    
    /**
     * [로그인 인증 메서드]
     * 사용자가 입력한 아이디와 비밀번호를 데이터베이스의 정보와 대조하여 일치 여부를 확인합니다.
     * @param id  사용자가 로그인 화면에서 입력한 아이디 (String)
     * @param pwd 사용자가 로그인 화면에서 입력한 비밀번호 (String)
     * @return    인증 성공 시 true, 일치하지 않거나 예외 발생 시 false 반환
     */
    public boolean loginMember(String id, String pwd) {
        // 1. SQL 쿼리 설계: 사용자가 입력한 ID에 해당하는 비밀번호(pwd) 컬럼만 조회합니다.
        // 모든 정보를 가져오는 것보다 필요한 컬럼만 지정하는 것이 성능상 유리합니다.
        String sql = "select pwd from users where id = ?";
        String dbPwd = "";
        
        // 2. DB 연결 및 PreparedStatement 준비
        // try-with-resources 구문: 사용 후 Connection, PreparedStatement를 자동으로 닫아줍니다.
        try (Connection conn = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // SQL문의 첫 번째 물음표(?) 위치에 사용자가 입력한 id 값을 바인딩합니다.
            // setString을 사용하면 SQL Injection 공격을 방어할 수 있습니다.
            pstmt.setString(1, id);

            // 3. 쿼리 실행 및 결과 처리 (ResultSet)
            try (ResultSet rs = pstmt.executeQuery()) {
                
                // .next() 메서드는 결과 집합에 다음 레코드가 있는지 확인하며 커서를 이동합니다.
                // 만약 true가 반환되면, 해당 ID가 데이터베이스에 존재한다는 의미입니다.
                if (rs.next()) {
                    // 데이터베이스(member 테이블)에 실제 저장되어 있는 비밀번호를 가져옵니다.
                    dbPwd = rs.getString("pwd");
                  
                    // 4. BCrypt.checkpw로 입력받은 비번과 DB의 암호화 비번을 비교
    				// 일치하면 true, 다르면 false 즉시 반환
    				return BCrypt.checkpw(pwd, dbPwd);
                }
            }
        } catch (Exception e) {
            // DB 연결 실패, SQL 오류 등 예외 발생 시 에러 내용을 콘솔에 출력합니다.
            e.printStackTrace();
        }
        
        // 5. ID가 없거나 비밀번호가 틀리면 false가 반환됩니다.
        return false;
    }   
}