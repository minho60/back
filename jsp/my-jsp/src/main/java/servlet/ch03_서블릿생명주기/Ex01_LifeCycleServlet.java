package servlet.ch03_서블릿생명주기;

import jakarta.servlet.ServletConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lifeCycle")
public class Ex01_LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * 서블릿의 생명주기 1. init() 2. service() 3. doGet()또는 doPost() 4. destroy()
	 * 
	 * 
	 */

	// 1. init()
	// - 서블릿 컨테이너가 객체를 최초 1회 생성 후 호출
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출: 서블릿 생성");
	}

	// 2.service()
	// - 클라잉너트 요청이 있을 때마다 호출
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("service 실행");
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("doGet() 실행");
		response.getWriter().println("init() 테스트");
		doPost(request, response);
		response.getWriter().println("요청메서드:"+ request.getMethod());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("doPost() 실행");
		response.getWriter().println("Commonly processed in doPost()");
		
	}
	// 톰캣을 강제종료하면 destroy() 메서드가 호출되고, 서버가 종료된다.
	public void destroy() {
		System.out.println("destroy() 호출: 서블릿 소멸");
	}
}
