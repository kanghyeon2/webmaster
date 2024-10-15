package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetMain {

	public static void main(String[] args) {
		// set : 순서 보장 안됨, 중복 객체 저장 불가, 반복자(iterator) 필요함
		Set<String> set = new HashSet<String>();
							
		//hash코드 저장된 주소 16진수로 나타낸 값 확인
		set.add("Java");	
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");			//중복 저장 불가
		set.add("iBATIS");

		int size = set.size(); //객체 수 얻기
		System.out.println("총 객체 수: " + size);

		Iterator<String> iterator = set.iterator(); //반복자 얻기
		while (iterator.hasNext()) {				//객체 수만큼 루핑
			String element = iterator.next();		//1개의 객체를 가져옴
			System.out.println("\t" + element);
		}

		set.remove("JDBC");							//삭제
		set.remove("iBATIS");

		System.out.println("총 객체 수: " + set.size());//저장된 객체 수 얻기

		iterator = set.iterator();					//반복자 얻기
		for (String element : set) {				//향상된 for문 객체 수만큼 루핑
			System.out.println("\t" + element);
		}
			

			set.clear();							//모든 객체를 제거하고 비움
			if (set.isEmpty()) {
				System.out.println("비어있음");
			}
		}

	}

