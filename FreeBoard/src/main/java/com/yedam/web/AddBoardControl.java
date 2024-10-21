package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1025 * 5;

		// Multipart(파일처리)요청에 대한 처리로 번경
		MultipartRequest mr = new MultipartRequest(req // 1.요청정보
				, savePath // 2.저장경로
				, maxSize // 3.최대크기 지정
				, "utf-8" // 4.encoding 방식
				, new DefaultFileRenamePolicy()// 5.리네임정책
		);

		// title, content, writer 3개 파라미터 db등로 -> 목록보여주기
		// key=value&key=value text처리
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String img = mr.getFilesystemName("img");
		

		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		bvo.setImg(img);

		BoardService svc = new BoardServiceImpl();
		try {
			// 정상등록
			svc.registerBoard(bvo);
			resp.sendRedirect("boardList.do");
		} catch (Exception e) {
			req.setAttribute("msg", "등록하는 중  오류가 발생");
			req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp").forward(req, resp);
		}

	}

}
