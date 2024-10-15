package chap05;

public class Exam202 {

	public static void main(String[] args) {
		
//		int args1 = Integer.parseInt(args[2]);
//		System.out.println(args1);
		
		// 배열을 생성하는 방법
		// 배열을 이용하는 방법
		
		int [] scores = {83, 90, 87};
		
		System.out.println("scores[0] : " + scores[0]);
		System.out.println("scores[1] : " + scores[1]);
		System.out.println("scores[2] : " + scores[2]);
		
		int sum = 0;
		for(int i=0; i<scores.length; i++) {
		sum += scores[i];
	}
		System.out.println("총합 : " + sum);
		double avg = (double) sum /scores.length;
		System.out.printf("평균 : %.2f\n", avg);
		
		// 배열에 1에서 100까지의 임의의 수 10개를 저장
		// 배열의 합과 평균 (소수첫째자리까지)
		// 최대값, 최소갑을 구하세요
		int sum1 = 0;
		int max = 0;
		int min = 101;
		int [] random = new int[10];		
		for(int i=0; i<random.length; i++) {
			int num = (int)(Math.random()*100)+1;			
			random[i] = num;
			sum1 += random[i];	
		
			if(max<random[i]) {
			max = random[i];
		} 
		
			if(min>random[i]){
			min = random[i];
		}
		System.out.print(random[i]+" ");
	}
		
		
		System.out.println();
		double avg1 = (double) sum1 /random.length;
		System.out.println("합 : " + sum1);
		System.out.printf("평균 : %.1f\n", avg1);
		System.out.println("최대값 : " + max );
		System.out.println("최소값 : " + min );
		
		
	}//main
}//class
