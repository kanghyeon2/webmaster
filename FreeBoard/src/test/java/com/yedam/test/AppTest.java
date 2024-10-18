package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class AppTest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		SearchDTO search = new SearchDTO()	;
		search.setKeyword("user01");
		search.setSearchCondition("W");
		search.setPage(1);
		
		
		
		List<BoardVO> list1 = mapper.listWithPage(search);
		for(BoardVO bvo : list1) {
			System.out.println(bvo.toString());
		}

		// 삽입
//	BoardVO bvo= new BoardVO();
//	bvo.setTitle("mappler테스트");
//	bvo.setContent("정상 작동중");
//	bvo.setWriter("user01");
//	
//	if(mapper.insertBoard(bvo)==1) {
//		sqlSession.commit();
//	}

		// 업데이트
//		BoardVO bvo = new BoardVO();
//		bvo.setContent("정상 작동중 [수정]");
//		bvo.setWriter("user01");
//		bvo.setBoardNo(5);

//	if(mapper.updateBoard(bvo)==1) {
//		sqlSession.commit();
//	}

//	if(mapper.deleteBoard(bvo.getBoardNo())==1) {
//		sqlSession.commit();
//	}

//		if (mapper.selectBoard(1) == null) {
//			System.out.println("조회된 내용이 없습니다.");
//		}
//		System.out.println(mapper.selectBoard(1));

		// 목록 조회
//		List<BoardVO> list = mapper.boardlist();
//		for (BoardVO bvo2 : list) {
//			System.out.println(bvo2.toString());
//		}
	}
}
