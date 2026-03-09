package controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

/**
 * [LogoutServlet]
 * 일반 세션 로그아웃과 자동 로그인(쿠키/DB) 해제를 모두 처리하는 컨트롤러입니다.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * 로그아웃은 주로 하이퍼링크 클릭(GET 방식)으로 요청되므로 doGet에서 처리합니다.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. 세션 정보 확인 및 제거
        // getSession(false): 세션이 있으면 가져오고, 없으면 null을 반환 (새로 생성하지 않음)
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // 세션에 저장되어 있던 사용자의 ID를 꺼냅니다.
            String id = (String) session.getAttribute("idKey");
            
            /* * [자동 로그인 해제 로직 - DB 단계]
             * 사용자가 명시적으로 로그아웃을 눌렀으므로, DB에 저장된 토큰을 무효화합니다.
             * id가 존재할 때만 실행하여 NullPointerException을 방지합니다.
             */
            if (id != null) {
                MemberDAO mDAO = new MemberDAO();
                // session_key를 "none"으로 변경하고, 만료시간을 '현재 시간'으로 설정하여 토큰을 폐기합니다.
                mDAO.keepLogin(id, "none", new Timestamp(System.currentTimeMillis()));
            }
            
            // 서버 메모리에 저장된 해당 사용자의 세션 데이터를 완전히 삭제합니다.
            session.invalidate();
        }

        /* * 2. 자동 로그인 쿠키 삭제 - 브라우저 단계
         * 쿠키는 서버에서 직접 지울 수 없으므로, 같은 이름의 쿠키를 만들어 수명을 0으로 설정해 보냅니다.
         */
        Cookie loginCookie = new Cookie("loginCookie", null); // 값은 null 또는 빈 문자열
        
        loginCookie.setPath("/");    // 중요: 쿠키 생성 시 설정했던 경로와 반드시 일치해야 삭제됨
        loginCookie.setMaxAge(0);    // 브라우저가 이 쿠키를 즉시 삭제하도록 설정 (0초)
        response.addCookie(loginCookie); // 응답에 포함하여 브라우저로 전송
        
        // 3. 메인 페이지로 이동
        // 로그아웃 완료 후 메인 화면(/main)으로 리다이렉트합니다.
        response.sendRedirect(request.getContextPath() + "/main");
    }
}