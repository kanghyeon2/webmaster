package com.yedam.contorl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.EventVO;

public class AddEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		
		EventVO event = new EventVO();
		event.setTitle(title);
		event.setStartDate(start);
		event.setEndDate(end);
		
		System.out.println(title);
		
		Map<String, String> result = new HashMap<>();
		try {
			BoardService svc =new BoardServiceImpl();
			svc.registerEvent(event);
			result.put("retCode", "OK");
		}catch (Exception e) {
			//{"retCode": "FAIL"}
			e.printStackTrace();
			result.put("retCode", "FAIL");
		}
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(result));
	}

	}


