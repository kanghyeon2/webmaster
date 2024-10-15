package chap05;

public class Exam232 {

	public static void main(String[] args) {
		LoginResult result = LoginResult.FAIL_ID;
		if(result == LoginResult.SUCCESS) {
			System.out.println("로그인성공");
		}else if(result == LoginResult.FAIL_ID) {
			System.out.println("아이디 틀림");
		}else if(result == LoginResult.FAIL_PASSWORD) {
			System.out.println("비밀번호 틀림");
		}
	}

}
