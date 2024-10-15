package practice;

import java.util.Scanner;

public class Book_main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Book book = new Book();
		int input = 0;
		while (true) {
			System.out.println("---------------------------------------------");
			System.out.println("1. 입력 할 도서 수, 2. 도서 입력, 3. 도서 목록 조회");
			System.out.println("4. 도서 분석, 5. 도서 삭제, 6. 종료 | 현재 " + book.get_index() + "권 입력");
			System.out.println("---------------------------------------------");
			System.out.print("입력 : ");
			int select = Integer.parseInt(scanner.nextLine());

			if (select == 1) {
				System.out.print("입력할 도서 수 : ");
				input = Integer.parseInt(scanner.nextLine());
				book.set_input_books(input);
			} else if (select == 2) {
				book.input();
			} else if (select == 3) {
				book.view();
			} else if (select == 4) {
				book.analyze();
			} else if (select == 5) {
				System.out.print("삭제할 N번째 책 입력 : ");
				input = Integer.parseInt(scanner.nextLine());
				book.delete(input);
				System.out.println(input + "번째 책 삭제 완료");
			} else if (select == 6) {
				break;
			}
		}
		scanner.close();
	}

}
