package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardBean;

/**
 * [BoardReadServlet]
 * 역할: 특정 게시글의 번호를 받아 조회수를 1 증가시키고, 
 * 해당 글의 전체 데이터를 가져와 상세 보기 화면(read.jsp)으로 전달합니다.
 */
@WebServlet("/board/read")
public class BoardReadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * [GET 방식 요청 처리]
     * 목록 페이지에서 제목을 클릭했을 때 호출됩니다. (예: /board/read?num=75&nowPage=1...)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. 한글 인코딩 설정 (요청 파라미터 중 검색어 한글 깨짐 방지)
        request.setCharacterEncoding("UTF-8");
        
        // 2. 파라미터 수집
        // num: 어떤 글을 읽을지 결정하는 핵심 PK (String을 int로 형변환)
        int num = Integer.parseInt(request.getParameter("num"));
        
        // 아래 항목들은 '목록으로 돌아가기' 기능을 위해 상태를 유지해야 하는 정보들입니다.
        String nowPage = request.getParameter("nowPage"); // 현재 페이지 번호
        String keyField = request.getParameter("keyField"); // 검색 필드
        String keyWord = request.getParameter("keyWord");   // 검색어

        // 3. 비즈니스 로직 수행 (Model 호출)
        BoardDAO bd = new BoardDAO();
        
        // [로직 A] 조회수 증가: 사용자가 클릭했으므로 해당 글의 readcount를 +1 함
        bd.upCount(num);
        
        // [로직 B] 게시물 상세 조회: DB에서 해당 번호(num)의 레코드를 BoardBean 객체로 가져옴
        BoardBean bb = bd.getBoard(num);

        // 4. JSP에 필요한 데이터 바인딩 (Attribute 저장)
        // 서블릿에서 만든 객체(bb)와 페이지 정보들을 JSP에서 쓸 수 있도록 별명을 붙여 저장함
        request.setAttribute("bb", bb);           // 게시글 본문 데이터
        request.setAttribute("nowPage", nowPage);   // 뒤로가기용 페이지 번호
        request.setAttribute("keyField", keyField); // 뒤로가기용 검색 조건
        request.setAttribute("keyWord", keyWord);   // 뒤로가기용 검색어

        /*
         * 5. JSP로 포워딩 (View 전환)
         * - Dispatcher를 사용하여 /view/board/read.jsp 화면으로 이동합니다.
         * - 주소창의 주소는 /board/read로 유지되면서 화면만 바뀝니다.
         */
        request.getRequestDispatcher("/view/board/read.jsp").forward(request, response);
    }
}