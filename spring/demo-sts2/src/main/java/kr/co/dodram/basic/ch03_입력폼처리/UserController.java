package kr.co.dodram.basic.ch03_입력폼처리;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	@GetMapping("ch03/form/input")
	public String formInput(Model model) {
		
		model.addAttribute("userForm", new UserDTO());
		return "ch03_입력폼처리/input";
	}
	@PostMapping("ch03/form/process")
	public String formProcess(UserDTO userForm, Model model) {
		//model.addAttribute("userForm", userForm);
		
		 System.out.println("입력된 이름: " + userForm.getName());
	     System.out.println("입력된 나이: " + userForm.getAge());
	    
	     model.addAttribute("user", userForm);
	
		return "ch03_입력폼처리/process";
	}
}
