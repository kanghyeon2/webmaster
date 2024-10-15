package chap13;


public class Board {
	//필드
	String subject;
	String content;
	String writer;
	//생성자
	public Board(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	//메소드
	@Override
	public String toString() {
		return subject + " : " + content + " : " + writer;
	}
	public String getTitle() {		
		return subject;
	}
	public String getContent() {		
		return content;
	}
	public String getWriter() {		
		return writer;
	}
	
}
