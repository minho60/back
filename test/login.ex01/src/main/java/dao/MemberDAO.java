package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBConnectionMgr;

public class MemberDAO {
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
        String sql = "select pwd from member where id = ?";
        
        // 인증 성공 여부를 담을 변수 (기본값은 실패인 false로 설정)
        boolean flag = false;

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
                    String dbPwd = rs.getString("pwd");

                    // 4. 입력받은 비밀번호(pwd)와 DB 비밀번호(dbPwd)를 비교합니다.
                    // dbPwd가 null이 아니고, 두 값이 대소문자까지 완벽히 일치하는지 equals()로 확인합니다.
                    if (dbPwd != null && dbPwd.equals(pwd)) {
                        // 두 비밀번호가 일치하면 flag를 true로 전환하여 인증 성공을 표시합니다.
                        flag = true; 
                    }
                }
            }
        } catch (Exception e) {
            // DB 연결 실패, SQL 오류 등 예외 발생 시 에러 내용을 콘솔에 출력합니다.
            e.printStackTrace();
        }
        
        // 5. 최종 결과 반환: ID가 없거나 비밀번호가 틀리면 초기값인 false가 반환됩니다.
        return flag;
    }
}
