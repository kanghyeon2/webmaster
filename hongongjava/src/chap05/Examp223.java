package chap05;

public class Examp223 {

	public static void main(String[] args) {
		// 5번
		int[][] array = {
				{95,82},
				{83,92,96},
				{78,83,93,87,88}
		};
		
		int sum =0;
		double avg = 0.0;
		int count = 0;
		for (int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
			sum += array [i][j];						
			count++;
			
				System.out.println(array[i].length);
				
		}
		avg = (double)sum/count;
			System.out.println(sum);
			System.out.println(avg);
			System.out.println(count);
		}
	}
}


