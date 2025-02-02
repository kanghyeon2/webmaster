package com.yedam.control.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// GET: 수정화면
		// POST : 수정처리
		resp.setCharacterEncoding("utf-8");
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		String kw = req.getParameter("keyword");
		String sc = req.getParameter("searchCondition");
				
		
		
		BoardService svc = new BoardServiceImpl();
		if (req.getMethod().equals("GET")) {

			BoardVO board = svc.searchBoard(Integer.parseInt(bno));
			req.setAttribute("boardvo", board);
			req.setAttribute("page", page);
			req.setAttribute("keyword", kw);
			req.setAttribute("searchCondition", sc);
			
			req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);

		} else if (req.getMethod().equals("POST")) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);
			
			if(svc.modifyBoard(board)) {
				//정상이면 목록으로
				resp.sendRedirect("boardList.do?page=" + page + "&searchCondition=" + sc + "&keyword=" + kw);
			}else {
				board = svc.searchBoard(Integer.parseInt(bno));
				
				req.setAttribute("boardvo", board);
				req.setAttribute("msg", "수정할 게시글이 없다");
				req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);
			}
		}

	}

}
