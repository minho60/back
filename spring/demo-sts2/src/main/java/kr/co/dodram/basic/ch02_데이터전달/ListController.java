package kr.co.dodram.basic.ch02_데이터전달;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {
	@GetMapping("ch02/list")
	public String ch02List(Model model) {
		List<UserDTO> userList = new ArrayList<>();
		
		userList.add(new UserDTO("하나코", "nana@example.com", 23));
		userList.add(new UserDTO("시부키", "tenko@example.com", 22));
		userList.add(new UserDTO("쿠모린", "aoku@example.com", 24));
		
		model.addAttribute("users", userList);
		
		return "ch02_데이터전달/lst";
	}

}
