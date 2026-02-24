package jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ch08request")
public class Ch08RequestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String protocol = request.getProtocol();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String remoteAddr = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        String method = request.getMethod();
        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();
        String useBrowser = request.getHeader("User-Agent");
        String fileType = request.getHeader("Accept");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Request Example2</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Request Example2</h1>");
        out.println("프로토콜 : " + protocol + "<p/>");
        out.println("서버의 이름 : " + serverName + "<p/>");
        out.println("서버의 포트 번호 : " + serverPort + "<p/>");
        out.println("사용자 컴퓨터의 주소 : " + remoteAddr + "<p/>");
        out.println("사용자 컴퓨터의 이름 : " + remoteHost + "<p/>");
        out.println("사용 method : " + method + "<p/>");
        out.println("요청 경로(URL) : " + requestURL + "<p/>");
        out.println("요청 경로(URI) : " + requestURI + "<p/>");
        out.println("현재 사용하는 브라우저 : " + useBrowser + "<p/>");
        out.println("브라우저가 지원하는 file의 type : " + fileType + "<p/>");

        out.println("</body>");
        out.println("</html>");
    }
}