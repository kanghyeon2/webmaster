package chap06;

import java.util.Scanner;

public class Bookmain {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		int bookNum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		Book[] books = null;
		double avg = 0;

		while (run) {
			System.out.println("1.도서 수 | 2.도서입력 | 3.도서목록 조회 | 4.도서 분석 | 5.종료");
			System.out.print("선택>");
			int bookNo = Integer.parseInt(scanner.nextLine());

			switch (bookNo) {
			case 1:
				System.out.print("도서 수>");
				bookNum = Integer.parseInt(scanner.nextLine());
				books = new Book[bookNum];
				break;

			case 2:
				for (int i = 0; i < bookNum; i++) {
					System.out.print("책 이름 : ");
					String bookName = scanner.nextLine();
					System.out.print("책 번호 : ");
					int bookNumber = Integer.parseInt(scanner.nextLine());
					System.out.print("책 가격 : ");
					int bookPrice = Integer.parseInt(scanner.nextLine());

					books[i] = new Book(bookName, bookNumber, bookPrice);
					
				}
				break;

			case 3:
				for (Book ele : books) {
					System.out.printf("%s\n", ele.getBookName());
				}
				break;
			case 4:
				String title = null;
				for (Book ele : books) {
					int a = ele.getBookPrice();
					if (max < a) {
						max = a;
						title = ele.getBookName();
					}
					if(min>a) {
						min = a;
					}
					sum +=a;
					avg = (double) sum / books.length;
					System.out.printf("도서 평균 가격 : %.0f원\n", avg);
					System.out.printf("최대 가격 : %d원\n", max);
					System.out.printf("최소 가격 : %d원\n", min);
					System.out.println(title);
				}
				break;
			case 5:
				run = false;
				break;
			default : 
				System.out.println("메뉴 다시 선택 ㄱ");
			}

		}
		System.out.println("끝");
		scanner.close();
	}

	
}
