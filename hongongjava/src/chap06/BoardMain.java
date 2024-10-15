package chap06;

public class BoardMain {

	public static void main(String[] args) {
		// 객체 생성
		Board board  = new Board();
		Board board1 = new Board("제목1", "내용1");
		Board board2 = new Board("제목2", "내용2","저자2");
		Board board3 = new Board("제목3", "내용3","저자3","2024-09-27");
		Board board4 = new Board("제목4", "내용4","저자4","2024-09-27", 123);
		board.title = "제목5";
		board.hitcount = 898;
		
		
		System.out.println(board.title +" "+ board.content +" "+ board.writer +" "+ board.date +" "+ board.hitcount);
		System.out.println(board1.title +" "+ board1.content +" "+ board1.writer +" "+ board1.date +" "+ board1.hitcount);
		System.out.println(board2.title +" "+ board2.content +" "+ board2.writer +" "+ board2.date +" "+ board2.hitcount);
		System.out.println(board3.title +" "+ board3.content +" "+ board3.writer +" "+ board3.date +" "+ board3.hitcount);
		System.out.println(board4.title +" "+ board4.content +" "+ board4.writer +" "+ board4.date +" "+ board4.hitcount);
	}

}
