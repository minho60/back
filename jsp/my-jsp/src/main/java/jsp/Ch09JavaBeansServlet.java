package jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ch09/javabeans")
public class Ch09JavaBeansServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1) JavaBean 생성
		Ch09JavaBeans test = new Ch09JavaBeans();

		// 2) 속성 설정
		test.setMessage("빈을 쉽게 정복하자");

		// 3) request 객체에 저장
		request.setAttribute("test", test);

		// 4) JSP로 포워딩
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/basic/ch09_자바빈즈/Ex01_Beans2.jsp");
//		dispatcher.forward(request, response);
		request.getRequestDispatcher("/jsp2/ch09_자바빈즈(EL)/ex01_useBeans_pro.jsp").forward(request, response);
		
	}

}
