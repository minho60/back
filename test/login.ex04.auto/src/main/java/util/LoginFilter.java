package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberBean;

/**
 * [LoginFilter]
 * 모든 요청(/*)을 가로채서 자동 로그인 쿠키가 있는지 검사하는 필터입니다.
 */
@WebFilter("/*") 
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
            throws IOException, ServletException {
        
        // Filter 인터페이스의 ServletRequest를 HttpServletRequest로 형변환하여 세션/쿠키 사용 준비
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        
        // 1. 현재 세션에 로그인 정보(userName)가 없는 경우에만 자동 로그인을 시도합니다.
        // 이미 로그인이 되어 있다면 이 과정을 건너뜁니다.
        if (session.getAttribute("userName") == null) {
            
            // 브라우저가 보낸 모든 쿠키를 가져옵니다.
            Cookie[] cookies = request.getCookies();
            
            if (cookies != null) {
                // 쿠키 배열을 순회하며 우리가 생성한 "loginCookie"를 찾습니다.
                for (Cookie c : cookies) {
                    if (c.getName().equals("loginCookie")) {
                        
                        // 쿠키에 담긴 고유 토큰값(sessionKey)을 꺼냅니다.
                        String sessionKey = c.getValue();
                        
                        // DB에서 해당 토큰이 유효한지(만료되지 않았는지) 확인합니다.
                        MemberDAO mDAO = new MemberDAO();
                        MemberBean bean = mDAO.checkUserWithSessionKey(sessionKey);
                        
                        if (bean != null) {
                            // 2. 유효한 토큰임이 확인되면 세션에 사용자 정보를 저장(자동 로그인 완료)
                            // 여기서 bean.getName()을 사용하므로 '홍길동님'으로 일관되게 출력됩니다.
                            session.setAttribute("idKey", bean.getId());
                            session.setAttribute("userName", bean.getName());
                        }
                        
                        // 원하는 쿠키를 찾았으므로 루프를 종료합니다.
                        break; 
                    }
                }
            }
        }
        
        // 3. 다음 필터로 요청을 넘기거나, 필터가 마지막이면 실제 서블릿/JSP를 실행합니다.
        chain.doFilter(req, res);
    }
}