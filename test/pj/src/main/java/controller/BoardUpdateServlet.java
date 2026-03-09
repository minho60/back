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
 * [BoardUpdateServlet]
 * 역할: 
 * 1. (GET) 수정할 기존 데이터를 DB에서 읽어와 수정 폼(JSP)에 뿌려줍니다.
 * 2. (POST) 사용자가 수정한 데이터와 비밀번호를 받아 검증 후 DB를 업데이트합니다.
 */
@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * [GET 방식: 수정 화면 진입]
     * 사용자가 '수정' 버튼을 클릭했을 때 작동합니다.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. 수정할 게시글 번호를 파라미터로 수집
        // read.jsp의 수정 링크(?num=79...)에서 전달된 값을 int로 변환
        int num = Integer.parseInt(request.getParameter("num"));
        
        // 2. 비즈니스 로직: DB에서 최신 데이터 조회
        // 수정 폼에는 기존에 작성된 제목, 내용 등이 채워져 있어야 하므로 DAO를 통해 다시 가져옴
        BoardDAO bDAO = new BoardDAO();
        BoardBean bb = bDAO.getBoard(num);
        
        // 3. 데이터 바인딩 및 화면 이동
        // 조회된 bean 객체를 'bb'라는 이름으로 request에 담아 update.jsp로 전달
        HttpSession session = request.getSession();
        session.setAttribute("bb", bb);
        request.getRequestDispatcher("/WEB-INF/view/board/update.jsp").forward(request, response);
    }

    /**
     * [POST 방식: 실제 데이터 처리]
     * 수정 폼(update.jsp)에서 '수정 완료' 버튼을 눌러 데이터를 전송했을 때 작동합니다.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. 요청 인코딩(한글 깨짐 방지) 및 응답 설정(자바스크립트 실행용)
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter(); // 실패 시 안내 문구(JS) 출력용

        BoardDAO bDAO = new BoardDAO();
        
        // 2. 검증용 원본 데이터 확보
        // BoardReadServlet 또는 doGet 단계에서 세션에 저장된 원본 'bb' 객체를 가져옴
        // (입력한 비번과 DB의 실제 비번을 비교하기 위함)
        BoardBean sessionBean = (BoardBean) session.getAttribute("bb");
        
        // 3. 리스트 복귀를 위한 현재 페이지 번호 수집
        String nowPage = request.getParameter("nowPage");
        
        // 4. 사용자가 폼에서 입력한 "수정된 데이터" 수집 (DTO 객체 생성)
        BoardBean upBean = new BoardBean();
        upBean.setNum(Integer.parseInt(request.getParameter("num"))); // Hidden으로 넘겨받은 글 번호
        upBean.setUserid(request.getParameter("userid"));             // 수정된(혹은 고정된) 작성자 ID
        upBean.setSubject(request.getParameter("subject"));           // 수정된 제목
        upBean.setContent(request.getParameter("content"));           // 수정된 내용
        upBean.setPass(request.getParameter("pass"));                 // 본인 확인용 입력 비번

        /*
         * 5. 비밀번호 검증 (데이터 무결성 및 보안)
         * - sessionBean: DB에 저장된 원래 정보
         * - upBean: 방금 사용자가 입력한 정보
         */
        System.out.println("upBean.getPass: " + upBean.getPass());
        System.out.println("sessionBean.getPass: " + sessionBean.getPass());
        if (sessionBean != null && upBean.getPass().equals(sessionBean.getPass())) {
            
            // [검증 성공] 
            // DB에 업데이트 쿼리 실행 (UPDATE board SET subject=?... WHERE num=?)
            bDAO.updateBoard(upBean);
            
            // [성공 후 처리]
            // 수정이 반영된 게시글의 상세 보기(read) 페이지로 강제 이동(Redirect)
            // Redirect를 사용하는 이유: 새로고침 시 중복 수정 요청 방지
            String url = request.getContextPath() + "/board/read?nowPage=" + nowPage + "&num=" + upBean.getNum();
            response.sendRedirect(url);
            
        } else {
            // [검증 실패] 비밀번호 불일치 시 안내 메시지 후 이전 페이지로 복구
            out.println("<script>");
            out.println("  alert('비밀번호가 일치하지 않습니다.');");
            out.println("  history.back();");
            out.println("</script>");
        }
        out.close();
    }
}