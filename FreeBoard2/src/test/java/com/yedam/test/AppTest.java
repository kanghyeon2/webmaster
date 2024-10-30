package com.yedam.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class AppTest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		/*BoardService svc =new BoardServiceImpl();
		List<Map<String, Object>> result = svc.countByWriter();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json =  gson.toJson(result);*/
		
		
		BoardService svc =new BoardServiceImpl();
		List<Map<String, Object>> list = svc.eventList();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json =  gson.toJson(list);
		System.out.println(json);
//		SearchDTO search = new SearchDTO()	;
//		search.setKeyword("user01");
//		search.setSearchCondition("W");
//		search.setPage(1);
//		
//		
//		
//		List<BoardVO> list1 = mapper.listWithPage(search);
//		for(BoardVO bvo : list1) {
//			System.out.println(bvo.toString());
//		}
//		svc.replyList(210).forEach(reply -> System.out.println(reply));
	
//		ReplyVO rvo = mapper.selectReply(4);
//		System.out.println(rvo.getBoardNo() + rvo.getReply());
//		
//		svc.removeReply(4);
//		if (mapper.selectReply(4) == null) {
//			System.out.println("조회된 내용이 없습니다.");
//		} else
//			System.out.println(mapper.selectReply(4));

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
