package chap06;

public class MemberMain {

	public static void main(String[] args) {
		// 객체 생성
		Member member = new Member();
		Member member2 = new Member("홍길동", "hong");
		member.name = "최하얀";
		member.age = 23;
		System.out.println("이름 : "+member.name);
		System.out.println("나이 : "+member.age);
		System.out.printf("이름 : %s\n나이 : %d\n", member.name, member.age);
		System.out.printf("이름 : %s\n아이디 : %s", member2.name, member2.id);
	}
}
