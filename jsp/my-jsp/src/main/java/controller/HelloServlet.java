package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
 * web.xml 또는 @WebServlet("URL 맵핑 주소") 애노테이션
 * http://localhost:8080/프로젝트명/URL맵핑
 * http://localhost:8080/my-jsp/hello  
 * 
 */

@WebServlet("/hello1")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello JSP");
		response.getWriter().println("Hello JSP");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
