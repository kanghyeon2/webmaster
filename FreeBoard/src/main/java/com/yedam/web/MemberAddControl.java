package com.yedam.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberAddControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("MemberAddControl");
		String id = req.getParameter("mem_id");
		String name = req.getParameter("mem_name");
		String pwd = req.getParameter("password");
		String phone = req.getParameter("phone");

		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id);
		mvo.setMemberName(name);
		mvo.setPassword(pwd);
		mvo.setPhone(phone);

		MemberService svc = new MemberServiceImpl();
		try {
			svc.addMember(mvo);
			// 목록페이지로 이동
			resp.sendRedirect("memberList.do");
		} catch (Exception e) {
			// 등록화면으로 이동 
			resp.sendRedirect("memberAddForm.do");

		}

	}

}
