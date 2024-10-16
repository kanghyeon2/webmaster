package com.yedam.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class MemberAddControl implements Control{
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberAddControl");
		
		
	}

}
