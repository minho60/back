package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberBean;

/**
 * MemberServlet: 회원 관련 요청을 처리하는 컨트롤러입니다.
 * @WebServlet("/member") 어노테이션은 "/member" 경로로 들어오는 요청을 이 클래스가 처리하도록 매핑합니다.
 */
@WebServlet("/join")
public class MemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * GET 방식 요청 처리: 주로 회원가입 양식(JSP) 페이지를 보여줄 때 사용됩니다.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // 회원가입 입력 폼 페이지인 member.jsp로 내부 이동(Forward) 시킵니다.
        request.getRequestDispatcher("/WEB-INF/view/member/join.jsp").forward(request, response);
    }

    /**
     * POST 방식 요청 처리: 회원가입 폼에서 작성한 데이터를 전송(Submit)했을 때 호출됩니다.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. 인코딩 설정: 한글 데이터 깨짐 방지를 위해 요청(Request) 데이터의 인코딩을 UTF-8로 설정합니다.
        request.setCharacterEncoding("UTF-8");
        
        // 2. 데이터 수집: request.getParameter를 통해 클라이언트가 입력한 값을 가져와 MemberBean(DTO) 객체에 담습니다.
        MemberBean bean = new MemberBean();
        bean.setId(request.getParameter("id"));
        bean.setPwd(request.getParameter("pwd"));
        bean.setName(request.getParameter("name"));
        bean.setGender(request.getParameter("gender"));
        bean.setEmail(request.getParameter("email"));
        bean.setPhone(request.getParameter("phone"));
        bean.setZipcode(request.getParameter("zipcode"));
        bean.setAddress1(request.getParameter("address1"));
        bean.setAddress2(request.getParameter("address2"));
        bean.setJob(request.getParameter("job"));
        
        // [중요] 다중 선택 데이터 처리: 체크박스(hobby)처럼 값이 여러 개인 경우 getParameterValues를 사용하여 배열로 받습니다.
        String[] hobbies = request.getParameterValues("hobby");
        bean.setHobby(hobbies);

        // 3. 비즈니스 로직 수행: DAO(Data Access Object) 객체를 생성하고 DB에 회원 정보를 저장(Insert)합니다.
        MemberDAO mDAO = new MemberDAO();
        boolean result = mDAO.insertMember(bean);

        // 4. 결과에 따른 응답 처리
        if (result) {
            /* [가입 성공 시]
             * Session을 활용한 데이터 전달: URL 파라미터 노출 없이 가입자의 이름을 결과 페이지로 넘기기 위해 세션을 사용합니다.
             */
            // 현재 사용자의 세션 객체를 가져와 "userName"이라는 이름으로 회원의 이름을 저장합니다.
            request.getSession().setAttribute("userName", bean.getName());
            
            // Redirect 처리: 가입 성공 후 페이지를 새로고침했을 때 중복 가입을 방지하기 위해 주소를 강제로 변경합니다.
            // 클라이언트의 웹 브라우저에게 "이 경로로 다시 접속해!"라고 명령하는 것과 같습니다.
            response.sendRedirect(request.getContextPath() + "/WEB-INF/view/index.jsp");
        } else {
            /* [가입 실패 시]
             * 응답 타입을 HTML 및 UTF-8로 설정하여 자바스크립트가 제대로 실행되도록 합니다.
             */
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("  alert('회원 가입에 실패하였습니다.');"); // 경고창 띄우기
            out.println("  history.back();");               // 이전 페이지(입력 폼)로 돌아가기
            out.println("</script>");
            out.close();
        }
    }
}