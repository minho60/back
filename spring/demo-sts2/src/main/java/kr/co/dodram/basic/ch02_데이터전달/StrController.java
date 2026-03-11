package kr.co.dodram.basic.ch02_데이터전달;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StrController {
	@GetMapping("/ch02/str")
	public String home(Model model) {
		model.addAttribute("username","홍길동");
		model.addAttribute("greeting","환영합니다.");
		
		return "ch02_데이터전달/str";
	}

}
