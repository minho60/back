package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;

/**
 * [BoardPostServlet]
 * 역할: 게시글 작성 폼 화면을 띄워주고(GET), 작성된 내용을 DB에 저장(POST)합니다.
 * 특히 파일 업로드를 위한 @MultipartConfig 설정이 핵심입니다.
 */


/* B(byte) -> 1000B = 1kB -> 1000kB = 1MB
 * * [@MultipartConfig] 
 * 서블릿 3.0부터 지원하는 설정으로, form의 enctype="multipart/form-data" 형식을 처리할 수 있게 함
 * - fileSizeThreshold: 이 크기(1MB)를 넘으면 임시 디렉토리에 파일 저장
 * - maxFileSize: 개별 파일당 최대 크기 제한 (10MB)
 * - maxRequestSize: 전체 요청(여러 파일 + 텍스트)의 최대 크기 제한 (15MB)
 */
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1, 
    maxFileSize = 1024 * 1024 * 10,      
    maxRequestSize = 1024 * 1024 * 15    
)
@WebServlet("/board/post")
public class BoardPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * [GET 방식 요청 처리]
     * 사용자가 "글쓰기" 버튼을 눌렀을 때 실행됩니다.
     * 단순히 글쓰기 입력 폼(JSP) 화면을 보여주는 역할을 수행합니다.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // JSP 화면으로 이동 (포워딩)
        request.getRequestDispatcher("/WEB-INF/view/board/post.jsp").forward(request, response);
    }

    /**
     * [POST 방식 요청 처리]
     * 사용자가 폼에 내용을 입력하고 "등록하기" 버튼을 눌렀을 때 실행됩니다.
     * 실제 데이터(텍스트 + 파일)를 수집하여 DB에 저장하는 로직을 수행합니다.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. 인코딩 설정: 한글 깨짐 방지 (POST 방식 필수)
        request.setCharacterEncoding("UTF-8");
        
        // 2. 비즈니스 로직 수행 (Model 호출)
        // DAO에게 request 객체를 통째로 넘겨서 파라미터 추출 및 파일 저장을 위임합니다.
        BoardDAO bd = new BoardDAO();
        bd.insertBoard(request);
        
        /*
         * 3. 처리 후 페이지 이동 (Redirect)
         * - Forward가 아닌 Redirect를 사용하는 이유: 
         * 새로고침 시 중복 게시글 작성을 방지하기 위함 (PRG 패턴: Post-Redirect-Get)
         * - 이동 주소: 단순 JSP 파일이 아닌, 목록을 다시 읽어오는 서블릿(/board/list)으로 이동
         */
        response.sendRedirect(request.getContextPath() + "/board/list");
    }
}