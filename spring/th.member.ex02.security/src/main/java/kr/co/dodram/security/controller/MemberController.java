package kr.co.dodram.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.dodram.security.dto.MemberDTO;
import kr.co.dodram.security.service.MemberService;
import lombok.RequiredArgsConstructor;

/**
 * 회원 관련 웹 요청을 처리하는 컨트롤러
 */
@Controller
@RequestMapping("/member") // 클래스 수준 매핑: 이 컨트롤러의 모든 경로는 /member로 시작합니다.
@RequiredArgsConstructor // final 필드에 대한 생성자 주입을 자동으로 생성합니다.
public class MemberController {

    private final MemberService memberService;

    /**
     * 1. 로그인 폼 호출
     * GET 방식으로 /member/login 요청이 들어오면 로그인 페이지를 보여줍니다.
     */
    @GetMapping("/login")
    public String loginForm() {
        // ViewResolver에 의해 WEB-INF/views/member/login.jsp 파일로 포워딩됩니다.
        return "member/login"; 
    }

    /**
     * 2. 회원가입 폼 호출
     * GET 방식으로 /member/join 요청이 들어오면 가입 양식 페이지를 보여줍니다.
     */
    @GetMapping("/join")
    public String joinForm() {
        return "member/join";
    }

    /**
     * 3. 회원가입 처리 로직
     * 사용자가 입력한 데이터를 바탕으로 DB에 저장을 시도합니다.
     * @param dto @ModelAttribute를 통해 폼 파라미터가 DTO 객체에 자동으로 담깁니다.
     * @param session 가입 직후 사용자 이름을 저장하기 위해 세션 객체를 사용합니다.
     */
    @PostMapping("/join") 
    public String register(@ModelAttribute MemberDTO dto, HttpSession session) {
        try {
            // 유효성 검사: 아이디가 비어있으면 다시 가입 폼으로 돌려보냅니다.
            if (dto.getId() == null || dto.getId().trim().isEmpty()) {
                return "redirect:/member/join?error";
            }

            // 서비스 계층에 가입 로직 위임 (비밀번호 암호화 등 수행)
            boolean isSuccess = memberService.registerMember(dto);
            
            if (isSuccess) {
                // [성공 시 로직]
                // 1. 세션에 사용자 이름을 저장하여 메인 페이지에서 "OOO님" 출력이 가능하게 합니다.
                session.setAttribute("userName", dto.getName()); 
                
                // 2. 메인('/')으로 리다이렉트하면서 성공 파라미터(?regSuccess)를 전달합니다.
                // index.jsp의 자바스크립트가 이 파라미터를 보고 alert 팝업을 띄웁니다.
                return "redirect:/?regSuccess"; 
            } else {
                // 가입 실패 시 (DB 에러 등) 에러 파라미터를 들고 가입 폼으로 이동합니다.
                return "redirect:/member/join?error";
            }
        } catch (Exception e) {
            // [예외 발생 시]
            // 주로 DB의 PRIMARY KEY(ID) 중복 에러가 이 catch 블록에 걸립니다.
            System.out.println("가입 중 오류 발생: " + e.getMessage());
            
            // 중복 알림 전용 파라미터(?duplicate)를 붙여 리다이렉트합니다.
            return "redirect:/member/join?duplicate"; 
        }
    }

    /**
     * 4. 가입 완료 전용 페이지 (선택 사항)
     * 현재는 /process에서 메인으로 바로 보내고 있지만, 
     * 별도의 성공 결과 페이지가 필요할 때 사용합니다.
     */
    @GetMapping("/success")
    public String successPage() {
        return "member/success";
    }
}