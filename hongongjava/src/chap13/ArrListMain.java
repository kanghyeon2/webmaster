package chap13;

import java.util.ArrayList;
import java.util.List;

public class ArrListMain {

	public static void main(String[] args) {
		// List 컬렉션
		// ArrayList 
		List<String> list = new ArrayList<String>();
		
		list.add("java");				//리스트에 추가 .add
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");
		
		int size = list.size();			//저장된 총 객체 수
		System.out.println("총 객체 수 : " + size);
		System.out.println();
		
		String skill = list.get(2);		//2번 인덱스 객체 얻기
		System.out.println("2 :" + skill);
		System.out.println();
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");
		
		for(String obj : list) {		//전체 출력
			System.out.println(obj);
		}
		
	}

}
