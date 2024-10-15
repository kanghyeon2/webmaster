package chap13;

import java.util.List;
import java.util.Vector;

public class BoardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Board> list = new Vector<Board>(); //멀티 스레드일 경우 vector
												//보통 arraylist
												//추가 삽입 많을 경우 linkedlist
		
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		list.remove(2);
		list.remove(3);
		
		for(Board ele : list) {
			System.out.printf("%s\t%s\t%s\t\n",  ele.subject, ele.content, ele.writer);
		}
		
		//해시코드
		Board bd = new Board("제목", "내용", "글쓴이");
		System.out.println(bd);
		System.out.println(bd.hashCode());
		System.out.println(bd.toString());
		//println 메소드 객체 참조함수가 들어오면 toString()실행 
		
	}

}
