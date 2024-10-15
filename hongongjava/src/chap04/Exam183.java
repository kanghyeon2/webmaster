package chap04;

import java.util.Scanner;

public class Exam183 {

	public static void main(String[] args) {
		
		for(int x=1; x<=10; x++) {
			for(int y=1; y<=10; y++) {
				if(4*x + 5*y == 60) {
					System.out.printf("(%d,%d)\n", x, y);
				}
			}
		}
		
		
		for(int i = 1; i<5; i++) {
			for(int j=1; j<=i; j++) {	
				System.out.print("*");
			}
			System.out.println();		
		}
	
		
		for(int i = 0; i<4; i++) {
			for(int j=0; j<3-i; j++) {
				System.out.print(" ");				
			}
			for(int k=0; k<i+1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		String stars = "";
		for(int i=1; i<5; i++) {
			stars+= "*";
			System.out.printf("%4s\n", stars);
		}
		
		//7번 switch문
		boolean run =true;
		int balance = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------");
			
			System.out.print("선택 > ");
			int selNo = Integer.parseInt(scanner.nextLine());
			
			switch(selNo) {
			case 1 : System.out.println("예금액 > ");
			int money = Integer.parseInt(scanner.nextLine());
			balance += money;
			break;
			case 2 : System.out.println("출금액 > ");
			money = Integer.parseInt(scanner.nextLine());
			if(money>balance) {
				System.out.println("잔액 부족");
				System.out.println("출금 가능액 :" +balance);
				}else {
					balance -= money;
					
				}
			break;
			case 3 : System.out.println("잔고 > " + (balance));
			break;
			case 4 : 
			run = false;
			break;
			default : System.out.println("잘못입력");
				
			}					
		}
		System.out.println("프로그램 종료");	

		
		
		scanner.close();
	}//main	
}//class
