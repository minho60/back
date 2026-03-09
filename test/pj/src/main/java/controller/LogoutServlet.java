package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * [LogoutServlet]
 * 사용자의 세션을 만료시키고, 원래 있던 페이지로 돌려보내는 역할을 합니다.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. 세션 무효화 (세션 바구니를 완전히 비우고 제거)
        HttpSession session = request.getSession(false); // 세션이 없으면 새로 만들지 않음
        if (session != null) {
            session.invalidate(); 
        }

        // 2. 이전 페이지 주소(Referer) 가져오기
        // 사용자가 로그아웃 버튼을 눌렀을 때 머물고 있던 주소입니다.
        String referer = request.getHeader("Referer");

        // 3. 페이지 유지 및 리다이렉트
        // 이전 주소가 존재한다면 그곳으로 다시 보내고, 없으면 메인 페이지로 보냅니다.
        if (referer != null) {
            response.sendRedirect(referer);
        } else {
            response.sendRedirect(request.getContextPath() + "/main");
        }
    }

    // 보안을 위해 POST 방식 요청도 동일하게 처리할 수 있도록 설정
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}