package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.BoardBean;
import util.DBConnectionMgr;

/**
 * [BoardDAO - Data Access Object]
 * 데이터베이스의 board 테이블과 자바 어플리케이션 사이에서 데이터를 주고받는 전담 클래스입니다.
 * SQL 쿼리를 실행하고 결과를 Java 객체(List, DTO)로 변환하는 역할을 합니다.
 */
public class BoardDAO {
    
    /**
     * 게시글 목록 조회 (페이징 지원)
     * @param start 조회 시작 레코드 번호 (MySQL 기준 0부터 시작)
     * @param pageSize 한 페이지에 가져올 레코드 개수
     * @return DB에서 조회된 게시글 목록 (BoardBean 객체들이 담긴 ArrayList)
     */
    public List<BoardBean> getBoardList(int start, int pageSize) {
        // 1. 조회된 데이터를 보관할 리스트 객체 생성
        List<BoardBean> list = new ArrayList<>();
        
        // 2. SQL 쿼리 준비
        // ORDER BY num DESC: 최신글이 먼저 보이도록 글 번호를 기준으로 내림차순 정렬
        // LIMIT ?, ?: 대량의 데이터 중 '특정 구간'만 끊어서 가져오기 위한 핵심 SQL 문법
        String sql = "SELECT * FROM board ORDER BY num DESC LIMIT ?, ?";

        /*
         * 3. try-with-resources (자동 자원 해제)
         * Connection과 PreparedStatement를 선언하여 작업이 끝나면 자동으로 close()되게 함
         */
        try (
            Connection conn = DBConnectionMgr.getConnection(); // 커넥션 풀로부터 연결 획득
            PreparedStatement pstmt = conn.prepareStatement(sql) // 쿼리 객체 생성
        ) {
            
            // 4. 동적 파라미터 바인딩 (? 자리에 값 채우기)
            pstmt.setInt(1, start);    // 첫 번째 ?: 건너뛸 데이터 개수
            pstmt.setInt(2, pageSize); // 두 번째 ?: 실제 가져올 데이터 개수

            // 5. 쿼리 실행 및 결과 처리
            // ResultSet 또한 try-with-resources로 감싸서 자동으로 닫히도록 관리함
            try (ResultSet rs = pstmt.executeQuery()) { 
                
                // 조회 결과가 여러 개이므로 while문을 사용하여 한 행(row)씩 반복 처리
                while (rs.next()) {
                    // 한 행의 데이터를 담기 위한 자바 객체(DTO) 생성
                    BoardBean bb = new BoardBean();
                    
                    // DB 테이블의 컬럼 값을 꺼내서 BoardBean 필드에 하나씩 셋팅 (매핑)
                    bb.setNum(rs.getString("num"));
                    bb.setUserid(rs.getString("userid")); // DB의 userid 컬럼값을 Bean의 writer 필드에 저장
                    bb.setSubject(rs.getString("subject"));
                    bb.setContent(rs.getString("content"));
                    bb.setRegdate(rs.getString("regdate"));
                    bb.setReadcount(rs.getString("readcount"));
                    
                    // 완성된 객체를 결과 리스트에 추가
                    list.add(bb);
                }
            }
        } catch (Exception e) {
            // 예외 발생 시 에러 메시지와 위치를 추적할 수 있도록 출력
            e.printStackTrace();
        }
        
        // 6. 결과 리스트 반환 (조회 결과가 없으면 크기가 0인 리스트가 반환됨)
        return list; 
    }
    
    /**
     * 전체 게시글 수 조회
     * 페이징 처리 시 '전체 페이지 번호'를 계산하기 위해 반드시 필요한 메서드입니다.
     * @return board 테이블의 총 레코드 개수
     */
    public int getTotalCount() {
        int total = 0;
        String sql = "SELECT COUNT(num) FROM board"; 
        
        try (Connection con = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            /*
             * 1. rs.next() 호출의 의미:
             * ResultSet은 처음 실행 시 커서가 데이터의 이전(Before First)을 가리키고 있습니다.
             * 데이터가 한 건이라도 존재한다면 커서를 실제 데이터가 있는 곳으로 옮기기 위해 rs.next()를 호출해야 합니다.
             */
            if (rs.next()) {
                /*
                 * 2. rs.getInt(1):
                 * 조회 결과 집합에서 첫 번째 컬럼(여기서는 COUNT한 결과값)을 정수(int)로 가져오라는 의미입니다.
                 */
                total = rs.getInt(1);
            }
            
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        return total;
    }
}