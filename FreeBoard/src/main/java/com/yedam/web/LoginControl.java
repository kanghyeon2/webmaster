package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// loginForm.jsp
		// id, pwsd를 파라미터
		String id = req.getParameter("logId");
		String pwd = req.getParameter("logPw");
		

		if (req.getMethod().equals("GET")) {
			req.getRequestDispatcher("WEB-INF/jsp/logForm.jsp").forward(req, resp);
		} else if(req.getMethod().equals("POST")) {
			
			MemberService svc = new MemberServiceImpl();
			MemberVO member = svc.loginCheck(id, pwd);
			//로그인 실패
			if(member == null) {
				req.setAttribute("msg", "아이디와비밀번호 확인");
				req.getRequestDispatcher("WEB-INF/jsp/logForm.jsp").forward(req, resp);
				return;
				
			}
			
			//정상로그인 session객체
			HttpSession session = req.getSession(); 
			session.setAttribute("logId", id); // 로그인 아이디를 세션에 저장해서 다른곳에서 request가 아닌 session으로 사용
			if(member.getResponsibility().equals("User"))
			resp.sendRedirect("boardList.do");
			else if(member.getResponsibility().equals("Admin"))
				resp.sendRedirect("memberList.do");
		}

	}

}
