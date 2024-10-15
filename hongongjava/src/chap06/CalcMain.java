package chap06;

public class CalcMain {

	public static void main(String[] args) {
		// 객체
		Calculator myCalcu = new Calculator();
		
		//정사각형 넓이 구하기
		double result1 = myCalcu.areaRectangle(832.4);
		
		//직사각형 넓이 구하기
		double result2 = myCalcu.areaRectangle(10.54, 20.7);

		System.out.println(result1);
		System.out.println(result2);
	}

}
