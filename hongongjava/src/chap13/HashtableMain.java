package chap13;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashtableMain {

	public static void main(String[] args) {
		// HashTable : 멀티스레드 환경에 안전하게 사용하는 map
		Map<String, String> map = new Hashtable<String, String>();

		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("아이디 비번 입력");
			System.out.print("아이디: ");
			String id = scanner.nextLine();
			System.out.println("비밀번호: ");
			String password = scanner.nextLine();
			System.out.println();

			if (map.containsKey(id)) {
				if (map.get(id).equals(password)) {
					System.out.println("로그인");
					break;
				} else {
					System.out.println("비밀번호 불일치");
				}
			} else {
				System.out.println("입력하신 아이디가 존재 x");
			}
		}
scanner.close();
	}

}
