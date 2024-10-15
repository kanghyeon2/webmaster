package paactice;

public class Asdfsd {

	public static void main(String[] args) {

		int num1 = 1;
		int num2 = 0;
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=10; j++) {
				num2++;
				if((j == 3 || j == 6 || j == 9) && (num1 % 30 == 0)) {
					System.out.print("**" + "\t");
				} else if((j == 3 || j == 6 || j == 9) || (num1 % 30 == 0 && j < 10) || (num2 % 30 == 0)) {
					System.out.print("*" + "\t");
				} else {
					System.out.print(num2 + "\t" );
				}
				
			}
			num1 = i*10;
			System.out.println();
		}

	}

}
