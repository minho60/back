package jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ch08/request")
public class Ch08Ex02RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩 설정
		request.setCharacterEncoding("UTF-8");

		// 2. 파라미터 수집
		String name = request.getParameter("name");
		String studentNum = request.getParameter("studentNum");
		String gender = request.getParameter("gender");
		String major = request.getParameter("major");
		String[] hobbies = request.getParameterValues("hobby");

		// 3. 비지니스 로직(성별 변환)
//		if(gender.equals("man")){
//			gender = "남자";
//		} else {
//			gender = "여자";
//		}
		gender = "man".equals(gender) ? "남자" : "여자";
		
		// 4.JSP에 전달할 데이터를 request 객체에 저장
		request.setAttribute("name", name);
		request.setAttribute("studentNum", studentNum);
		request.setAttribute("gender", gender);
		request.setAttribute("major", major);
		request.setAttribute("hobbies", hobbies);
		
		// 5. 결과 화면(JSP)으로 이동
		request.getRequestDispatcher("/jsp2/ch08_내장객체/ex02_request_pro(EL).jsp").forward(request, response);
	}

}
