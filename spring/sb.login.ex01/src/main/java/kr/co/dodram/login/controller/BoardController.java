package kr.co.dodram.login.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.dodram.login.dto.BoardDTO;
import kr.co.dodram.login.repository.BoardDAO;

/**
 * [@Controller]
 * 1. 이 클래스가 사용자의 HTTP 요청을 처리하는 웹 컨트롤러임을 스프링에 알립니다.
 * 2. 스프링이 시작될 때 이 클래스를 찾아 자동으로 객체(Bean)로 만들어 관리합니다.
 */
@Controller
public class BoardController {

    /**
     * [의존성 주입 - DI(Dependency Injection)]
     * 기존처럼 'new BoardDAO()'를 하지 않습니다. 
     * 스프링 컨테이너가 미리 만들어둔 BoardDAO 객체를 가져와서 연결해줍니다.
     * final을 사용하면 객체 생성이 보장되고 불변성을 유지할 수 있어 안전합니다.
     */
    private final BoardDAO boardDAO;

    /**
     * [생성자 주입]
     * 스프링 4.3 (부트 1.4) 버전부터는 생성자가 하나만 있을 경우 
     * @Autowired 어노테이션을 생략해도 
     * 자동으로 의존성을 주입해줍니다. (권장되는 방식)
     */
    public BoardController(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    /**
     * [@GetMapping("/board/list")]
     * 사용자가 브라우저 주소창에 
     * 'http://localhost:8080/board/list'를 입력(GET 방식 요청)하면
     * 이 메서드가 호출되도록 매핑합니다.
     */
    @GetMapping("/board/list")
    public String getBoardList(Model model) {
        
        // 1. Repository(DAO)를 호출하여 데이터베이스의 게시글 목록을 가져옵니다.
        List<BoardDTO> list = boardDAO.getBoardList();
        
        /*
         * 2. [Model 객체]
         * - 컨트롤러에서 가공한 데이터를 View(JSP)로 전달하기 위한 상자라고 생각하면 됩니다.
         * - 기존 서블릿의 'request.setAttribute("list", list)'와 같은 역할을 합니다.
         */
        model.addAttribute("list", list);        // JSP에서 ${list}로 사용
        model.addAttribute("count", list.size()); // JSP에서 ${count}로 사용
        
        /*
         * 3. [View Resolver]
         * - 문자열 "board/list"를 리턴하면 application.properties에 설정된 
         * prefix(/WEB-INF/views/)와 suffix(.jsp)가 붙어서
         * 최종적으로 /WEB-INF/views/board/list.jsp 파일을 찾아가 화면을 그립니다.
         */
        return "board/list";
    }
}
