package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class AddBoardFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// addBoardForm.do -> boardForm.jsp
		req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp").forward(req, resp);
		

	}

}
