package chap13;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	List<Board> list = new ArrayList<Board>();

	public List<Board> getBoardList() {	
	list.add(new Board("제목1", "내용1", "글쓴이1"));
	list.add(new Board("제목2", "내용2", "글쓴이2"));
	list.add(new Board("제목3", "내용3", "글쓴이3"));
	return list;
	}
}


