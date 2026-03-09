package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

        // 2. 비밀번호 암호화 (Salt 처리):
        // BCrypt.gensalt()는 매번 다른 소금(Salt) 값을 생성하여 
        // 동일한 비밀번호라도 서로 다른 해시값이 나오게 만듭니다. (보안성 강화)
        String hashPwd = BCrypt.hashpw(bean.getPwd(), BCrypt.gensalt());
        
        boolean flag = false;
        
        // DB 연결 및 SQL 실행 준비
        try (Connection conn = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 1~9번째 물음표에 Bean에서 꺼내온 데이터 매핑
            pstmt.setString(1, bean.getId());
            pstmt.setString(2, hashPwd); // 비밀번호 암호화 후 저장
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
    
    /**
     * [로그인 체크 메서드 - 업그레이드 버전]
     * - 사용자가 입력한 ID/PW를 검증하고, 성공 시 사용자 정보를 Bean에 담아 반환합니다.
     * - 반환 타입이 boolean이 아닌 MemberBean이므로 세션에 이름을 저장하기 용이합니다.
     */
    public MemberBean loginCheck(String id, String pwd) {
        // 비밀번호(검증용)와 이름(세션 표시용)을 함께 조회합니다.
        String sql = "select pwd, name from member where id = ?";
        
        try (Connection con = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String dbPwd = rs.getString("pwd");

                    // BCrypt를 이용해 평문 비밀번호와 암호화된 DB 비밀번호를 비교합니다.
                    if (BCrypt.checkpw(pwd, dbPwd)) {
                        // 검증 성공 시, 새로운 Bean을 생성하여 정보를 채웁니다.
                        MemberBean bean = new MemberBean();
                        bean.setId(id);
                        bean.setName(rs.getString("name")); // DB에 저장된 실제 이름(예: 홍길동)
                        return bean;
                    }
                }
            }
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        return null; // ID가 없거나 비밀번호 불일치 시 null을 반환하여 '실패'를 알림
    }
    
    /**
     * [1. 자동 로그인 토큰 업데이트]
     * - 로그인 시 '로그인 유지'를 체크했을 때, 생성된 토큰과 만료 시간을 DB에 기록합니다.
     */
    public void keepLogin(String id, String sessionKey, java.sql.Timestamp sessionLimit) {
        String sql = "update member set session_key = ?, session_limit = ? where id = ?";
        try (Connection con = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, sessionKey);   // 생성된 랜덤 쿠키 값
            pstmt.setTimestamp(2, sessionLimit); // 쿠키 만료 예정 시각
            pstmt.setString(3, id);           // 대상 사용자 ID
            
            pstmt.executeUpdate();
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
    }

    /**
     * [2. 쿠키 토큰 검증 및 정보 획득]
     * - 사용자가 브라우저를 다시 켰을 때, 쿠키 속 토큰이 DB에 있는지 + 만료되지 않았는지 확인합니다.
     */
    public MemberBean checkUserWithSessionKey(String sessionKey) {
        // 토큰이 일치하고, 만료 시간이 현재 시간(now())보다 이후인 데이터만 조회
        String sql = "select * from member where session_key = ? and session_limit > now()";
        
        try (Connection con = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, sessionKey);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // 유효한 토큰일 경우, 해당 사용자의 정보를 Bean에 담아 자동 로그인을 준비합니다.
                    MemberBean bean = new MemberBean();
                    bean.setId(rs.getString("id"));
                    bean.setName(rs.getString("name")); // 여기서 '홍길동'을 가져와 일관성 유지
                    return bean;
                }
            }
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        return null; // 토큰이 변조되었거나 만료되었다면 null 반환
    }
    
    
    
    
    /**
     * [SNS 전용 가입 및 로그인 처리 메서드]
     * @param email    : 사용자의 이메일 (ID로 활용)
     * @param nickname : 사용자의 별명 또는 이름
     * @param snsId    : SNS 플랫폼에서 발급한 고유 식별 번호
     * @param snsType  : SNS 종류 (예: 'naver', 'kakao')
     * @return 성공 여부 (이미 존재하거나 신규 가입 성공 시 true)
     */
    public boolean saveSnsMember(String email, String nickname, String snsId, String snsType) {    
        
        // 1. 중복 확인 쿼리: 해당 SNS 식별자와 타입으로 가입된 이력이 있는지 조회
        String selectSql = "select id from member where sns_id = ? and sns_type = ?";
        
        // 2. 신규 가입 쿼리: SNS 정보를 포함하여 회원 테이블에 데이터 삽입
        // regdate에 now()를 사용하여 가입 일시를 자동으로 기록
        String insertSql = "insert member(id, name, email, sns_type, sns_id, regdate) values(?,?,?,?,?, now())";

        // [try-with-resources] 문법을 사용하여 DB 연결(Connection)을 자동으로 닫도록 처리
        try (Connection conn = DBConnectionMgr.getConnection()) {
            
            /* * [STEP 1] 기존 가입 여부 확인 
             */
            try (PreparedStatement pstmt1 = conn.prepareStatement(selectSql)) {
                pstmt1.setString(1, snsId);
                pstmt1.setString(2, snsType);
                
                try (ResultSet rs = pstmt1.executeQuery()) {
                    // 결과가 존재하면 이미 가입된 회원이므로 추가 가입 없이 true 반환
                    if (rs.next()) return true; 
                }
            }

            /* * [STEP 2] 신규 SNS 회원 가입 진행
             * 기존 정보가 없는 경우에만 실행됩니다.
             */
            try (PreparedStatement pstmt2 = conn.prepareStatement(insertSql)) {
                // 파라미터 매핑 (쿼리의 ? 순서대로 값을 채움)
                pstmt2.setString(1, email);    // id 컬럼
                pstmt2.setString(2, nickname); // name 컬럼
                pstmt2.setString(3, email);    // email 컬럼
                pstmt2.setString(4, snsType);  // sns_type 컬럼 (naver 등)
                pstmt2.setString(5, snsId);    // sns_id 컬럼 (고유 번호)
                
                // executeUpdate()는 영향받은 행(row)의 수를 반환합니다.
                // 1행이 정상적으로 삽입되었다면 true를 반환하게 됩니다.
                return pstmt2.executeUpdate() == 1;
            }
            
        } catch (Exception e) {
            // SQL 실행 중 오류 발생 시 콘솔에 에러 내용을 출력합니다.
            e.printStackTrace();
        }
        
        // 오류 발생 시 false 반환
        return false;
    }
    
} // MemberDAO의 끝