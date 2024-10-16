package com.yedam.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberListControl");
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList();
		
		req.setAttribute("memberList", list);
		
		try {
			//memberList.do 요청 페이지에서 memberList.jsp 요청재지정 보여지는것은 memberlist.do 이지만 요청하는거승 memberlist.jsp
			req.getRequestDispatcher("WEB-INF/jsp/memberList.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
