package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import dto.BoardBean;

/**
 * [BoardDeleteServlet]
 * 역할: 
 * 1. (GET) 삭제를 위해 비밀번호를 입력받는 화면(delete.jsp)으로 연결합니다.
 * 2. (POST) 입력한 비밀번호가 DB에 저장된 비번과 일치하는지 검증 후 게시물을 삭제합니다.
 */
@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * [GET 방식: 삭제 폼 호출]
     * 상세 보기(read.jsp)에서 '삭제' 버튼 링크를 클릭했을 때 작동합니다.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 상세 보기(read.jsp)에서 전달한 num(글번호)과 nowPage(현재페이지) 파라미터는
        // Forward 방식을 통해 delete.jsp까지 그대로 전달됩니다.
        request.getRequestDispatcher("/view/board/delete.jsp").forward(request, response);
    }

    /**
     * [POST 방식: 실제 삭제 수행]
     * 삭제 폼(delete.jsp)에서 비밀번호 입력 후 '삭제완료' 버튼을 눌렀을 때 작동합니다.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. 인코딩 및 응답 설정
        request.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지
        response.setContentType("text/html; charset=UTF-8"); // 자바스크립트 출력 설정

        // 2. 파라미터 수집
        int num = Integer.parseInt(request.getParameter("num")); // 삭제할 대상의 PK
        String nowPage = request.getParameter("nowPage");        // 삭제 후 돌아갈 페이지 번호
        String inPass = request.getParameter("pass");           // 사용자가 입력한 확인용 비번

        // 3. 세션에서 원본 게시물 정보 추출
        // BoardReadServlet에서 상세보기 시 session.setAttribute("bb", bb)로 저장한 객체를 가져옵니다.
        BoardDAO bd = new BoardDAO();
        BoardBean bb = bd.getBoard(num);
        HttpSession session = request.getSession();
        BoardBean bean = (BoardBean) session.getAttribute("bb"); 
        
        PrintWriter out = response.getWriter(); // 알림창 출력을 위한 객체
        
        /*
         * 4. 비밀번호 검증 (보안 로직)
         * - bean: 상세 보기 시 DB에서 읽어와 세션에 보관한 '진짜 데이터'
         * - inPass: 방금 사용자가 폼에 입력한 '비밀번호'
         */
        if (bb != null && inPass.equals(bb.getPass())) {
            
            // [검증 성공] DB 및 파일 삭제 실행
            BoardDAO bDAO = new BoardDAO();
            
            // DAO 내부에서 DB 레코드 삭제는 물론, 업로드된 파일이 있다면 서버 폴더에서도 삭제 처리함
            bDAO.deleteBoard(num, request);
            
            // [삭제 후 처리] 
            // 삭제가 완료되면 게시글이 사라졌으므로 목록(/board/list)으로 이동
            // 이때 읽고 있던 페이지 번호를 넘겨주어 사용자 경험 유지
            response.sendRedirect(request.getContextPath() + "/board/list?nowPage=" + nowPage);
            
        } else {
            // [검증 실패] 비밀번호 불일치 시 자바스크립트로 경고 메시지 출력
            out.println("<script>");
            out.println("  alert('입력하신 비밀번호가 일치하지 않습니다.');");
            out.println("  history.back();"); // 다시 비밀번호 입력창으로 되돌림
            out.println("</script>");
        }
        out.close(); // 자원 반납
    }
}