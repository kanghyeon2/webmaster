package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardMapper {
	//글목록
	List<BoardVO> boardlist();
	//페이징
	List<BoardVO> listWithPage(int page);
	//글동록
	int insertBoard(BoardVO board);
	//글수정
	int updateBoard(BoardVO board);
	//글삭제
	int deleteBoard(int boardNo);
	//상세보기
	BoardVO selectBoard(int boardNo); //한건 나오면
	//조회수증
	int updateCount(int boardNo);
}
