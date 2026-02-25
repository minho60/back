package jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ch08/session/result")
public class Ch08SessionResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String season = request.getParameter("season");
		String [] fruits = request.getParameterValues("fruit");
		
		request.setAttribute("season",season );
		request.setAttribute("fruits",fruits );
		

		
		request.getRequestDispatcher("/jsp2/ch08_내장객체/ex05_session_result.jsp").forward(request, response);
	}

}
