package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

@WebServlet("*.do")
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
		map.put("/delteBoard.do", new DeleteBoardControl());

		
		
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
