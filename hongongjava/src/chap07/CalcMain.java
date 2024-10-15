package chap07;

public class CalcMain {

	public static void main(String[] args) {
		Computer com = new Computer();
		Calculator calc = new Calculator();

		double result = com.ac(10);
		System.out.println("자식 메소드 : " + result);

		result = calc.areaCircle(10);
		System.out.println("부모 메소드 : " + result);
	}
}
