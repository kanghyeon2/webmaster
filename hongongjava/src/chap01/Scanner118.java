package chap01;

import java.util.Scanner;

public class Scanner118 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String strin;
		//문자
		System.out.print("문자열입력 > ");
		strin = scanner.nextLine();
		System.out.println("입력 받은 문자열 : " + strin);
		
		
		//주소 가져오기 
		if(strin == "q") {
			System.out.println("q입력");
		}else {
			System.out.println("같지않음");
		}
		
		if(strin.equals("q")) {
			System.out.println("q 입력 됨");
		}else {
			System.out.println("같지 않음");
		}
	
		//숫자
		System.out.print("숫자 입력 > ");
		int valInt = scanner.nextInt();
		System.out.println("입력 받은 숫자 : " + valInt);
		strin = scanner.nextLine();
		
		System.out.println("숫자 입력 > ");
		valInt = Integer.parseInt(scanner.nextLine());
		System.out.println("입력 받은 문자열 : " + (valInt + 100));
		scanner.close();
		
		
	}

}
