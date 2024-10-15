package chap01;

import java.util.Scanner;

public class Exam120 {

	public static void main(String[] args) {
		//문제1 : 출력문 연습
		String name = "감자바";
		int age = 25;
		String tell = "010", tel2 = "123", tel3="4567";
		System.out.println("이름 : " + name);
		System.out.print("나이 : " + age + "\n");
		System.out.printf("전화 : %s-%s-%s \n", tell, tel2, tel3);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫 번재 수:");
		String strNum1 = scanner.nextLine();
		
		System.out.print("두 번재 수:");
		String strNum2 = scanner.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("덧셈 결과:" + result);
		
		System.out.print("이름: ");
		String name1 = scanner.nextLine();
	
		System.out.print("주민번호 앞 6자리: ");
		String number1 = scanner.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = scanner.nextLine();
		
		System.out.println("이름 : " + name1);
		System.out.println("주빈번호 앞 6자리 : " + number1);
		System.out.printf("전화번호 : %s-%s-%s \n" ,  phone.substring(0,3), phone.substring(3,7), phone.substring(7));
		
		System.out.print("첫번째 수 입력 : ");
		int num11 = scanner.nextInt();
		
		System.out.print("두번째 수 입력 : ");
		int num12 = scanner.nextInt();
		
		if(num11>num12) {
			System.out.println(num11-num12);
		}else {
			System.out.println(num12-num11);
		}
		scanner.close();
		
	
	}

}
