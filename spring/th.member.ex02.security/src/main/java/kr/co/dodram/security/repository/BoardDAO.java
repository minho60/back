package kr.co.dodram.security.repository;


import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.dodram.security.dto.BoardDTO;

/**
 * [Repository 계층]
 * @Repository: 이 클래스가 데이터 액세스 계층의 빈(Bean)임을 Spring 컨테이너에 알립니다.
 * 또한, 데이터베이스 관련 예외(SQLException 등)를 스프링의 DataAccessException으로 자동 변환해주는 기능도 수행합니다.
 */
@Repository 
public class BoardDAO {

    // JdbcTemplate: Spring에서 제공하는 SQL 실행 핵심 클래스입니다. 
    // 커넥션 연결/종료, Statement 생성/실행 등의 반복적인 작업을 대신 처리해줍니다.
    private final JdbcTemplate jdbcTemplate;

    /**
     * [생성자 주입 (Constructor Injection)]
     * 스프링 컨테이너가 생성 시점에 필요한 JdbcTemplate 객체를 자동으로 주입해줍니다.
     * 'final' 키워드를 사용할 수 있어 객체의 불변성을 보장하며, 테스트 코드 작성 시에도 유리합니다.
     */
    public BoardDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 게시글 전체 목록 조회
     * @return BoardDTO 객체들이 담긴 List
     */
    public List<BoardDTO> getBoardList() {
        // 1. SQL 쿼리문: 최신글이 위로 오도록(DESC) 정렬하여 모든 게시글을 조회합니다.
        String sql = "SELECT num, userid, subject, content, regdate, readcount FROM board ORDER BY num DESC";

        /*
         * 2. jdbcTemplate.query(SQL, RowMapper)
         * - 첫 번째 인자: 실행할 SQL 문
         * - 두 번째 인자: DB의 한 행(Row)을 자바 객체(DTO)로 어떻게 변환할지 결정하는 Mapper
         * * [BeanPropertyRowMapper 상세 설명]
         * - DB의 컬럼명(ex: user_id 또는 userid)과 BoardDTO의 필드명(ex: userid)을 매칭합니다.
         * - 관례적으로 DB의 'snake_case'를 자바의 'camelCase'로 자동 매핑해주는 아주 편리한 도구입니다.
         * - 내부적으로 기본 생성자와 Setter를 사용하므로 BoardDTO에 이들이 반드시 존재해야 합니다.
         */
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BoardDTO.class));
    }
}