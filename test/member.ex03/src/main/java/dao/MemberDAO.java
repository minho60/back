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
     * ID 중복 확인 메서드
     * @param id 사용자가 입력한 중복 체크 대상 아이디
     * @return 중복된 아이디가 존재하면 true, 없으면 false
     */
    public boolean checkId(String id) {
        // SQL: 입력된 id가 테이블에 존재하는지 조회
        String sql = "select id from member where id = ?";
        boolean flag = false;

        // try-with-resources: DB 연결 객체들을 자동으로 닫아주어 메모리 누수를 방지함
        try (Connection con = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            // 1번째 물음표(?)에 매개변수로 받은 id 값을 바인딩 (보안성 향상)
            pstmt.setString(1, id);
            
            // 쿼리 실행 후 결과가 존재하면(.next()) flag를 true로 설정
            flag = pstmt.executeQuery().next();
            
        } catch (Exception e) { 
            // 예외 발생 시 콘솔에 에러 내용 출력
            e.printStackTrace(); 
        }
        return flag;
    }

	
	
    /**
     * 회원가입 데이터 삽입 메서드
     * @param bean 사용자가 폼에 입력한 데이터를 담고 있는 DTO 객체
     * @return DB 삽입 성공 시 true, 실패 시 false
     */
    public boolean insertMember(MemberBean bean) {
        // SQL: 총 11개의 컬럼에 데이터를 저장하기 위한 INSERT문
        String sql = "insert member(id,pwd,name,gender,email,phone,zipcode,address1,address2,hobby,job) values(?,?,?,?,?,?,?,?,?,?,?)";
        
        //  비밀번호 암호화 (Salt 처리):
        // BCrypt.gensalt()는 매번 다른 소금(Salt) 값을 생성하여 
        // 동일한 비밀번호라도 서로 다른 해시값이 나오게 만듭니다. (보안성 강화)
        String hashPwd = BCrypt.hashpw(bean.getPwd(), BCrypt.gensalt());
        
        boolean flag = false;
        
        // DB 연결 및 SQL 실행 준비
        try (Connection conn = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 1~9번째 물음표에 Bean에서 꺼내온 데이터 매핑
            pstmt.setString(1, bean.getId());
            pstmt.setString(2, bean.getPwd()); // 실무에선 비밀번호 암호화 후 저장 권장
            pstmt.setString(3, bean.getName());
            pstmt.setString(4, bean.getGender());
            pstmt.setString(5, bean.getEmail());
            pstmt.setString(6, bean.getPhone());
            pstmt.setString(7, bean.getZipcode());
            pstmt.setString(8, bean.getAddress1());
            pstmt.setString(9, bean.getAddress2());

            /* * [Hobby 처리 로직]
             * 체크박스로 다중 선택된 취미(String[])를 DB에 저장하기 적합한 비트 패턴(예: "10100")으로 변환
             */
            // 초기 상태: 00000 (아무것도 선택 안 됨)
            char hb[] = {'0', '0', '0', '0', '0'};
            // 비교 기준이 될 전체 취미 목록
            String[] lists = {"인터넷", "여행", "게임", "영화", "운동"};
            // Bean에서 실제 사용자가 선택한 취미 배열을 가져옴
            String[] hobbyArray = bean.getHobby(); 

            if (hobbyArray != null) {
                // 사용자가 선택한 취미들을 하나씩 꺼내어 전체 목록과 비교
                for (String h : hobbyArray) {
                    for (int j = 0; j < lists.length; j++) {
                        // 일치하는 항목이 있다면 해당 인덱스 번호의 값을 '1'로 변경
                        if (h.equals(lists[j])) hb[j] = '1';
                    }
                }
            }
            
            // 변환 완료된 취미 문자열(예: "10100")을 10번째 물음표에 세팅
            pstmt.setString(10, new String(hb));
            // 직업 정보를 11번째 물음표에 세팅
            pstmt.setString(11, bean.getJob());

            // executeUpdate(): SQL 실행 후 영향받은 레코드 수를 반환 (1이면 삽입 성공)
            flag = pstmt.executeUpdate() == 1;
            
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        return flag;
    }
    
    
    
    

   
}