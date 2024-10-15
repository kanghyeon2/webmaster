package chap06;

public class StudentMain {

	public static void main(String[] args) {
		//객체 생성
		Student st1 = new Student("240901", "강땡땡");
		System.out.println(st1.stNo);
		System.out.println(st1.name);
		st1.study();
		
		Student st2 = new Student("240902", "김땡땡");
		System.out.println(st2.stNo);
		System.out.println(st2.name);
		st2.study();
	}

}
