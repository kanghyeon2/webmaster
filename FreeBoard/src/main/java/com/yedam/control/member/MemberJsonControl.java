package com.yedam.control.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberJsonControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 회원목록을 JSON형태로 반환
		resp.setContentType("text/json;charset=utf-8");
		
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList();
		
		//[{"memberId": "user01"m "memberName": "사용자1", ...},
		//{......},
		//{......}]
		String json ="[";
		for(int i=0; i < list.size(); i++){
			json += "{\"memberId\":\"" +list.get(i).getMemberId()+"\",\"memberName\": \""+list.get(i).getMemberName()+"\",\"phone\": \""+list.get(i).getPhone()+"\"}";
			if(i != list.size()-1) {
				json += ","+"\n";
			}
		}
		json += "]";
		resp.getWriter().print(json);	
	}
}
