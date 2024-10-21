package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		page = page == null ? "1" : page;
		
		//검색조건
		SearchDTO search = new SearchDTO();
		search.setKeyword(kw);
		search.setSearchCondition(sc);
		search.setPage(Integer.parseInt(page));
		
		//글목록 보여주기, 조회 후 jsp 전달
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list =svc.boardList(search);
		int totalCnt = svc.getTotalCount(search);
		
		req.setAttribute("boardlist", list);
		req.setAttribute("page", new PageDTO(Integer.parseInt(page), totalCnt));
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		//jsp페이지
		req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);
		
		
	}

}
