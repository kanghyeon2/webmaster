package chap06;

public class Book {
	//필드
	private String bookName;
	private int bookNumber;
	private int bookPrice;
	
	
	
	//생성자
	Book(String bookName, int bookNumber, int bookPrice){
		this.bookName = bookName;
		this.bookNumber = bookNumber;
		this.bookPrice = bookPrice;
	}
	//메소드
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
}
