package kr.co.dodram.security.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.dodram.security.dto.MemberDTO;
import lombok.RequiredArgsConstructor;

/**
 * 회원 데이터베이스 접근 객체 (Data Access Object)
 * Spring JDBC를 사용하여 MySQL/Oracle 등의 DB에 쿼리를 실행합니다.
 */
@Repository // 이 클래스가 데이터 저장소 계층임을 선언하고 스프링 빈으로 등록합니다.
@RequiredArgsConstructor // final로 선언된 jdbcTemplate을 생성자 주입 방식으로 연결합니다.
public class MemberDAO {

    // Spring에서 제공하는 JDBC 추상화 도구 (Connection 관리, 예외 처리 자동화)
    private final JdbcTemplate jdbcTemplate;

    /**
     * [회원가입] 새로운 회원 정보를 DB에 저장합니다.
     * @param dto 회원가입 양식 데이터가 담긴 객체
     * @param encodedHobby 서비스에서 가공된 비트 인코딩 취미 문자열 (예: "10100")
     * @return 성공 시 true, 실패 시 false
     */
    public boolean insertMember(MemberDTO dto, String encodedHobby) {
        // 텍스트 블록(""")을 사용하여 쿼리문을 가독성 있게 작성
        String sql = """
            INSERT INTO member(id, pwd, name, gender, email, phone, zipcode, address1, address2, hobby, job) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;
        
        // update 메서드는 영향받은 행(row)의 수를 반환합니다.
        int result = jdbcTemplate.update(sql, 
            dto.getId(), dto.getPwd(), dto.getName(), dto.getGender(), 
            dto.getEmail(), dto.getPhone(), dto.getZipcode(), 
            dto.getAddress1(), dto.getAddress2(), encodedHobby, dto.getJob()
        );
        
        // 1개 행이 정상적으로 삽입되었다면 true 반환
        return result == 1;
    }
    
    /**
     * [로그인 검증용] 아이디를 기반으로 암호화된 비밀번호를 조회합니다.
     * @param id 사용자 아이디
     * @return DB에 저장된 해시 비밀번호 (없으면 null)
     */
    public String getPasswordById(String id) {
        String sql = "SELECT pwd FROM member WHERE id = ?";
        try {
            // queryForObject: 결과가 단일 행/단일 컬럼일 때 사용 (String.class는 반환 타입을 의미)
            return jdbcTemplate.queryForObject(sql, String.class, id);
        } catch (EmptyResultDataAccessException e) {
            // 쿼리 결과가 0건일 경우 Spring이 던지는 예외를 잡아 null을 반환하도록 처리
            return null;
        }
    }

    /**
     * [사용자 확인용] 아이디를 기반으로 사용자 실명을 조회합니다.
     * 로그인 성공 핸들러에서 세션에 이름을 담기 위해 사용됩니다.
     * @param id 사용자 아이디
     * @return 사용자 이름 (없으면 null)
     */
    public String getNameById(String id) {
        String sql = "SELECT name FROM member WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, String.class, id);
        } catch (EmptyResultDataAccessException e) {
            // 해당 아이디가 존재하지 않는 경우 안전하게 null 반환
            return null;
        }
    }
}