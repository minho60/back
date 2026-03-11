package kr.co.dodram.member.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.dodram.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final JdbcTemplate jdbcTemplate;

    public boolean insertMember(MemberDTO dto, String encodedHobby) {
        String sql = """
            INSERT INTO member(id, pwd, name, gender, email, phone, zipcode, address1, address2, hobby, job) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;
        
        int result = jdbcTemplate.update(sql, 
            dto.getId(), dto.getPwd(), dto.getName(), dto.getGender(), 
            dto.getEmail(), dto.getPhone(), dto.getZipcode(), 
            dto.getAddress1(), dto.getAddress2(), encodedHobby, dto.getJob()
        );
        
        return result == 1;
    }
}