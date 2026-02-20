package jsp;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request/jstl")
public class Ch07jstlServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글 인코딩 설정
		// request.setCharacterEncoding("UTF-8");

		// 2. 단일 파라미터 수집
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");

		// 3. 숫자 파마라터 변환 (String -> int)
		int age = (ageStr != null && !ageStr.isEmpty()) ? Integer.parseInt(ageStr) : 0;
		int futureAge = age + 10;

		// 4. 다중 파라미터 수집 (Checkbox)
		String[] hobbies = request.getParameterValues("hobby");
		
		// 5. JSP로 넘길 데이터를 request에 담기
//		request.setAttribute("name", name);
//		request.setAttribute("age", age);
		request.setAttribute("futureAge", futureAge);
		request.setAttribute("hobbies", hobbies);
		
		// 6. 결과를 보여줄 JSP로 이동
		request.getRequestDispatcher("/jsp2/ch07_request/request.jsp")
			   .forward(request, response);
	}

}