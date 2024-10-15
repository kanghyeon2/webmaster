package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;


@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberListServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
        MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
        List<Member> members = dao.members();
        out.print("<table>");
        for(Member member : members) {
        	out.print("<tr>");
        	out.print("<td>"+member.getMemberId()+"</td>");
        	out.print("<td>"+member.getMemberName()+"</td>");
        	out.print("<td>"+member.getPhone()+"</td>");
        	out.print("<td>"+member.getPassword()+"</td>");
        	out.print("<td>"+member.getResponsibility()+"</td>");
        	out.print("<td>"+member.getCreationDate()+"</td>");
        	out.print("</tr>");
        }
        out.print("</table>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
////		doGet(request, response);
//		//4개 파라미터
//		String id = request.getParameter("mem_id");
//		String name = request.getParameter("mem_name");
//		String password = request.getParameter("mem_pwd");
//		String phone = request.getParameter("mem_phone");
//		
//		Member member = new Member();
//		member.setMemberId(id);
//		member.setMemberName(name);
//		member.setPassword(password);
//		member.setPhone(phone);
//		
//		SqlSession sqlSession  = DataSource.getInstance().openSession(true)	; //true 자동커밋
//		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
//		try {
//		if(dao.members(member)==1) {
//			response.getWriter().print(member.getMemberId());
//		}
//	} catch(Exception e) {
//		response.getWriter().print("NG");
//	}
	}

}