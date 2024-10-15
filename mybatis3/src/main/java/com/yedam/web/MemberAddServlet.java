package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

// 서블리 실행하기 위한 url
// 응답정보를 전송
// http 프로토콜을 데이터 전송 수신
// HttpServlet 상속 받아 기능 구현

@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public MemberAddServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 자바=> 데이터의 입출력 : 스트림
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<h1>여기는 웹브라우저</h1>");
		out.print("<h3>응답정보를 처리하는 객체: response</h3>");
		out.print("<a href='index.html'> 첫페이지로 이동 </a>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		doGet(request, response);
		//4개 파라미터
		String id = request.getParameter("mem_id");
		String name = request.getParameter("mem_name");
		String password = request.getParameter("mem_pwd");
		String phone = request.getParameter("mem_phone");
		
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberName(name);
		member.setPassword(password);
		member.setPhone(phone);
		
		SqlSession sqlSession  = DataSource.getInstance().openSession(true)	; //true 자동커밋
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		try {
		if(dao.insertMember(member)==1) {
			response.getWriter().print("OK");
		}
	} catch(Exception e) {
		response.getWriter().print("NG");
	}
	}

}
