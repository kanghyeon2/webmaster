package 신강현;

import java.util.Scanner;

public class Doself {

	public static void main(String[] args) {
		// 1. 
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("년도를 입력하세요 : ");
		int year = Integer.parseInt(scanner.nextLine());
		
		if(year%4==0) {
			if(year%100 != 0) {
				System.out.println("##년도 입력 :" + year);
				System.out.println(year+"년은 윤년입니다.");
			}
		}else if(year%400 ==0) {
			System.out.println("##년도 입력 :" + year);
			System.out.println(year+"년은 윤년입니다.");
		}else {
			System.out.println("##년도 입력 :" + year);
			System.out.println(year+"년은 평년입니다.");
		}
		
		
		//2.
		System.out.println("교환할 금액 : ");
		int money = Integer.parseInt(scanner.nextLine());
		
		int m500 = money/500;
		int m100 = money%500/100;
		int m50  = money%100/50;
		int m10  = money%50/10;
		int exchange = 500*m500 + 100*m100 + 50*m50 + 10*m10;  
		
		System.out.println("##교환할 금액 :" + money+"원");
		System.out.println("500원 짜리 : " + m500+"개");
		System.out.println("100원 짜리 : " + m100+"개");
		System.out.println("50원  짜리 : " + m50+"개");
		System.out.println("10원  짜리 : " + m10+"개");
		System.out.println("교환   금액 : " + exchange+"원");
		System.out.println("남은   금액 : " + (money - exchange)+"원");
		

		
		//3
		boolean run =true;
		int su = (int)(Math.random()*100)+1;
		System.out.println("숫자 입력 : ");
		
		while(run) {
			int num = Integer.parseInt(scanner.nextLine());
		if(num<su) {
			System.out.println("up하세요!!");
		}else if(num>su) {
			System.out.println("down하세요!!");
		}else { System.out.println("축하합니다!!");
		break;}
		}
		
		//4
		for(int i=2; i<=9; i++) {
			System.out.print("===" + i + "단" + "===\t");
		}
		for(int i=1; i<=9; i++) {
			System.out.println();
			for(int j=2; j<=9; j++) {
				System.out.printf("%d x %d = %-2d\t", j,i,i*j);
			}
		}
		
		
		//5
		System.out.println();
		System.out.println("--------------");
		System.out.println("1. 화씨 => 섭씨");
		System.out.println("2. 섭씨 => 화씨");
		System.out.println("3. 종료");
		System.out.println("--------------");
		
		while(run) {
		System.out.print("번호 선택 : ");
		int num = Integer.parseInt(scanner.nextLine());
		
		switch(num) {
		case 1 : System.out.print("화씨 온도 입력 : " );
		int tempF = Integer.parseInt(scanner.nextLine());
		System.out.println("섭씨 온도 = " + (double)5/9*(tempF-32));
		break;
		
		case 2 : System.out.print("섭씨 온도 입력 : " );
		int tempC = Integer.parseInt(scanner.nextLine());
		System.out.println("화씨 온도 = " + ((double)9/5*tempC + 32));
		break;
		
		case 3 : run = false;
				
		}
		
	}
	System.out.println("program end");
	

		
		//6
		int random_su = (int)(Math.random()*3);
		
		System.out.print("## 가위(0) 바위(1) 보(2) : ");
		int my = Integer.parseInt(scanner.nextLine());
		
		if(random_su - my == 0) {
			System.out.printf("사람 %d, 컴 %d 비겼음\n", my, random_su);
		}else if (random_su - my == 1 || random_su-my == -2 ) {
			System.out.printf("사람 %d, 컴 %d 컴 승리\n", my, random_su);
		}else if(random_su - my == 2 || random_su-my == -1){
			System.out.printf("사람 %d, 컴 %d 사람 승리\n", my, random_su);
		}else if(my>=3) {
			System.out.println("game over");
			
		}
		
		
		//7
		for(int i=1; i<=50; i++) {
			int a = i/10; // 10의자리
			int b = i%10; // 1의 자리
			
			boolean cond1 = a==3 || a==6 || a==9;
			boolean cond2 = b==3 || b==6 || b==9;
			if(cond1 && cond2 ) { //i/10 = 10의자리 i%10 = 1의자리 
			System.out.print("♥♥\t");
			}else if(cond1 || cond2) {
					System.out.print("♥\t");
			}else {
				System.out.print(i+"\t");
			}
			if(b==0) {
				System.out.println();
			}
		}
	
		

		scanner.close();
	}//main
		
}//class