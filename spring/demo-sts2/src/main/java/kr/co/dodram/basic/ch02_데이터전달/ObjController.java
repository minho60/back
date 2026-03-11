package kr.co.dodram.basic.ch02_데이터전달;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ObjController {
	@GetMapping("/ch02/obj")
	public String userInfo(Model model) {
		UserDTO user = new UserDTO("길동", "gemini@example.com", 15);
		model.addAttribute("user", user );
		return "ch02_데이터전달/obj"; 
	}
}
