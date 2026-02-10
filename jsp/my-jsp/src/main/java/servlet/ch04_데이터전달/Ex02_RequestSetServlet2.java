package servlet.ch04_데이터전달;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/requestSet2")
public class Ex02_RequestSetServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. request 객체에 데이터 담기 (Key-Value 구조)
        // - "info"라는 이름(Key)으로 "보안 데이터"라는 값(Value)을 저장합니다.
        // - 이 데이터는 현재 이 요청(request)이 살아있는 동안(Request Scope)만 유효합니다.
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("info", "보안데이터");
        // 2. 목적지 경로 설정 및 포워딩
        // - getRequestDispatcher("/경로"): 
        //    - 이동할 대상(다른 서블릿이나 JSP)의 경로를 지정합니다.
        // - forward(request, response): 
        //    - 현재 가진 request와 response 객체를 그대로 유지한 채 제어권을 넘깁니다.
        // - [특징] 주소창의 URL은 바뀌지 않지만, 
        // - 실제 실행되는 결과물은 "/requestGet"의 내용이 나옵니다.
		request.getRequestDispatcher("/servlet/ch04/Ex01.jsp").forward(request,response);
		
	}

}
