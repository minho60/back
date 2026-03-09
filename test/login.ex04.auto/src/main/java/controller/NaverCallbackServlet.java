package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

/**
 * [NaverCallbackServlet]
 * 네이버 로그인 인증 성공 후 사용자가 돌아오게 되는 콜백 경로를 처리합니다.
 * @WebServlet("/sns/naver-callback") : 네이버 개발자 센터에 등록한 Callback URL과 일치해야 합니다.
 */
@WebServlet("/sns/naver-callback")
public class NaverCallbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * [GET 방식 처리]
     * 네이버 서버가 사용자의 브라우저를 통해 '인가 코드(code)'와 '상태값(state)'을 파라미터로 보냅니다.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 1. 네이버로부터 전달받은 파라미터 추출
        // - code: 접근 토큰(Access Token)을 발급받기 위해 필요한 임시 인증 코드
        // - state: 로그인 요청 시 보냈던 랜덤 문자열 (보안 검증용)
        String code = request.getParameter("code");
        String state = request.getParameter("state");

        // 2. 인가 코드가 정상적으로 수신되었는지 확인
        if (code != null) {
            
            // [비즈니스 로직: DB 저장 및 로그인 처리]
            MemberDAO md = new MemberDAO();
            
            /* * [테스트 로직 설명]
             * 실제 구현 시에는 이 code를 사용하여 네이버 API에 '접근 토큰'을 요청하고,
             * 발급받은 토큰으로 네이버 사용자 프로필(이름, 이메일 등)을 가져와야 합니다.
             * 현재는 테스트를 위해 'naver_시간' 형태의 임시 ID를 생성하고 있습니다.
             */
            String testId = "naver_" + System.currentTimeMillis();
            
            // 3. SNS 회원 정보 저장 시도
            // - 파라미터: 아이디, 닉네임, SNS 고유 식별자, 서비스 타입('naver')
            boolean result = md.saveSnsMember(testId, "네이버유저", "SNS_" + testId, "naver");

            if (result) {
                // 4. 세션 생성: DB 저장 또는 중복 확인이 성공하면 로그인 상태를 만듭니다.
                HttpSession session = request.getSession();
                
                // JSP(${userName})에서 사용할 사용자 정보를 세션에 바인딩
                session.setAttribute("idKey", testId);
                session.setAttribute("userName", "네이버회원");
                
                // 5. 로그인 완료 후 메인 페이지로 이동
                // - sendRedirect: 브라우저 주소를 메인으로 바꾸어 로그인 처리를 마칩니다.
                response.sendRedirect(request.getContextPath() + "/main");
            }
        }
    }
}