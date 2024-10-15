package chap06;

public class ComputerMain {

	public static void main(String[] args) {
		// 
		Computer myCom = new Computer();
		int [][] values1 = {{1,2,3},
							{1,2,3,4}};
		int result1 = myCom.sum1(values1);
		System.out.println(result1);
		
		int result2 = myCom.sum2(1,2,3);
		System.out.println(result2);
		
		int result3 = myCom.sum3(5,53,26,74,34);
		System.out.println(result3);
		
//		int result4 = myCom.sum1(new int[] {1,2,3,4});
//		System.out.println(result4);
	}

}
