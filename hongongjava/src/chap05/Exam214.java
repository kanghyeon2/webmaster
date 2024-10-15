package chap05;

public class Exam214 {

	public static void main(String[] args) {
		// 2차원 배열
		int[][] scores = {
				{10,20,30},
				{40,50,60}
		};
		for(int i=0; i<scores.length; i++) {
			for(int j=0; j<scores[i].length; j++)
			System.out.print(scores[i][j] + " ");
		}
		System.out.println();

		int[][] arrays = new int [2][3];
		for(int i=0; i<arrays.length; i++) {
			for(int j=0; j<arrays[i].length; j++) {
				int su = (int)(Math.random()*100)+1;
				arrays [i][j] = su;
				System.out.print(arrays[i][j] + " "+"\n");
		}
			
	}
		//향상된 for 문
		int [] su = {10,200,30,40,-50,777,555};
		//배열의 합, 최대값, 최소값
		//향상된 for문
		int sum =0;
		int max =Integer.MIN_VALUE;
		int min =Integer.MAX_VALUE;
		for (int ele : su) {
			sum+=ele;
			if(ele >max) {
				max = ele;
			}
			if(ele<min) {
				min = ele;
			}
			
		}
		System.out.println(min);
		System.out.println(max);
		System.out.println("sum = "+ sum);
		
	}
}
