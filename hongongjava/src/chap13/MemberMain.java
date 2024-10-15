package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MemberMain {

	public static void main(String[] args) {
		Set<Member>set = new HashSet<Member>();
		
		set.add(new Member("홍길동", 30));		
		set.add(new Member("홍길동", 30));
		set.add(new Member("최길동", 30));
		set.add(new Member("홍길동", 20));		
		set.add(new Member("홍길동", 25));
		
		System.out.println("총 객체 수 : " + set.size());
		
		Iterator<Member> iterator = set.iterator();
		while (iterator.hasNext()) {				//객체 수만큼 루핑
			Member element = iterator.next();		//1개의 객체를 가져옴
			System.out.println(element.name + element.age);
		}
		System.out.println();
		for(Member ele : set) {
			System.out.println(ele.name + ele.age);
		}
		
	}

}
