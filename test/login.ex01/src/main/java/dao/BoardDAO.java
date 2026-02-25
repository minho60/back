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
 * 데이터베이스의 board 테이블에 접근하여 데이터를 조회, 삽입, 수정, 삭제하는 전담 클래스입니다.
 * 비즈니스 로직(Controller)과 DB 로직을 분리하기 위해 사용합니다.
 */
public class BoardDAO {
    
    /**
     * 게시글 전체 목록을 가져오는 메서드
     * @return DB에서 조회된 BoardBean 객체들이 담긴 List
     */
    public List<BoardBean> getBoardList() {
        // 1. 결과를 담을 리스트 생성 (비어있는 상태)
        List<BoardBean> list = new ArrayList<>();
        
        // 2. 실행할 SQL문 작성
        // ORDER BY num DESC: 글 번호(num)를 기준으로 내림차순 정렬하여 최신글이 위로 오게 함
        String sql = "SELECT * FROM board ORDER BY num DESC";

        /*
         * 3. try-with-resources 구문 (JDK 7 이상)
         * - 괄호 () 안에 선언된 Connection, PreparedStatement, ResultSet 객체들은
         * try 블록이 끝나는 순간(정상 종료든 에러 발생이든) 자동으로 .close()가 호출됩니다.
         * - 이 방식을 통해 자원 누수(Memory Leak)를 방지하고 코드를 간결하게 유지합니다.
         */
        try (
            Connection conn = DBConnectionMgr.getConnection(); // DB 연결 획득
            PreparedStatement pstmt = conn.prepareStatement(sql); // SQL 실행 준비
            ResultSet rs = pstmt.executeQuery() // 쿼리 실행 후 결과를 ResultSet에 저장
        ) {
            
            // 4. ResultSet에 담긴 결과 행(row)을 하나씩 읽어옴
            while (rs.next()) {
                // 한 줄의 데이터를 자바 객체(DTO)로 변환 (매핑 작업)
                BoardBean bb = new BoardBean();
                
                // rs.getXXX("컬럼명")을 통해 DB 테이블의 값을 꺼내어 Bean 객체에 저장
                bb.setNum(rs.getString("num"));
                bb.setUserid(rs.getString("userid")); 
                bb.setSubject(rs.getString("subject"));
                bb.setContent(rs.getString("content"));
                bb.setRegdate(rs.getString("regdate"));
                bb.setReadcount(rs.getString("readcount"));
                
                // 데이터가 채워진 객체를 리스트에 추가
                list.add(bb);
            }
        } catch (Exception e) {
            // 예외 발생 시 콘솔에 에러 경로 출력 (디버깅용)
            e.printStackTrace();
        }
        
        // 5. 최종 완성된 리스트를 반환 (데이터가 없으면 비어있는 리스트 반환)
        return list; 
    }
}