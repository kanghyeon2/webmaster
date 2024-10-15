package paactice;

import java.util.Scanner;

public class Book {
	Scanner scanner = new Scanner(System.in);
	
	private String[] book_name  = new String[20];
	private int[] book_num = new int[20];
	private int[] book_price = new int[20];
	private int input_books = 0;
	private int index = 0;
	
	public int get_index() {
		return index;
	}

	public void set_index(int index) {
		this.index = index;
	}
	
	public int get_input_books() {
		return input_books;
	}

	public void set_input_books(int input_books) {
		this.input_books = input_books;
	}

	public String[] get_book_name() {
		return book_name;
	}

	public void set_book_name(String book_name) {
		this.book_name[index] = book_name;
	}

	public int[] get_book_num() {
		return book_num;
	}

	public void set_book_num(int book_num) {
		this.book_num[index] = book_num;
	}

	public int[] get_book_price() {
		return book_price;
	}

	public void set_book_price(int book_price) {
		this.book_price[index] = book_price;
	}
	
	
	
	public void input() {
		for (int i = 0 ; i < input_books ; i++)
		{
			System.out.print((index + 1) + "번째 책 제목 : ");
			set_book_name(scanner.nextLine());
			System.out.print((index + 1) + "번째 책 번호 : ");
			set_book_num(Integer.parseInt(scanner.nextLine()));
			System.out.print((index + 1) + "번째 책 가격 : ");
			set_book_price(Integer.parseInt(scanner.nextLine()));
			index++;
		}
	}
	
	public void view() {
		for (int i = 0 ; i < index ; i++)
		{
			System.out.println((i + 1) + "번째 책 제목 : " + book_name[i]);
			System.out.println((i + 1) + "번째 책 번호 : " + book_num[i]);
			System.out.println((i + 1) + "번째 책 가격 : " + book_price[i]);
		}
	}
	
	public void analyze() {
		System.out.println("책 개수 : " + (index));
		System.out.println("책 가격 총합 : " + sum_price());
		System.out.println("책 가격 평균 : " + (double)sum_price() / (index));
		int max_price = 0;
		for (int i = 0 ; i < index ; i++) {
			if (book_price[i] > max_price) {
				max_price = book_price[i];
			}
		}
		System.out.println("최대 책 가격 : " + max_price);
	}

	public int sum_price() {
		int sum = 0;
		for (int i = 0 ; i < index ; i++) {
			sum = sum + book_price[i];
		}
		return sum;
	}
	
	public void delete(int num) {
		for (int i = num - 1 ; i < 20 ; i++) {
			book_name[num - 1] = book_name[num];
			book_num[num - 1] = book_num[num];
			book_price[num - 1] = book_price[num];
		}
		index--;
	}
}
