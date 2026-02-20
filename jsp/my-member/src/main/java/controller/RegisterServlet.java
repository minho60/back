package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBConnectionMgr;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 파라미터 한글처리
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		// 2. DB 저장
		String sql = "INSERT INTO user(userid, userpw) VALUES(?, ?)";
		
		//DBconnectionMgr.java 에서 getConnection()를 정의
		try (Connection conn = DBConnectionMgr.getConnection();
			PreparedStatement psmt = conn.prepareStatement(sql)){
			
			psmt.setString(1, userid);
			psmt.setString(2, userpw);
			
			int result = psmt.executeUpdate();
			
			if(result > 0) {
				// 저장 성공
				response.sendRedirect("view/success.jsp");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			response.getWriter().append("DB Error:"+e.getMessage());
			
		}
	}

}
