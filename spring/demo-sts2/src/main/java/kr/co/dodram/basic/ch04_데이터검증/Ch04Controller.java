package kr.co.dodram.basic.ch04_데이터검증;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
/**
 * [Controller 계층]
 * @Controller: 이 클래스가 사용자의 요청(URL)을 받아 처리하고 
 * 적절한 뷰(HTML)를 반환하는 컨트롤러임을 스프링 빈으로 등록합니다.
 * 클래스 이름은 그대로 두고 싶다면, @Controller 어노테이션에 고유한 이름을 부여합니다.
 */
@Controller
@RequestMapping("/ch04")
public class Ch04Controller {

    /**
     * [1. 입력 폼을 보여주는 단계]
     * @GetMapping("/user/new"): 브라우저 주소창에 직접 입력하거나 
     * 링크를 클릭했을 때 발생하는 'GET' 방식의 요청을 처리합니다.
     */
    @GetMapping("/form/input")
    public String showForm(Model model) {
        /*
         * - 타임리프(Thymeleaf) 뷰 템플릿의 th:object="${userForm}"과 연결하기 위해 
         * 비어있는 Ex01_UserForm 객체를 모델에 담습니다.
         * - 이렇게 미리 객체를 넘겨주면 폼 태그 내부에서 필드 에러 처리나 
         * 데이터 바인딩이 훨씬 매끄러워집니다.
         */
        model.addAttribute("userForm", new UserDTO());
        
        // return: templates/ch02_입력폼처리/ex01_userForm.html 파일을 찾아 렌더링합니다.
        return "ch04_데이터검증/input";
    }

    /**
     * [2. 입력된 데이터를 제출받는 단계]
     * @PostMapping("/user/new"): <form method="post">로 전송된 
     * 'POST' 방식의 요청을 처리합니다. URL은 같아도 전송 방식이 다르면 다르게 동작합니다.
     */
    @PostMapping("/form/input")
    public String processForm(@Valid @ModelAttribute("userForm") UserDTO userForm, 
                                BindingResult bindingResult, 
                                Model model) {
        // 만약 검증 결과 에러가 있다면?
        if (bindingResult.hasErrors()) {
            // 다시 입력 폼 페이지로 보냅니다. (이때 에러 정보도 함께 전달됨)
            return "ch04_데이터검증/input";
        }

        /**
         * @ModelAttribute:
         * 1. 클라이언트가 보낸 데이터(name, age 등)를 객체(Ex01_UserForm)의 
         * Setter 메서드를 통해 자동으로 주입(Binding)해줍니다.
         * 2. 자동으로 model.addAttribute("userForm", userForm)을 수행하여 
         * 결과 뷰에서도 이 객체를 바로 쓸 수 있게 해줍니다.
         */
        
        // 콘솔에 출력하여 데이터가 잘 들어왔는지 디버깅 용도로 확인합니다.
        System.out.println("입력된 이름: " + userForm.getName());
        System.out.println("입력된 나이: " + userForm.getAge());

        // 에러가 없을 때만 결과 페이지로 이동
        // 결과 화면(ex01_userResult.html)에 'user'라는 이름으로 객체를 다시 전달합니다.
        model.addAttribute("user", userForm);
        
        // 처리 완료 후 결과 페이지로 이동합니다.
        return "ch04_데이터검증/process"; 
    }
}
