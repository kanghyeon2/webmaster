package chap04;

public class Exam173 {

	public static void main(String[] args) {
		// 50에서 100까지 3의 배수 합 구하기
		//3의 배수 출력, 마지막에 3의 배수 합 출력
		int sum = 0;
		int count = 0;
		for(int i=50; i<=100; i++) {			
			if(i%3==0) {
				if(sum != 0) {
				System.out.print(",");
				}
				count++;
				sum+=i;
				System.out.print(i);
			}
			
		}
		System.out.println();
		System.out.println("합 : " + sum);
		System.out.println("개수 : " + count);
		
		//1에서 n까지의 합이 300이 넘는 순간 n값 구하기
		//7의 배수의 합이 300이 넘는 순간의 7의 배수 찾기
		int sum1 = 0;
		int n = 1;
			while(sum1<300) {
				if(n%7 == 0) {
					sum1 += n;										
				}				
				n++;
			}
			System.out.println(n-1);		
			System.out.println(sum1);		
												
			//구구단 : 중첩 반복문
			for(int i=2; i<=9; i++) {
				System.out.print("===" + i + "단" + "===\t");
			}
			for(int i=1; i<=9; i++) {
				System.out.println();
				for(int j=2; j<=9; j++) {
					System.out.printf("%d x %d = %-2d\t", j,i,i*j);
				}
			}
			
			
			
	}

}
