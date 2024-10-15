//package chap10;
//
//public class ExceptionMain {
//
//	public static void main(String[] args) {
//		//NumberFormatException 숫자변경 불가
//		// 예외처리
//		try {
//			Class clazz = Class.forName("java.lang.String");
//			System.out.println("Clazz");
//		} catch (ClassNotFoundException e) {
//			System.out.println("class를 찾지 못했어요");
////			e.printStackTrace();
//		}
//		
//		try {
//			String strNum = "a123"; //
//			int num = Integer.parseInt(strNum);
//			System.out.println(num);
//		} catch (Exception e) {
//			e.printStackTrace(); //오류 보기
////			System.out.println("변경 못함");
//		}
//	}
//
//}
