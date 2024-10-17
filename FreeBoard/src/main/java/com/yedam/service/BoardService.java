package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardService {
	// 전체 목록 가져오기, 변경, 등록, 삭제, 단건조회
	List<BoardVO> boardList(int page);
	boolean registerBoard(BoardVO board);
	boolean removeBoard(int boardNo);
	boolean modifyBoard(BoardVO board);
	BoardVO searchBoard(int boardNo);
	
}
