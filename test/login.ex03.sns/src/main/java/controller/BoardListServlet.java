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
 * 역할: 사용자의 게시판 목록 요청을 해석하고, DAO를 통해 데이터를 가져와 JSP로 전달합니다.
 * 처리 내용: 검색 기능 처리, 페이징 계산, 데이터 바인딩 및 포워딩
 */
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. 데이터베이스 비즈니스 로직을 수행할 DAO 객체 생성
        BoardDAO bd = new BoardDAO();

        /*
         * 2. 검색 파라미터 수집
         * - keyField: 검색 범주 (예: userid, subject, content)
         * - keyWord: 실제 검색어 (예: '에그마요')
         * - 검색 버튼을 누르지 않고 처음 목록에 진입했을 때는 두 값 모두 null이 됩니다.
         */
        String keyField = request.getParameter("keyField");
        String keyWord = request.getParameter("keyWord");

        /*
         * 3. 페이징 설정 및 현재 페이지 파악
         * - 사용자가 하단 페이지 번호를 클릭하면 ?page=3 같은 형태로 파라미터가 들어옵니다.
         * - 파라미터가 없으면(null) 게시판 첫 방문이므로 기본값 1페이지로 설정합니다.
         */
        String pageParam = request.getParameter("page");
        int currentPage = (pageParam == null) ? 1 : Integer.parseInt(pageParam);
        
        int pageSize = 10; // 한 페이지에 보여줄 게시글의 개수
        
        // SQL의 LIMIT 절에서 사용할 시작 인덱스 계산 (0부터 시작)
        // 1페이지 -> 0, 2페이지 -> 10, 3페이지 -> 20 ...
        int start = (currentPage - 1) * pageSize;
        
        /*
         * 4. DAO 호출 - 검색 조건과 페이징 정보를 인자로 전달
         * - getBoardList: 실제 화면에 뿌릴 10개의 게시글 리스트를 가져옵니다.
         * - getTotalCount: 검색 결과에 해당하는 전체 게시글 수를 가져옵니다. (페이징 버튼 생성용)
         */
        List<BoardBean> list = bd.getBoardList(keyField, keyWord, start, pageSize);
        int totalCount = bd.getTotalCount(keyField, keyWord);
        
        /*
         * 5. 전체 페이지 수 계산
         * - 총 게시글이 85개라면 8.5 -> 올림하여 9페이지가 필요합니다.
         * - (double) 형변환을 하지 않으면 정수 나눗셈 결과(8)가 나오므로 주의해야 합니다.
         */
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);

        /*
         * 6. View(JSP)로 데이터 전달
         * - request 객체에 담긴 데이터는 포워딩된 JSP에서 EL(${ }) 문법으로 꺼낼 수 있습니다.
         * - keyField와 keyWord를 다시 전달하는 이유: 검색 후에도 검색창과 페이지 링크에 검색 상태를 유지하기 위함입니다.
         */
        request.setAttribute("list", list);           // 검색/페이징된 글 목록
        request.setAttribute("currentPage", currentPage); // 현재 보고 있는 페이지
        request.setAttribute("totalPages", totalPages);   // 총 페이지 번호 개수
        request.setAttribute("count", totalCount);        // 전체 결과 건수
        request.setAttribute("keyField", keyField);       // 검색 필드 유지용
        request.setAttribute("keyWord", keyWord);         // 검색어 유지용

        // 7. 결과를 출력할 View(list.jsp)로 이동 (제어권을 넘김)
        request.getRequestDispatcher("/view/board/list.jsp").forward(request, response);
    }
}