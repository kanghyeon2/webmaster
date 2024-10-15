package chap01;

public class Escape88 {

	public static void main(String[] args) {
		System.out.println("번호\t이름\t직업");
		System.out.print("행 단위 출력\n");
		System.out.print("행 단위 출력\n");
		System.out.println("우리는 \"개발자\" 입니다.");
		System.out.println("봄\\여름\\가을\\겨울");
		
		//p91
		boolean stop = true;
		if(!stop) {
			System.out.println("중지합니다.");
		}else {
			System.out.println("시작합니다.");
		}
	
	
		//p103
		//타입변환
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		//byte byteValue3 = byteValue1 + byteValue2; 에러  int값이 아님
		int intValue1 = byteValue1 + byteValue2;
		System.out.println(intValue1);
		
		char charValue1 ='A';
		char charValue2 = 1;
		//char charValue3 = charValue1 + charValue2;  에러
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드=" + intValue2);
		System.out.println("출력문자=" + (char)intValue2);
		
		int intValue3 = 10;
		int intValue4 = intValue3/4;
		System.out.println(intValue4);
		
		int intValue5 = 10;
		//int intvalue6 = 10/4.0; 에러 
		double doubleValue = intValue5/4.0;
		System.out.println(doubleValue);
		
		int x = 1;
		int y = 2;
		double result = (double)x/y;
		System.out.println(result);
		
		//p106
		//문자열 -> 숫자, 숫자 -> 문자열 변환
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println("value1: " + (value1 + 100));
		System.out.println("value2: " + (value2 + 100.0));
		System.out.println("value3: " + value3);
		
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.14);
		String str3 = String.valueOf(true);
		
		System.out.println("str1: " + (str1 +100));
		System.out.println("str2: " + (str2 +100));
		System.out.println("str3: " + str3 +100);
		
		//p109 확인문제
		char c1 = 'a';
		char c2 = (char)(c1 + 1);
		System.out.println(c2);
		System.out.println((int)c2);
		
		int x1 = 5;
		int y1 = 2;
		int result3 = x1/y1;
		System.out.println(result3);

		int a = 5;
		int b = 2;
		double result1 = (double)a / (double)b;
		System.out.println(result1);
		
		double X = 3.5;
		double Y = 2.7;
		int result2 = (int)(X + Y);
		System.out.println(result2);
		
		long var1 = 2L;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		int result9 = (int) (var1 + (int)var2 + var3 + Double.parseDouble(var4));
		System.out.println(result9);
		
		String str11 = 2 + 3 + "";
		String str12 = 2 + "" + 3;
		String str13 = "" + 2 + 3;
		System.out.println(str11);
		System.out.println(str12);
		System.out.println(str13);
		
		byte val11 = Byte.parseByte("10");
		int val12 = Integer.parseInt("1000");
		float val13 = Float.parseFloat("20.5");
		double val14 = Double.parseDouble("3.1459");
		
		System.out.println((int)(val11 + val12 + val13 + val14));
		
		
		
	}//end main
	
}//end class
