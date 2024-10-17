package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		//글목록 보여주기, 조회 후 jsp 전달
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list =svc.boardList(Integer.parseInt(page));
		
		req.setAttribute("boardlist", list);
		req.setAttribute("page", new PageDTO(Integer.parseInt(page)));
		
		//jsp페이지
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
		
		
	}

}
