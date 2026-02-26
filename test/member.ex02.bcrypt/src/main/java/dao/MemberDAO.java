package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.mindrot.jbcrypt.BCrypt;

import dto.MemberBean;
import util.DBConnectionMgr;

/**
 * DAO (Data Access Object): 데이터베이스의 data에 접근하기 위한 객체입니다.
 * 비즈니스 로직(회원가입)을 실제 DB 쿼리로 변환하여 실행합니다.
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
}