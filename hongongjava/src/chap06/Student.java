package chap06;

public class Student {
	//필드(속성)
	String stNo;
	String name;
	
	//생성자(객체 생성)->객체의 속성을 초기화
	Student(String stNo, String name){
		this.stNo = stNo;
		this.name = name;
	}
	
	//메소드(기능)
	void study() {
		System.out.println("공부합니다");
	}
}
