package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dto.BoardBean;
import util.DBConnectionMgr;

public class BoardDAO {

	/**
     * [메서드: getBoardList]
     * 검색 조건과 페이징 정보를 받아 게시글 목록을 반환합니다.
     * @param keyField 검색 카테고리 (userid, subject, content 등)
     * @param keyWord  사용자가 입력한 검색어
     * @param start    조회 시작점 (MySQL LIMIT의 첫 번째 인자)
     * @param pageSize 가져올 개수 (MySQL LIMIT의 두 번째 인자)
     */
    public List<BoardBean> getBoardList(String keyField, String keyWord, int start, int pageSize) {
        // 조회된 데이터를 저장할 ArrayList 객체 생성
        List<BoardBean> list = new ArrayList<>();
        
        // 1. 동적 SQL 생성 준비
        String sql = "SELECT * FROM board ";
        
        // 검색어 존재 여부 판단 (null 체크 및 앞뒤 공백 제거 후 빈 문자열("")인지 확인)
        boolean isSearch = (keyWord != null && !keyWord.trim().isEmpty());

        // 검색 모드일 경우 WHERE 절 추가
        if (isSearch) {
            sql += "WHERE " + keyField + " LIKE ? ";
        }
        
        // 정렬 기준 및 페이징 처리를 위한 LIMIT 절 추가
        sql += "ORDER BY num DESC LIMIT ?, ?";

        /*
         * 2. try-with-resources (자동 자원 반납)
         * - 괄호() 안에 선언된 객체들은 try 블록이 끝나면 자동으로 close()가 호출됩니다.
         * - 별도의 finally 블록에서 자원을 해제할 필요가 없어 메모리 누수 방지에 탁월합니다.
         */
        try (Connection conn = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 3. 파라미터 바인딩 (? 채우기)
            if (isSearch) {
                // 검색 중일 때: ?가 3개 (검색어, 시작위치, 가져올 개수)
                pstmt.setString(1, "%" + keyWord + "%"); // LIKE 연산자를 위한 % 처리
                pstmt.setInt(2, start);
                pstmt.setInt(3, pageSize);
            } else {
                // 일반 목록일 때: ?가 2개 (시작위치, 가져올 개수)
                pstmt.setInt(1, start);
                pstmt.setInt(2, pageSize);
            }

            /* * 4. ResultSet 중첩 try-with-resources
             * - 쿼리 실행 결과인 ResultSet 역시 AutoCloseable 인터페이스를 구현하므로
             * 아래와 같이 선언하면 자동으로 자원이 해제됩니다.
             */
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    BoardBean bb = new BoardBean();
                    // ResultSet의 컬럼 데이터를 DTO(BoardBean)에 매핑
                    bb.setNum(rs.getString("num"));
                    bb.setUserid(rs.getString("userid"));
                    bb.setSubject(rs.getString("subject"));
                    bb.setContent(rs.getString("content"));
                    bb.setRegdate(rs.getString("regdate"));
                    bb.setReadcount(rs.getString("readcount"));
                    
                    list.add(bb); // 완성된 객체를 리스트에 추가
                }
            }
        } catch (Exception e) {
            // 예외 발생 시 에러 경로 출력 (디버깅용)
            e.printStackTrace();
        }
        
        return list; // 조회 결과를 담은 리스트 반환 (데이터가 없으면 비어있는 리스트)
    }

    /**
     * [메서드: getTotalCount]
     * 검색 조건에 부합하는 게시글의 총 개수 조회 (페이징 버튼 계산용)
     */
    public int getTotalCount(String keyField, String keyWord) {
        int total = 0;
        String sql = "SELECT COUNT(num) FROM board ";
        boolean isSearch = (keyWord != null && !keyWord.trim().isEmpty());

        // 검색 중이라면 WHERE 조건 추가 (목록 쿼리와 조건이 동일해야 함)
        if (isSearch) {
            sql += "WHERE " + keyField + " LIKE ?";
        }

        try (Connection con = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            // 검색어가 있을 때만 첫 번째 ?에 검색어 셋팅
            if (isSearch) {
                pstmt.setString(1, "%" + keyWord + "%");
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                // rs.next()가 참이라면 조회된 COUNT 값이 존재한다는 의미
                if (rs.next()) {
                    total = rs.getInt(1); // 첫 번째 컬럼(COUNT 결과)을 가져옴
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return total;
    }
}