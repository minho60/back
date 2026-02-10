package servlet.ch01_서블릿설정및응답기초;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestMethod")
public class Ex03_RequestMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 웹 애플리케이션 루트 경로(=프로젝트 명)
		//request.getContextPath()
		//- 웹 애플리케이션의 루트 경로(Context Root) 반환
		//- 예) 프로젝트명이 my-jsp이면 '/my-jsp'를 반환
		// -> 용도: 서버 내에서 파일 경로나 이동 경로를 동적으로 지정할 때 필수!
	
		// 예: /my-jsp
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().println("Context Path: " + request.getContextPath()+"<br>");
		
		// 2. 서블릿 매핑 경로
		// 예: /requestMethod
		response.getWriter().println("Servlet Path: " + request.getServletPath()+"<br>");
		
		// 3. 
		// 예: 0:0:0:0:0:0:0:1
		response.getWriter().println("localhost: " + request.getRemoteAddr()+"<br>");
		
		// 4. 요청 URI(Uniform Resource Identifier) 정보
		// - 도메인 이후의 경로(쿼리 스트링 포함)
		// 예: /my-jsp/requestMethod
		response.getWriter().println("Request URI: " + request.getRequestURI()+"<br>");
		
		// 5. 요청 URL(Uniform Resource Locator) 정보
		// - 프로토콜://도메인:포트/경로~
		// 예: http://localhost:8080/my-jsp/requestMethod
		response.getWriter().println("Request URL: " + request.getRequestURL()+"<br>");
		
		// 6.요청 메서드 방식
		// 예: GET
		response.getWriter().println("Method: " + request.getMethod()+"<br>");
		
		// 7. 요청 헤더 정보 확인: 브라우저 정보
		// 예: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.0.0 Safari/537.36
		response.getWriter().println("User-Agent: " + request.getHeader("User-Agent")+"<br>");
		
		//8. 바로 이전 페이지 URL 가져오기
		response.getWriter().println("이전페이지:" + request.getHeader("referer")+"<br>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}