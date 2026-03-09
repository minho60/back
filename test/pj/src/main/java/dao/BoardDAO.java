package dao;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

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
                    bb.setNum(rs.getInt("num"));
                    bb.setUserid(rs.getString("userid"));
                    bb.setSubject(rs.getString("subject"));
                    bb.setContent(rs.getString("content"));
                    bb.setRegdate(rs.getString("regdate"));
                    bb.setReadcount(rs.getInt("readcount"));
                    
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
    
    /**
     * [조회수 증가 로직]
     * 사용자가 게시글 제목을 클릭하여 상세 보기 페이지로 진입할 때 호출됩니다.
     * @param num 조회수를 올릴 게시글의 고유 번호(Primary Key)
     */
    public void upCount(int num) {
        // 기존의 readcount 값을 1 증가시키는 UPDATE 쿼리
        String sql = "UPDATE board SET readcount = readcount + 1 WHERE num = ?";
        
        // try-with-resources 문법을 사용하여 DB 연결(Connection)과 
        // 쿼리 실행기(PreparedStatement)를 자동으로 close 처리
        try (Connection con = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            // 쿼리의 첫 번째 물음표(?)에 게시글 번호 바인딩
            pstmt.setInt(1, num);
            
            // DB에 데이터 변경 사항 적용 (DML 실행)
            pstmt.executeUpdate();
            
        } catch (Exception e) { 
            // 예외 발생 시 에러 내용을 콘솔에 출력하여 디버깅 지원
            e.printStackTrace(); 
        }
    }

    /**
     * [단일 게시물 상세 조회]
     * 게시글 번호(num)를 기준으로 해당 레코드의 모든 컬럼 데이터를 조회합니다.
     * @param num 조회할 게시글 번호
     * @return 조회된 데이터를 담은 BoardBean 객체 (없으면 null)
     */
    public BoardBean getBoard(int num) {
        BoardBean bean = null;
        String sql = "SELECT * FROM board WHERE num = ?";
        
        try (Connection con = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setInt(1, num);
            
            // SELECT 쿼리 실행 결과인 ResultSet(결과 집합)을 가져옴
            try (ResultSet rs = pstmt.executeQuery()) {
                // 데이터가 존재한다면(rs.next()) 헬퍼 메서드를 통해 객체로 변환(매핑)
                if (rs.next()) {
                    bean = mapResultSetToBean(rs);
                }
            }
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        return bean; // 최종적으로 완성된 DTO 객체 반환
    }

    /**
     * [매핑 헬퍼 메서드: ResultSet -> BoardBean]
     * DB에서 가져온 로우(Row) 데이터를 자바 객체(DTO) 필드에 하나씩 옮겨 담는 역할입니다.
     * 코드의 재사용성을 높이고 중복을 제거하기 위해 별도의 private 메서드로 분리했습니다.
     * @param rs DB 조회 결과가 담긴 ResultSet 객체
     * @throws Exception SQL 데이터 추출 시 발생할 수 있는 예외를 호출부로 던짐
     */
    private BoardBean mapResultSetToBean(ResultSet rs) throws Exception {
        // 데이터를 담을 바구니(Bean) 객체 생성
        BoardBean bb = new BoardBean();
        
        // ResultSet의 컬럼명과 BoardBean의 필드명을 매칭하여 데이터 저장
        // 주의: rs.getString("컬럼명")의 인자는 실제 DB 테이블의 컬럼명과 정확히 일치해야 함
        bb.setNum(rs.getInt("num"));
        bb.setUserid(rs.getString("userid"));   // DB의 'userid' 값을 Bean의 userid 필드에 저장
        bb.setSubject(rs.getString("subject"));
        bb.setContent(rs.getString("content"));
        bb.setRegdate(rs.getString("regdate"));
        bb.setReadcount(rs.getInt("readcount"));
        bb.setFilename(rs.getString("filename"));
        bb.setFilesize(rs.getInt("filesize"));
        bb.setPass(rs.getString("pass"));
        
        return bb; // 데이터가 꽉 채워진 객체 반환
    }
    
    // 정적 자원 경로 설정
    private static final String UPLOAD_DIR = "static/assets";
    
    /**
     * [글 쓰기 및 파일 업로드 처리]
     * @param request 컨트롤러(Servlet)로부터 전달받은 요청 객체
     * (멀티파트 데이터를 포함하고 있어야 함)
     */
    public void insertBoard(HttpServletRequest request) {
        // 1. 서버 내 실제 파일이 저장될 물리적 경로 설정
        // getRealPath("/")는 웹 애플리케이션의 루트(webapp) 경로를 반환함
        String savePath = request.getServletContext().getRealPath("/" + UPLOAD_DIR);
        System.out.println("파일이 저장된 진짜 경로: " + savePath);
        
        // DB에 저장할 파일 관련 변수 초기화
        String filename = null;
        int filesize = 0;
        
        try {
            // 2. 파일 처리 (Part 인터페이스 사용)
            // Servlet의 @MultipartConfig 설정이 있어야 getPart() 사용 가능
            Part filePart = request.getPart("filename"); // JSP의 <input type="file" name="filename">
            
            // 사용자가 파일을 첨부했는지 확인
            if (filePart != null && filePart.getSize() > 0) {
                // 제출된 파일에서 순수 파일명만 추출 (경로 제외)
                filename = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                filesize = (int) filePart.getSize(); // 파일 크기 (byte 단위)
                
                // 저장 디렉토리가 없으면 생성 (mkdirs: 상위 폴더까지 한 번에 생성)
                File dir = new File(savePath);
                if (!dir.exists()) dir.mkdirs();
                
                // 서버 컴퓨터의 해당 경로에 파일 물리적으로 저장
                // File.separator는 운영체제별 경로 구분자(\ 또는 /)를 자동으로 맞춰줌
                filePart.write(savePath + File.separator + filename);
            }

            // 3. 데이터베이스 저장용 SQL (Java 15+ 텍스트 블록 사용)
            // regdate는 DB의 현재 시간 함수인 NOW()를 활용
            String sql = """
                INSERT INTO board(userid, content, subject, regdate, pass, readcount, filename, filesize)
                VALUES (?, ?, ?, NOW(), ?, 0, ?, ?)
                """;

            // 4. JDBC 자원 관리 (try-with-resources)
            try (Connection conn = DBConnectionMgr.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                /* [파라미터 바인딩]
                 * 1: userid  <- JSP의 name="userid"
                 * 2: content <- JSP의 name="content"
                 * 3: subject <- JSP의 name="subject"
                 * 4: pass    <- JSP의 name="pass"
                 * 5: filename <- 위에서 추출한 파일명 (없으면 null)
                 * 6: filesize <- 위에서 추출한 파일크기 (없으면 0)
                 */
                pstmt.setString(1, request.getParameter("userid")); 
                pstmt.setString(2, request.getParameter("content"));
                pstmt.setString(3, request.getParameter("subject"));
                pstmt.setString(4, request.getParameter("pass"));
                pstmt.setString(5, filename);
                pstmt.setInt(6, filesize);
                
                // SQL 실행 (영향을 받은 행의 개수 반환)
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            // 파일 업로드 실패나 DB 오류 발생 시 스택 트레이스 출력
            e.printStackTrace();
        }
    }
    
    /**
     * [게시물 수정 로직]
     * 사용자가 수정한 내용을 데이터베이스에 최종 반영합니다.
     * @param bean 사용자가 입력한 수정 데이터(작성자ID, 제목, 내용, 글번호)가 담긴 객체
     */
    public void updateBoard(BoardBean bean) {
        // 1. SQL 쿼리 작성
        // UPDATE [테이블명] SET [컬럼=값] WHERE [조건]
        // 특정 번호(num)의 레코드를 찾아 작성자, 제목, 내용을 변경합니다.
        String sql = "UPDATE board SET userid=?, subject=?, content=? WHERE num=?";
        
        // 2. try-with-resources 문법 사용
        // Connection과 PreparedStatement를 자동으로 close 하여 메모리 누수를 방지합니다.
        try (Connection conn = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // 3. 위치 홀더(?)에 데이터 매핑 (순서 엄격 준수)
            // 첫 번째 ?: 작성자 ID (userid)
            pstmt.setString(1, bean.getUserid());
            
            // 두 번째 ?: 수정된 제목 (subject)
            pstmt.setString(2, bean.getSubject());
            
            // 세 번째 ?: 수정된 내용 (content)
            pstmt.setString(3, bean.getContent());
            
            // 네 번째 ?: 수정 대상 게시글의 고유 번호 (num)
            // WHERE 절에 들어가는 PK(Primary Key)이므로 매우 중요합니다.
            pstmt.setInt(4, bean.getNum());
            
            // 4. 쿼리 실행
            // executeUpdate()는 데이터의 변경(INSERT, UPDATE, DELETE)이 일어날 때 사용하며,
            // 성공적으로 변경된 레코드의 개수를 반환합니다.
            pstmt.executeUpdate();
            
        } catch (Exception e) { 
            // SQL 문법 오류, DB 연결 실패 등 예외 발생 시 콘솔에 출력
            e.printStackTrace(); 
        }
    }
    
 // 게시글 삭제 메서드: DB 데이터와 서버에 저장된 파일을 모두 삭제합니다.
    public void deleteBoard(int num, HttpServletRequest req) {
        // 1. 파일이 저장된 서버의 실제 물리적 경로를 가져옵니다.
        // UPLOAD_DIR은 보통 상수로 선언된 저장 폴더명입니다.
        String savePath = req.getServletContext().getRealPath("/" + UPLOAD_DIR);

        // 2. DB 연결 및 PreparedStatement 객체를 생성합니다 (try-with-resources 사용으로 자동 자원 반납).
        try (Connection conn = DBConnectionMgr.getConnection();
             // 삭제 전, 게시글에 첨부된 파일명을 확인하기 위한 SELECT 쿼리 준비
             PreparedStatement pstmt1 = conn.prepareStatement("SELECT filename FROM board WHERE num=?")) {
            
            pstmt1.setInt(1, num);
            
            // 3. 첨부파일 유무를 확인하고 실제 파일을 삭제합니다.
            try (ResultSet rs = pstmt1.executeQuery()) {
                if (rs.next()) {
                    String filename = rs.getString("filename");
                    
                    // 파일명이 존재하고 공백이 아닐 경우에만 실행
                    if (filename != null && !filename.isBlank()) {
                        // 파일 객체를 생성하여 해당 경로에 파일이 실제로 존재하는지 확인 후 삭제
                        File file = new File(savePath + File.separator + filename);
                        if (file.exists()) {
                            file.delete(); // 서버 로컬 스토리지에서 파일 삭제
                        }
                    }
                }
            }

            // 4. DB에서 게시글 레코드를 삭제합니다.
            try (PreparedStatement pstmt2 = conn.prepareStatement("DELETE FROM board WHERE num=?")) {
                pstmt2.setInt(1, num);
                pstmt2.executeUpdate(); // DB	 데이터 삭제 실행
            }
            
        } catch (Exception e) { 
            // 예외 발생 시 스택 트레이스를 출력하여 디버깅을 돕습니다.
            e.printStackTrace(); 
        }
    }
    
} // boardDAO의 끝