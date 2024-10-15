package chap10;

public class ThrowsMain {

	public static void main(String[] args) {
		// 예외 떠넘기기
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			System.out.println("Class 찾지 못함");
//			e.printStackTrace();
		}

	}

	private static void findClass() throws ClassNotFoundException {
//		Class clazz = Class.forName("java.lang.String2");
		
	}

}
