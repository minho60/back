package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberBean;

/**
 * @WebServlet("/register")
 * 클라이언트가 브라우저 주소창이나 <form action="...">을 통해 
 * "/register" 경로로 요청을 보내면 이 서블릿이 실행됩니다.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Forward 방식: 서버 내부에서 "/view/login/login.jsp"로 요청을 전달합니다.
		// 브라우저의 주소창은 "/login"으로 유지된 채 화면만 JSP 내용으로 바뀝니다.
		request.getRequestDispatcher("/view/member/register.jsp").forward(request, response);
    }

    /**
     * POST 방식의 요청을 처리하는 메서드입니다.
     * 회원가입 폼에서 <form method="post">로 보냈기 때문에 doPost가 호출됩니다.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. 인코딩 설정: 클라이언트가 보낸 한글 데이터가 깨지지 않도록 설정합니다.
        request.setCharacterEncoding("UTF-8");
        
        // 2. 파라미터 수집: JSP의 <input name="userid">에 입력된 값을 가져옵니다.
        String userid = request.getParameter("userid");
        String userpw = request.getParameter("userpw");
        
        // 3. 유효성 검사 (Validation): 아이디가 비어있는지 체크합니다.
        // 비어있다면 가입을 진행하지 않고 다시 회원가입 페이지로 돌려보냅니다.
        if(userid == null || userid.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/view/member/register.jsp");
            return; // 리다이렉트 후 아래 코드가 실행되지 않도록 반드시 종료(return)해야 합니다.
        }

        // 4. 데이터 묶기 (DTO 객체화): 수집한 데이터를 MemberBean 객체에 담습니다.
        MemberBean bean = new MemberBean();
        bean.setId(userid);
        bean.setPwd(userpw);
        
        // 5. 비즈니스 로직 수행 (DAO 호출): DB 처리를 담당하는 DAO 객체를 생성하고 저장 메서드를 호출합니다.
        MemberDAO md = new MemberDAO();
        boolean result = md.insertMember(bean); // DB 저장 성공 시 true 반환

        // 6. 응답 처리 및 페이지 이동 (Navigation)
        if (result) {
            // 회원가입 성공: 성공 안내 페이지(success.jsp)로 이동시킵니다.
            // request.getContextPath()는 컨텍스트 루트 경로(예: /myProject)를 의미합니다.
            response.sendRedirect(request.getContextPath() + "/view/member/success.jsp");
        } else {
            // 회원가입 실패: DB 오류 등이 발생했을 때 에러 페이지로 이동시킵니다.
            response.sendRedirect(request.getContextPath() + "/view/member/error.jsp");
        }
    }
}
