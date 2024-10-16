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

// IOC (제어의 역전)
// 객체생성 -> init()	-> service() -> destroy() : 서블릿의 생명주기
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
        out.print("<table border='1'>");
        for(Member member : members) {
        	out.print("<tr>");
        	out.print("<td><a href='member.action?member_id="+member.getMemberId()+"'>"+ member.getMemberId() +"</a></td>"); //링크 연결 <a href='member.action?member_id="+member.getMemberId()+"'>
        	out.print("<td>"+member.getMemberName()+"</td>");
        	out.print("<td>"+member.getPhone()+"</td>");
        	out.print("</tr>");
        }
        out.print("</table>");
        
        out.print("<a href='index.html'> 첫페이지로 이동 </a><br>");
        out.print("<a href='MemberAddServlet'> 멤버에드 </a><br>");
        out.print("<a href='/mybatis3/html/memberAdd.html'> 입력창 </a><br>");
//        out.print("<a href='member.action'> 회원정보 </a><br>");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
