package chap06;

public class StudentoMain {
//배열로 Studento[] students = {};
	public static void main(String[] args) {
		Studento student1 = new Studento(11, "이름1", 49, 58, 97);
		Studento student2 = new Studento(12, "이름2", 99, 98, 88);
		Studento student3 = new Studento(13, "이름3", 69, 98, 83);
		Studento student4 = new Studento(14, "이름4", 59, 78, 86);
		Studento student5 = new Studento(15, "이름5", 10, 68, 77);
		
		Studento [] students = {
				new Studento(11, "이름1", 49, 58, 97),
				new Studento(12, "이름2", 99, 98, 88),
				new Studento(13, "이름3", 69, 98, 83),
				new Studento(14, "이름4", 59, 78, 86),
				new Studento(15, "이름5", 10, 68, 77)
		};
		
		for(Studento ele : students) {
			System.out.printf("%4.2f	%d	%d	%d\n", ele.avg(), ele.plus(),ele.english, ele.department);
		}
		student1.result1();
		student2.result1();
		student3.result1();
		student4.result1();
		student5.result1();

	}

}
