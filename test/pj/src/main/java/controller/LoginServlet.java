package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

/**
 * [LoginServlet]
 * 사용자의 로그인 요청과 로그아웃(또는 로그인 페이지 이동)을 처리하는 컨트롤러입니다.
 * @WebServlet("/login")을 통해 "/login" 경로로 들어오는 모든 HTTP 요청을 수신합니다.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * [GET 방식 처리]
	 * 1. 브라우저 주소창에 직접 입력하거나 링크를 클릭하여 접근할 때 호출됩니다.
	 * 2. 주로 로그인 화면(JSP)을 사용자에게 보여주는 역할을 합니다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	    
	    // 필터에서 이미 prevPage를 저장했을 수도 있으므로, 비어있을 때만 Referer 확인
	    if (session.getAttribute("prevPage") == null) {
	        String referer = request.getHeader("Referer");
	        if (referer != null && !referer.contains("/login")) {
	            session.setAttribute("prevPage", referer);
	        }
	    }

		// Forward 방식: 서버 내부에서 "/view/member/login.jsp"로 요청을 전달합니다.
		// 브라우저의 주소창은 "/login"으로 유지된 채 화면만 JSP 내용으로 바뀝니다.
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	}

	/**
	 * [POST 방식 처리]
	 * 1. 로그인 폼(<form method="post">)에서 전송 버튼을 눌렀을 때 호출됩니다.
	 * 2. 아이디와 비밀번호를 검증하고 로그인 성공 여부를 결정합니다.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// 한글 깨짐 방지: 클라이언트가 보낸 데이터의 인코딩을 UTF-8로 지정합니다.
		request.setCharacterEncoding("UTF-8");
		// 응답 형식 설정: 브라우저에 보낼 결과가 HTML이며, UTF-8 문자셋임을 알립니다.
		response.setContentType("text/html; charset=UTF-8");

		// 1. 폼 데이터 수집: <input name="id">와 <input name="pwd">에 입력된 값을 가져옵니다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// 2. 비즈니스 로직 수행: DAO 객체를 생성하여 DB의 회원 정보와 대조합니다.
		MemberDAO mDAO = new MemberDAO();
		boolean result = mDAO.loginMember(id, pwd); // 성공 시 true, 실패 시 false 반환

		// 3. 응답 처리 (성공 또는 실패)
		PrintWriter out = response.getWriter();
		
		if (result) {
			/* [로그인 성공] */
			// 1. 세션 객체 가져오기
		    HttpSession session = request.getSession();
		    // 2. 세션에 이름(또는 ID) 저장하기 
		    // JSP에서 ${sessionScope.userName}으로 부르기로 했으므로 키값을 "userName"으로 맞춥니다.
		    session.setAttribute("userName", id);
			// Redirect 방식: 로그인 성공 후 메인 페이지("/main")로 주소를 옮깁니다.
			// 브라우저에게 "새로운 주소로 다시 요청해!"라고 명령하는 것과 같습니다.
		    // 1. 세션에 저장해둔 이전 페이지 주소를 꺼냅니다.
		    String prevPage = (String) session.getAttribute("prevPage");
		    
		    // 2. 주소가 있으면 그곳으로, 없으면 메인으로 이동
		    if (prevPage != null) {
		        session.removeAttribute("prevPage"); // 사용 후 세션에서 삭제
		        response.sendRedirect(prevPage);
		    } else {
		        response.sendRedirect(request.getContextPath() + "/main");
		    }
		} else {
			/* [로그인 실패] */
			// 자바스크립트를 웹 브라우저로 출력하여 경고창을 띄우고 이전 페이지로 되돌립니다.
//			out.println("<script>");
//			out.println("  alert('아이디 또는 비밀번호가 일치하지 않습니다.');");
//			out.println("  history.back();"); // 이전 페이지(로그인 폼)로 이동
//			out.println("</script>");
			response.sendRedirect(request.getContextPath() + "/WEB-INF/view/member/error.jsp");
		}
		
		// 사용한 스트림 자원을 닫아줍니다.
		out.close();
	}
}