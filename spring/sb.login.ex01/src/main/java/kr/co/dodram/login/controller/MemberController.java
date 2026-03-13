package kr.co.dodram.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import kr.co.dodram.login.dto.MemberDTO;
import kr.co.dodram.login.service.MemberService;
import lombok.RequiredArgsConstructor;

/**
 * [Controller 레이어]
 * 사용자의 브라우저 요청을 받는 입구입니다.
 * @Controller: 이 클래스가 웹 요청을 처리하는 컨트롤러임을 스프링 빈으로 등록합니다.
 */
@Controller
@RequiredArgsConstructor // MemberService를 주입받기 위한 생성자를 롬복이 자동으로 생성합니다.
public class MemberController {

    private final MemberService memberService;

    /**
     * [1] 메인 페이지 이동
     * @GetMapping: 브라우저 주소창에 직접 입력하거나 링크를 클릭하는 GET 요청을 처리합니다.
     * 경로를 배열{ }로 지정하여 여러 경로를 한 번에 매핑할 수 있습니다.
     */
    @GetMapping("/")
    public String mainPage() {
        // prefix(/WEB-INF/views/)와 suffix(.jsp)가 결합되어 index.jsp를 호출합니다.
        return "index"; 
    }

    /**
     * [2-1] 로그인 페이지 이동
     */
    @GetMapping("/login")
    public String loginForm() {
        // member 폴더 안의 login.jsp를 보여줍니다.
        return "member/login"; 
    }

    /**
     * [2-2] 로그인 처리 로직
     * @RequestParam("name"): HTML form의 <input name="id"> 값을 변수에 매핑합니다.
     * @param rttr: RedirectAttributes는 리다이렉트 시 데이터를 일회성으로 전달할 때 사용합니다. (FlashAttribute)
     */
    @PostMapping("/login")
    public String login(@RequestParam("id") String id, 
                        @RequestParam("pwd") String pwd, 
                        HttpSession session,
                        RedirectAttributes rttr) {
        
        // 서비스 레이어에 아이디/비번 검증 명령 (결과로 이름을 받아옴)
        String userName = memberService.login(id, pwd);

        if (userName != null) {
            // [성공] 세션에 회원 ID와 이름을 저장하여 브라우저가 닫힐 때까지 상태 유지
            session.setAttribute("idKey", id);
            session.setAttribute("userName", userName);
            // 로그인 성공 후 메인으로 리다이렉트 (주소창이 /main으로 바뀜)
            return "redirect:/main";
        } else {
            // [실패] 일회성 메시지를 담아 다시 로그인 폼으로 보냄
            // addFlashAttribute는 세션을 통해 딱 한 번만 전달되고 자동으로 소멸됩니다.
            rttr.addFlashAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "redirect:/login";
        }
    }

    /**
     * [2-3] 로그아웃 처리
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 현재 생성된 모든 세션 정보를 무효화(삭제)합니다.
        session.invalidate(); 
        return "redirect:/main";
    }

    /**
     * [3-1] 회원가입 페이지 이동
     */
    @GetMapping("/member/join")
    public String joinForm() {
        return "member/join"; 
    }

    /**
     * [3-2] 회원가입 처리 로직
     * @ModelAttribute: form의 수많은 input 값들을 MemberDTO 객체에 자동으로 담아줍니다. (커맨드 객체)
     */
    @PostMapping("/member/join")
    public String register(@ModelAttribute MemberDTO dto, HttpSession session) {
        // 서비스에 회원 정보 저장 요청
        boolean isSuccess = memberService.registerMember(dto);
        
        if (isSuccess) {
            // 가입 성공 시 가입 완료 페이지에서 이름을 보여주기 위해 세션에 저장
            session.setAttribute("userName", dto.getName());
            // PRG(Post-Redirect-Get) 패턴을 적용하여 새로고침 시 중복 가입을 방지합니다.
            return "redirect:/member/success";
        } else {
            // 실패 시 에러 파라미터를 들고 가입 폼으로 복귀
            return "redirect:/member/join?error";
        }
    }

    /**
     * [3-3] 회원가입 완료 페이지 이동
     */
    @GetMapping("/member/success")
    public String registerProcess() {
        return "member/joinsuccess"; 
    }
}