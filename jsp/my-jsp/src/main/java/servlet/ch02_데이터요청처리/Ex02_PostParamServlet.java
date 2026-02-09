package servlet.ch02_데이터요청처리;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getPost")
public class Ex02_PostParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 브라우저(클라이언트)로 요청 신호를 보냈다.(가정)
	/* 
	
		1. Get 방식 요청	
			<form [method="get"]>
			-> 처리는 doGet()
			- HTTP메시지는 URL 쿼리 스트링으로 전송(URL에 모든 정보가 노출됨)
			- 조회, 검색, 링크
			- 북마크, 캐싱 가능
			- 데이터 용량 제한(대략:2000자)
	
		2. Post 방식 요청
			<form method="post">
			-> 처리는 doPost()
			- HTTP 메시지는 요청 본문을 통해 전송
			- 로그인/회원가입, 데이터입력/수정
			- 북마크, 캐싱 불가능
	
	*/
	  
	

//	String name = request.getParameter("name");
//	// Integer.parseInt(): 문자열 -> 숫자
//	int age = Integer.parseInt(request.getParameter("age"));
//	response.setContentType("text/html; charset=UTF-8");
//	response.getWriter().println("이름:" + name + "<br>");
//	response.getWriter().println("나이:" + age);

	// 쿼리 스트링에서 값 읽기
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 단일파라미터
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String username = request.getParameter("username");

		// 문자열 -> 숫자
		// URL에 직접 입력
		int userage = Integer.parseInt(request.getParameter("userage"));

		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<h1>Post 요청 처리</h1>");
		response.getWriter().println("<p>아이디: " + userid + "</p>");
		response.getWriter().println("<p>비밀번호: " + userpw + "</p>");
		response.getWriter().println("<p>이름: " + username + "</p>");
		response.getWriter().println("<p>나이: " + userage + "</p>");
		
		// 2. 다중 파라미터
		// {"독서", "영화", "여행", "게임"}
		String[] values = request.getParameterValues("hobby");
		
		if(values !=null ) {
			for(String val : values) {
				response.getWriter().println("취미:" + val + "<br>");
			}
			
		}
		
	}

}
