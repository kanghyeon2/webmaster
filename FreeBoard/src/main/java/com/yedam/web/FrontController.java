package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.contorl.EventListControl;
import com.yedam.contorl.ChartControl;
import com.yedam.contorl.CountByWriterControl;
import com.yedam.contorl.DeleteExeControl;
import com.yedam.contorl.ExeControl;
import com.yedam.contorl.AddEventControl;
import com.yedam.contorl.CalendarControl;
import com.yedam.contorl.JavaScriptControl;
import com.yedam.contorl.RemoveEventControl;
import com.yedam.contorl.reply.ReplyCountControl;
import com.yedam.control.board.AddBoardControl;
import com.yedam.control.board.BoardControl;
import com.yedam.control.board.BoardListControl;
import com.yedam.control.board.DeleteBoardControl;
import com.yedam.control.board.ModifyBoardControl;
import com.yedam.control.member.AddBoardFormControl;
import com.yedam.control.member.AddMemberJsonControl;
import com.yedam.control.member.RemoveMemberControl;
import com.yedam.control.member.LogOutControl;
import com.yedam.control.member.LoginControl;
import com.yedam.control.member.MemberAddControl;
import com.yedam.control.member.MemberAddFormControl;
import com.yedam.control.member.MemberJsonControl;
import com.yedam.control.member.MemberListControl;
import com.yedam.control.reply.AddReplyControl;
import com.yedam.control.reply.RemoveReplyControl;
import com.yedam.control.reply.ReplyListControl;

//@WebServlet("*.do")
public class FrontController extends HttpServlet { // servlet

	Map<String, Control> map;

	public FrontController() {
		System.out.println("객체 생성");
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출");
		map.put("/memberList.do", new MemberListControl());
		// 회원등록 
		// 1.등록화면 2.등록처리	
		map.put("/memberAddForm.do", new MemberAddFormControl());
		map.put("/memberAdd.do", new MemberAddControl());
		
		//게시판관련
		map.put("/boardList.do", new BoardListControl());//목록보기
		map.put("/board.do", new BoardControl());//상세
		map.put("/addBoardForm.do", new AddBoardFormControl()); //넘어가는화면
		map.put("/addBoard.do", new AddBoardControl());//등록화면
		
		//글수정 (수저오하면 -> 변경처리)
		map.put("/modifyBoard.do", new ModifyBoardControl());
		
		//글삭제
		map.put("/deleteBoard.do", new DeleteBoardControl());
		
		//로그인
		map.put("/loginForm.do", new LoginControl());
		//로그아웃
		map.put("/logOut.do", new LogOutControl());
		
		//자바스크립트 연습
		map.put("/javascript.do", new JavaScriptControl());

		//json 관련
		map.put("/memberJson.do", new MemberJsonControl());		
		map.put("/addMemberJson.do", new AddMemberJsonControl());		
		map.put("/removeMemberJson.do", new RemoveMemberControl());
		
		//댓글관련
		map.put("/replyList.do", new ReplyListControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/replyCount.do", new ReplyCountControl());
		
		//차트
		map.put("/chart.do", new ChartControl());
		map.put("/countByWriter.do", new CountByWriterControl());
		
		map.put("/calendar.do", new CalendarControl());
		map.put("/eventList.do", new EventListControl());
		map.put("/addEvent.do", new AddEventControl());
		map.put("/removeEvent.do", new RemoveEventControl());
		map.put("/exe.do", new ExeControl());

		
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 호출");
		//요청페이지?
		String uri = req.getRequestURI(); // /FreeBoard/add.do
		String context = req.getContextPath(); // /FreeBoard
		String page = uri.substring(context.length()); // /add.do
		
		Control control = map.get(page);
		control.exec(req,resp);
	}
	

}
