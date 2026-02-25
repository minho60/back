package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnectionMgr;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.getRequestDispatcher("/view/member/member.jsp").forward(request, response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        // 1. 모든 파라미터 받아오기
        String phone    = request.getParameter("phone");
        String name     = request.getParameter("name");
        String gender   = request.getParameter("gender");
        String id       = request.getParameter("id");
        String pwd      = request.getParameter("pwd");
        String email    = request.getParameter("email");
        String zipcode  = request.getParameter("zipcode");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String job      = request.getParameter("job");

        // 체크박스(hobby)는 여러 값이 올 수 있으므로 배열 처리
        String[] hobbies = request.getParameterValues("hobby");
        String hobby = "";
        if (hobbies != null) {
            hobby = String.join(",", hobbies);  // ex: 인터넷,게임
        }

        String sql = "INSERT INTO member "
                   + "(phone, name, gender, id, pwd, email, zipcode, address1, address2, hobby, job) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnectionMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, phone);
            pstmt.setString(2, name);
            pstmt.setString(3, gender);
            pstmt.setString(4, id);
            pstmt.setString(5, pwd);
            pstmt.setString(6, email);
            pstmt.setString(7, zipcode);
            pstmt.setString(8, address1);
            pstmt.setString(9, address2);
            pstmt.setString(10, hobby);
            pstmt.setString(11, job);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                response.sendRedirect(request.getContextPath() + "/view/member/success.jsp");
            } else {
                response.getWriter().append("회원가입 실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().append("DB Error: " + e.getMessage());
        }
    }
}
