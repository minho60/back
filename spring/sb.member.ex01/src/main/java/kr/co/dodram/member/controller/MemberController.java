package kr.co.dodram.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.dodram.member.dto.MemberDTO;
import kr.co.dodram.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 1. 회원가입 페이지 이동
    @GetMapping("/join")
    public String joinForm() {
        return "member/join"; // WEB-INF/views/member/join.jsp
    }

    // 2. 회원가입 처리 (POST)
    @PostMapping("/join")
    public String register(@ModelAttribute MemberDTO dto, HttpSession session) {
        boolean isSuccess = memberService.registerMember(dto);
        
        if (isSuccess) {
            // 완료 페이지에서 이름을 보여주기 위해 세션에 저장
            session.setAttribute("userName", dto.getName());
            return "redirect:/member/success"; // PRG 패턴 적용
        } else {
            return "redirect:/member/join?error";
        }
    }

    // 3. 가입 완료 페이지 (기존 member_pro.jsp 대체)
    @GetMapping("/success")
    public String registerProcess() {
        return "member/joinsuccess"; // WEB-INF/views/member/process.jsp
    }
}