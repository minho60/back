package kr.co.dodram.login.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.dodram.login.dto.MemberDTO;
import lombok.RequiredArgsConstructor;

/**
 * [Repository 레이어]
 * 데이터베이스(DB)와의 직접적인 통신을 담당하는 클래스입니다.
 * @Repository: 스프링이 이 클래스를 DAO로 인식하고 빈(Bean)으로 등록하며, 
 * DB 관련 예외를 스프링의 데이터 예외 체계로 변환해줍니다.
 */
@Repository
@RequiredArgsConstructor // final이 붙은 필드(jdbcTemplate)를 매개변수로 갖는 생성자를 자동으로 생성합니다. (생성자 주입)
public class MemberDAO {

    // Spring JDBC에서 제공하는 JdbcTemplate: Connection 관리, SQL 실행, 자원 해제를 자동으로 처리합니다.
    private final JdbcTemplate jdbcTemplate;

    /**
     * [회원 가입] 사용자 정보를 DB의 member 테이블에 저장합니다.
     * * @param dto 사용자가 입력한 회원 정보 객체
     * @param encodedHobby 서비스 레이어에서 비트 연산 등으로 가공된 취미 문자열 (예: "10100")
     * @return 성공 시 true, 실패 시 false
     */
    public boolean insertMember(MemberDTO dto, String encodedHobby) {
        // 텍스트 블록(""")을 사용하여 가독성 있게 SQL문을 작성합니다.
        String sql = """
            INSERT INTO member(id, pwd, name, gender, email, phone, zipcode, address1, address2, hobby, job) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;
        
        // jdbcTemplate.update(): INSERT, UPDATE, DELETE와 같이 데이터를 변경하는 쿼리에 사용됩니다.
        // 첫 번째 인자는 SQL, 이후는 물음표(?) 자리에 들어갈 파라미터들입니다. (순서 엄격)
        int result = jdbcTemplate.update(sql, 
            dto.getId(), dto.getPwd(), dto.getName(), dto.getGender(), 
            dto.getEmail(), dto.getPhone(), dto.getZipcode(), 
            dto.getAddress1(), dto.getAddress2(), encodedHobby, dto.getJob()
        );
        
        // update 메서드는 영향받은 행(row)의 수를 반환합니다. 1행이 추가되었다면 성공(true)입니다.
        return result == 1;
    }

    /**
     * [로그인 처리 1단계] 사용자가 입력한 ID에 해당하는 비밀번호(pwd)를 조회합니다.
     * * @param id 로그인 화면에서 입력받은 아이디
     * @return DB에 저장된 암호화된(혹은 평문) 비밀번호 문자열, ID가 없으면 null
     */
    public String getPasswordById(String id) {
        String sql = "SELECT pwd FROM member WHERE id = ?";
        
        try {
            // queryForObject: 결과가 단 '하나'인 행을 조회할 때 사용합니다.
            // 두 번째 인자(String.class)는 결과값을 어떤 타입으로 반환받을지 정의합니다.
            return jdbcTemplate.queryForObject(sql, String.class, id);
        } catch (EmptyResultDataAccessException e) {
            // queryForObject는 결과 데이터가 0건일 경우 예외를 던집니다.
            // 이를 catch하여 null을 반환함으로써 서비스 레이어에서 '존재하지 않는 아이디' 처리를 유도합니다.
            return null;
        }
    }

    /**
     * [로그인 처리 2단계] 비밀번호 일치가 확인된 후, 세션에 저장할 회원의 실명(name)을 가져옵니다.
     * * @param id 인증이 완료된 사용자의 아이디
     * @return 회원의 이름, 조회가 안 될 경우 null
     */
    public String getNameById(String id) {
        String sql = "SELECT name FROM member WHERE id = ?";
        try {
            // queryForObject는 결과가 없을 때 예외가 발생하므로 반드시 예외 처리가 필요합니다.
            return jdbcTemplate.queryForObject(sql, String.class, id);
        } catch (EmptyResultDataAccessException e) {
            // 로그 기록이 필요하다면 여기에 추가할 수 있습니다.
            return null;
        }
    }
}