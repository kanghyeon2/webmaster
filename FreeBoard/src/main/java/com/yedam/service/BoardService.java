package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardService {
	// 전체 목록 가져오기, 변경, 등록, 삭제, 단건조회
	
	List<BoardVO> board();
	List<BoardVO> boardList(SearchDTO search);
	boolean registerBoard(BoardVO board);
	boolean deleteBoard(int boardNo);
	boolean modifyBoard(BoardVO board);
	BoardVO searchBoard(int boardNo);
	//페이징 카운트
	int getTotalCount(SearchDTO search);
}
