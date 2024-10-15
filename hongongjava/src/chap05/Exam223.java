package chap05;

import java.util.Scanner;

public class Exam223 {

	public static void main(String[] args) {
		// 확인문제 6번
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		int max = 0;
		int sum = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------");
			System.out.print("선택 >");
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			
			
		switch(selectNo) {
		case 1 :
			System.out.print("학생수 > ");
			studentNum = Integer.parseInt(scanner.nextLine());
			break;
		case 2 :			
			scores = new int[studentNum]; 
			for(int i=0; i<studentNum; i++) {
				System.out.printf("scores[%d]>",i);				
				scores[i] = Integer.parseInt(scanner.nextLine());
				if(max<scores[i]) {
					max = scores[i];
				}
				sum += scores[i];				
			}
			break;
		case 3 :
			for(int i=0; i<studentNum; i++) {
				System.out.printf("scores[%d]>%d\n", i, scores[i]);
			}
				break;
		case 4 :			
			System.out.println(max);
			double avg = (double) sum /scores.length;
			System.out.println(avg);
			break;

		case 5 :
			run = false;
		}
		}
		System.out.println("프로그램 종료");
		
		scanner.close();
	}

}
