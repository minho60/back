package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

// 1. URL 매핑: 브라우저에서 /member/idcheck 로 요청하면 이 서블릿이 실행됨
@WebServlet("/member/idcheck")
public class MemberIdCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 2. 요청 파라미터 받기
        String id = request.getParameter("id");
        
        // 3. 비즈니스 로직 처리 (DB 조회)
        MemberDAO mDAO = new MemberDAO();
        boolean result = mDAO.checkId(id); // true: 중복, false: 사용가능
        
        // 4. 결과를 request 영역에 저장 (JSP에서 사용하기 위함)
        request.setAttribute("result", result);
        request.setAttribute("inputId", id);
        
        // 5. 뷰(JSP)로 포워딩 (URL은 변하지 않고 내부적으로 이동)
        // WEB-INF 내부에 있어도 포워딩으로는 접근 가능
        request.getRequestDispatcher("/view/member/member_idcheck.jsp").forward(request, response);
    }
}
