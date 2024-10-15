package practice태백;

public class Book {
	private String title;
	private String writer;
	private String bookNum;
	private int bookPrice;
	
	public Book() {};
	public Book(String title, String writer, String bookNum, int bookPrice) {
		this.title = title;
		this.writer = writer;
		this.bookNum = bookNum;
		this.bookPrice = bookPrice;
	}
	
	
	@Override
	public String toString() {
		return title + " | " + writer + " | " + bookPrice + " | " + bookNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	
	
}
