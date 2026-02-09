package servlet.ch01_서블릿설정및응답기초;

//jakarta 톰캣 10.0+
//javax 톰캣 9.0이하
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
/**
 * web.xml 또는 @WebServlet("URL 맵핑") 애노테이션
 * http://localhost:8080/프로젝트명/URL맵핑
 * http://localhost:8080/my-jsp/hello
 * 실행(run): ctrl+F11
 */
/* 
	1. @WebServlet("url")
	   @WebServlet(name="서블릿명", urlPatterns={"url1", "url2", ...})
	   @WebServlet(name="서블릿명", value={"url1", "url2", ...})
		- 서블릿 컨테이너(톰켓, WAS)에 클래스가 서블릿임을 알리고, url 경로를 맵핑
		-> 클라이언트(브라우저)가 'http://localhost:8080/컨텍스트루트/hello'로 접속하면 클래스가 실행
		- 컨텍스트루트(Context Root)? 프로젝트명(예, my-jsp)
*/
// @WebServlet("/hello")
@WebServlet(
    name = "Ex01_HelloServlet",
    urlPatterns = {"/hello"}
)
public class Ex01_HelloServlet extends HttpServlet {
	// 객체 직렬화(역직렬화) 시 클래스 버전 식별을 위한 고유 ID
	// 직렬화? 객체를 바이트 스트림으로
	// 역직렬화? 바이트 스트림을 객체로
	private static final long serialVersionUID = 1L;

	/**
	 * 2. doGet()
	 * 	- 클라이언트가 GET 방식(<form method="get">, 브라우저 주소창 입력(쿼리스크링), 링크(<a>) 클릭 등)으로 
	 * 	  요청(request)를 보낼 때 doGet() 메서드가 호출된다.
	 * @param requset: 클라이언트의 요청 정보(파라미터, 쿠키, 세션 등)를 담고 있는 객체
	 * 		- http://localhost:8080/컨텍스트루트/hello?name=홍길동&age=10 여기에서
	 * 		- URL?파라미터
	 * @param response: 서버가 클라이언트에게 보낼 응답 정보(데이터, 상태 코드 등)을 담는 객체
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		// 콘솔 표시
		PrintStream console = System.out;
		console.println("Hello World!");
		System.out.println("Hello World!");

		// 4. 브라우저에 문자열로 표시
		PrintWriter out = response.getWriter();
		out.println("Hello Servlet!");
		out = response.getWriter();
		out.println("Hello Servlet!");
		out = response.getWriter();
		out.println("Hello Servlet!");

		out.print("Hello Servlet!");
		out = response.getWriter();
		out.print("Hello Servlet!");
		out = response.getWriter();
		out.print("Hello Servlet!");

		response.getWriter().println("<h1 style='color:red;'>Hello Servlet!</h1>");
		// 이스케이프 문자: \', \", \n, \t, ...
		// 웹 표준 기준에 맞으나, 코드가 길어지면 가독성이 떨어짐!
		response.getWriter().println("<h1 style=\"color:red;\">Hello Servlet!</h1>");
		// JDK15+: Text Blocks(""")
		 response.getWriter().println("""
		 	<h1 style=\"color:red;\">Hello Servlet!</h1> """);
		// response.getWriter().println('<h1 style="color:red;">Hello Servlet!</h1>');
		// -> 자바에서 문자열은 ""로 묶는다.
	}

	/**
	 * 3. doPost()
	 * 	- 클라이언트가 POST 방식(<form method="post">)으로 요청을 보낼 때 호출된다.
	 *  - 보안이 필요하거나 데이터 양이 많을 때 사용!
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
