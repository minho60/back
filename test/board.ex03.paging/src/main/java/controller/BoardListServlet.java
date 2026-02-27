package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardBean;

/**
 * [BoardListServlet]
 * 게시판 목록을 페이징 처리하여 보여주는 컨트롤러입니다.
 * URL: /board/list?page=번호 형태의 요청을 처리합니다.
 */
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. DAO 객체 생성: DB 접근을 위한 도구를 준비합니다.
        BoardDAO dao = new BoardDAO();

        // 2. 현재 페이지 번호 파악
        // 사용자가 ?page=2 라고 접속하면 "2"를 가져오고, 처음 접속해서 파라미터가 없으면 "1"을 기본값으로 설정합니다.
        String pageParam = request.getParameter("page");
        int currentPage = (pageParam == null) ? 1 : Integer.parseInt(pageParam);
        
        // 3. 한 페이지에 보여줄 게시글 개수 설정 및 시작점 계산
        int pageSize = 10; // 한 페이지당 10개씩 출력
        
        /* * [핵심 페이징 공식]
         * MySQL의 LIMIT은 0번부터 시작합니다.
         * 1페이지 요청 시: (1 - 1) * 10 = 0 (0번부터 10개 가져옴)
         * 2페이지 요청 시: (2 - 1) * 10 = 10 (10번부터 10개 가져옴)
         */
        int start = (currentPage - 1) * pageSize; 
        
        // 4. 데이터베이스에서 데이터 추출
        // dao.getBoardList(시작위치, 가져올개수) 호출
        List<BoardBean> list = dao.getBoardList(start, pageSize);
        
        // 전체 데이터 개수를 알아야 전체 페이지 수를 계산할 수 있습니다.
        int totalCount = dao.getTotalCount(); 
        
        // 5. 전체 페이지 수 계산 (올림 처리)
        /*
         * 만약 총 게시글이 85개라면? 85 / 10 = 8.5 이고 올림(ceil) 하면 9페이지가 됩니다.
         * (double)로 형변환을 해야 소수점이 살아나 정확한 계산이 가능합니다.
         */
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);

        // 6. View(JSP)에서 사용할 수 있도록 데이터를 request 영역에 저장
        // key-value 형태로 담아 보내면 JSP에서 ${key}로 꺼내 씁니다.
        request.setAttribute("list", list);           // 현재 페이지에 보여줄 글 리스트
        request.setAttribute("currentPage", currentPage); // 현재 페이지 번호
        request.setAttribute("totalPages", totalPages);   // 총 페이지 개수
        request.setAttribute("count", totalCount);        // 전체 게시글 수 (통계용)

        // 7. 결과를 보여줄 화면(JSP)으로 데이터 보따리를 들고 이동합니다.
        request.getRequestDispatcher("/view/board/list.jsp").forward(request, response);
    }
}