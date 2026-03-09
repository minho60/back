package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberBean;

/**
 * [LoginServlet]
 * 사용자의 로그인 요청 처리 및 로그인 페이지 이동을 담당하는 컨트롤러입니다.
 * @WebServlet("/login") : 브라우저에서 /login 경로로 들어오는 요청을 이 서블릿과 매핑합니다.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * [GET 방식 처리]
	 * 사용자가 로그인 페이지에 처음 접속할 때(주소창 입력, 링크 클릭 등) 호출됩니다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		/*
		 * [Forward 이동]
		 * - 서버 내부에서 주소 이동 없이 화면만 /view/login/login.jsp의 내용을 보여줍니다.
		 * - 브라우저 주소창은 여전히 /login으로 표시됩니다.
		 */
		request.getRequestDispatcher("/view/member/login.jsp").forward(request, response);
	}

	/**
	 * [POST 방식 처리]
	 * 로그인 폼(login.jsp)에서 사용자가 아이디/비밀번호를 입력하고 '로그인' 버튼을 눌렀을 때 호출됩니다.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// 1. 인코딩 설정: 클라이언트로부터 전달받은 한글 데이터가 깨지지 않도록 UTF-8로 설정합니다.
		request.setCharacterEncoding("UTF-8");
		
		// 2. 응답 형식 설정: 서버가 클라이언트(브라우저)에게 보낼 컨텐츠가 HTML이며 UTF-8임을 지정합니다.
		response.setContentType("text/html; charset=UTF-8");

		// 3. 폼 데이터 수집: <input name="id">와 <input name="pwd">에 입력된 값을 가져옵니다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// 4. 비즈니스 로직 수행: DAO(Data Access Object)를 통해 DB에 해당 정보가 있는지 확인합니다.
		MemberDAO mDAO = new MemberDAO();
		MemberBean loginUser = mDAO.loginCheck(id, pwd); // 수정된 메서드 호출

		// 5. 응답 처리 객체 생성: 자바스크립트 등을 브라우저에 직접 출력하기 위한 통로입니다.
		PrintWriter out = response.getWriter();
		
		if (loginUser != null) {
			/* [로그인 성공 시] */
			
			// (중요) 세션 생성: 로그인 상태를 유지하기 위해 서버 메모리에 사용자 정보를 저장합니다.
			// 현재 코드에서는 리다이렉트만 수행하므로, 아래와 같은 세션 설정 코드가 추가되는 것이 일반적입니다.
			HttpSession session = request.getSession();
			
			// 핵심: id가 아닌 loginUser.getName()을 세션에 저장!
		    session.setAttribute("idKey", loginUser.getId());
		    session.setAttribute("userName", loginUser.getName());
			
		 // --- 자동 로그인 로직 추가 ---
		 // 1. 체크박스 확인: <input type="checkbox" name="rememberMe">의 선택 여부를 가져옵니다.
		 // 체크가 되어 있다면 "on"이라는 문자열이 넘어옵니다.
		 String rememberMe = request.getParameter("rememberMe");

		 if (rememberMe != null && rememberMe.equals("on")) {
		     
		     /* 2. 고유 식별값(Token) 생성
		      * 사용자를 식별할 랜덤한 값을 생성합니다. 
		      * 여기서는 현재 세션 ID를 사용했지만, 보안을 더 강화하려면 UUID.randomUUID() 사용을 권장합니다.
		      */
		     String sessionKey = request.getSession().getId(); 
		     
		     /* 3. 만료 시간 설정
		      * 현재 시간으로부터 7일 후의 시간을 계산합니다.
		      * 1000L(1초) * 60(1분) * 60(1시간) * 24(하루) * 7 = 7일
		      * java.sql.Timestamp는 DB의 DATETIME 또는 TIMESTAMP 컬럼과 호환됩니다.
		      */
		     long limitTime = System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 7);
		     java.sql.Timestamp sessionLimit = new java.sql.Timestamp(limitTime);

		     // 4. DB 업데이트: 해당 사용자의 레코드에 토큰값과 만료 시간을 저장합니다.
		     // 나중에 사용자가 재접속했을 때 이 토큰을 보고 누군지 찾아냅니다.
		     mDAO.keepLogin(id, sessionKey, sessionLimit);

		     /* 5. 쿠키(Cookie) 생성 및 전송
		      * 생성된 토큰을 "loginCookie"라는 이름으로 브라우저에 저장합니다.
		      */
		    Cookie loginCookie = new Cookie("loginCookie", sessionKey);
		     
		     // - setPath("/"): 프로젝트 전체 경로에서 이 쿠키를 사용할 수 있도록 설정합니다.
		     loginCookie.setPath("/");
		     
		     // - setMaxAge: 쿠키의 수명을 설정합니다 (초 단위). 7일 뒤 브라우저에서 자동 삭제됩니다.
		     loginCookie.setMaxAge(60 * 60 * 24 * 7); 
		     
		     // - setHttpOnly(true): 자바스크립트(document.cookie)로 쿠키 접근을 차단합니다. (XSS 공격 방어)
		     loginCookie.setHttpOnly(true); 
		     
		     // 응답 헤더에 쿠키를 담아 브라우저로 보냅니다.
		     response.addCookie(loginCookie);
		 }
			
			/*
			 * [Redirect 이동]
			 * - 브라우저에게 "새로운 주소(/main)로 다시 접속해!"라고 명령합니다.
			 * - 주소창이 /main으로 변경되며, 새로고침 시 중복 로그인 요청이 발생하는 것을 방지합니다.
			 */
			response.sendRedirect(request.getContextPath() + "/main");
			
		} else {
			/* [로그인 실패 시] */
			
			// 자바스크립트를 사용하여 사용자에게 알림창(alert)을 띄우고 이전 페이지로 돌려보냅니다.
			out.println("<script>");
			out.println("  alert('아이디 또는 비밀번호가 일치하지 않습니다.');");
			out.println("  history.back();"); // 브라우저의 '뒤로가기'와 동일한 동작
			out.println("</script>");
		}
		
		// 자원 해제: 출력을 위해 사용한 스트림을 닫아줍니다.
		out.close();
	}
}