package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// title, content, writer 3개 파라미터 db등로 -> 목록보여주기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		
		BoardService svc = new BoardServiceImpl();
		try {
			//정상등록
		svc.registerBoard(bvo);	
		resp.sendRedirect("boardList.do");
		}catch(Exception e) {
		req.setAttribute("msg", "등록하는 중  오류가 발생");
		req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp").forward(req, resp);
		}
		
				}

}
