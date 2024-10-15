package chap01;

import java.io.IOException;

public class System117 {

	public static void main(String[] args) {
		int keyCode;
		
		while(true) {
			try {
				System.out.print("키 입력 : ");
				keyCode = System.in.read();
				System.out.println("keyCode: " + keyCode);
				if(keyCode == 113) {
					break;
				}
			} catch (IOException e) {
				System.out.println("입력 오류 발생");
			}
			
		}
		System.out.println("종료");
		

	}//end main

}//end class
