package servlet.ch04_데이터전달;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/requestGet")
public class Ex01_RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value =(String) request.getAttribute("info");
		// 응답 인코딩 설정
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println(value);
		
		
	}

}
