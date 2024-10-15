package chap06;

public class Studento {
	//필드
	//학번 이름 국어 영어 수학 ->객체 생성
	int department;
	String name;
	int korean;
	int english;
	int mathe;
	
	//생성자
	Studento(int department, String name, int korean, int english, int mathe){
		this.department = department;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.mathe = mathe;
	}	
	
	//메소드
	int plus() {
		return korean + english + mathe;
	}
	
	double avg() {
		double result = plus()/3;
		return result;
	}
	//switch
	 String grade() {
		if(avg()>=90) {
			return "A";
		}else if(avg()>=80) {
			return "B";
		}else if(avg()>=70) {
			return "C";
		}else if(avg()>=60) {
			return "D";
		}else {
			return "F";
		}
	 }
		void result1() {
		System.out.printf("%s : %d : %d : %d : %d : %.2f : %s\n", name, korean, english, mathe, plus(), avg(), grade());
		
	}
	 
}

