package 신강현;

public class Array {

	public static void main(String[] args) {
		//2024.09.26과제
		// 1
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[] random = new int[10];
		for(int i=0; i<random.length; i++) {
			int num = (int)(Math.random()*100)+1;
			random[i] = num;
			sum += random[i];
			if(max<num) max = num;
			if(min>num) min = num;
	
		}
		System.out.println("합계 : " + sum);
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		// 2
		int [][] array = {
				{1,2,3},
				{1,2},
				{1},
				{1,2,3}
		};
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
			
		// 3
		int count = 0;
		int [][] seats = new int[3][10];
			for(int i=0; i<seats.length; i++) {
				for(int j=0; j<seats[i].length; j++) {
					int num = (int)(Math.random()*2);
					seats [i][j] = num;
					System.out.print(seats[i][j]+" ");
					if(num == 1) {
						count++;
					}
					
					
				}
				System.out.println();
			}
		System.out.printf("현재 관객 수는 %d명\n", count);
		
		//4
		
		int avg = 0;
		int [][] grades = new int[3][5];
			for(int i=0; i<grades.length; i++) {
				int sum1 = 0;
				for(int j=0; j<grades[i].length; j++) {					
					int num = (int)((Math.random()*51)+50);
					grades[i][j] = num;
					sum1+=num;
					System.out.print(grades [i][j]+"   ");																		
				};
				System.out.println();
				avg = sum1/(grades[i].length);
				System.out.printf("%d번학생 평균 = %d\n",i+1,avg);
			
			}
			
			
			//5
			String [][] cards ={
				{"Clubs","Diamonds","Hearts","Spades"},
				{"2","3","4", "5", "6","7","8","9","10","Jack","Queen","King","Ace"} 
			};
			for(int i=0; i<5; i++){
			System.out.print(cards[0][(int)(Math.random()*4)]+"의"+"  ");
			System.out.println(cards[1][(int)(Math.random()*13)]);
			}
	
			//6
			int cnt = 0;
			int [][] boxs = new int[3][5];
			while(cnt<5) {										
					int num = (int)(Math.random()*15);
					if(boxs [num/boxs[0].length][num%boxs[0].length] !=1) { 				
						boxs [num/boxs[0].length][num%boxs[0].length] =1;
					cnt++;
					}
				}
			for(int i=0; i<boxs.length; i++) {
				for(int j=0; j<boxs[i].length; j++) {
					System.out.print(boxs[i][j]+"\t");					
						
					}
				System.out.println();
				}

	
				

			
		
			
			

	}//main

}//class
