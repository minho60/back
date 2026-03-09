package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * [LoginCheckFilter]
 * 서비스의 특정 기능을 수행하기 전, 사용자가 로그인 상태인지 미리 검사하는 '문지기' 역할을 합니다.
 * @WebFilter: 이 필터가 적용될 요청 주소들을 지정합니다.
 * 게시글 작성(/post), 상세 보기(/read), 수정(/update), 삭제(/delete) 시에만 동작합니다.
 */
@WebFilter(urlPatterns = {"/board/post", "/board/read", "/board/update", "/board/delete"})
public class LoginCheckFilter implements Filter {

    /**
     * 필터의 핵심 로직이 실행되는 메서드입니다.
     * 클라이언트의 요청이 서블릿에 도달하기 전에 이 메서드가 먼저 호출됩니다.
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        // 1. 부모 인터페이스인 ServletRequest를 자식인 HttpServletRequest로 형변환합니다.
        // 세션(Session)이나 컨텍스트 경로(ContextPath) 같은 HTTP 관련 기능을 사용하기 위함입니다.
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        // 2. 현재 요청을 보낸 사용자의 세션 객체를 가져옵니다.
        HttpSession session = req.getSession();

        // 3. 세션 바구니에 "userName"이라는 값이 담겨 있는지 확인합니다. (로그인 여부 판단)
        if (session.getAttribute("userName") == null) {
            /* [비로그인 상태일 때 실행되는 구간] */

        	// 사용자가 원래 요청했던 전체 주소(URI)를 가져옵니다. (예: /board/read?num=10)
        	String uri = req.getRequestURI();
        	String query = req.getQueryString(); // ? 뒤의 파라미터들
        	String target = (query == null) ? uri : uri + "?" + query;

        	// 세션에 "원래 가려던 목적지"를 임시로 저장합니다.
        	session.setAttribute("prevPage", target);

        	res.setContentType("text/html; charset=UTF-8");
        	PrintWriter out = res.getWriter();
        	out.println("<script>");
        	out.println("  alert('로그인이 필요한 기능입니다.');");
        	//out.println("  location.href='" + req.getContextPath() + "/login';"); 
        	// 1. 로그인 페이지로 보내지 않고, 이전 페이지(게시판 목록)로 즉시 돌려보냅니다.
            // 2. 이렇게 하면 보던 페이지 번호, 검색어 등이 그대로 유지된 상태로 돌아갑니다.
            out.println("  history.back();");
        	out.println("</script>");
        	out.close();
            
        } else {
            /* [로그인 완료 상태일 때 실행되는 구간] */

            // 4. "가던 길 가세요"라고 허가해주는 명령어입니다.
            // 이 메서드가 호출되어야 비로소 실제 게시판 기능을 처리하는 서블릿으로 요청이 전달됩니다.
            chain.doFilter(request, response); 
        }
    }
}