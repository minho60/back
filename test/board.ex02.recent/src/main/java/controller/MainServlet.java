package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardBean;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. DAO 객체 생성 (한 번만 생성해서 재사용)
        BoardDAO dao = new BoardDAO();

        // 2. 최근글 5개 가져오기
        List<BoardBean> list = dao.getBoardList(5);
        request.setAttribute("list", list);
        
        // 3. 전체 게시물 수 조회 (기존 생성한 dao 객체 사용)
        int totalRecord = dao.getTotalCount();
        request.setAttribute("totalRecord", totalRecord);

        // 4. View(JSP)로 포워딩
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }
}