package com.yedam.common;

import java.util.List;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

import lombok.Data;

@Data
public class PageDTO {
	private int startPage, endPage;
	private boolean prev, next;
	private int page; //현재페이지
	
	public PageDTO(int page)	{
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.board();
		int totalCnt = list.size();
		
//		int totalCnt = 3300;
		this.endPage = (int)Math.ceil(page / 10.0) * 10;
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)Math.ceil(totalCnt / 5.0);
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
		this.page = page;
	}
}
