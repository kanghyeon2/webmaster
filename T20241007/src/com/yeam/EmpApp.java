package com.yeam;

import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmpDAO dao = new EmpDAO();
		int cnt = 0;
		boolean run = true;
		String date = null;
		String department = null;
		
		while (run) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("1. 등록 2. 목록 3. 수정(급여) 4. 삭제 5. 조회(조건:입사일자) 6. 종료 ");
			System.out.println("--------------------------------------------------------------");
			System.out.println("메뉴 선택 > ");
			int SelNo = Integer.parseInt(sc.nextLine());
			switch(SelNo) {
			case 1 : //등록
				System.out.println("[등록]");
				System.out.print("사번입력 : ");
				department = sc.nextLine();
				System.out.print("이름입력 : ");
				String name = sc.nextLine();
				System.out.println("전화번호입력 : ");
				String phone = sc.nextLine();
				System.out.print("입사일입력 : ");
				date = sc.nextLine();
				System.out.print("급여입력 : ");
				int salary = Integer.parseInt(sc.nextLine());
				
				Employee employee = new Employee(department, name, phone, date, salary);
				dao = new EmpDAO();
				cnt = dao.insert(employee);
				if(cnt == 1) {
					System.out.println("추가 성공");
				}else {
					System.out.println("추가 실패");
				}
				break;
			
			case 2 : //목록
				dao.selectAll();
				break;
				
			case 3 : //수정(급여)
				System.out.print("사번 : ");
				department = sc.nextLine();
				System.out.println("급여 : ");
				salary = Integer.parseInt(sc.nextLine());
				dao.update(department, salary);

				break;
			case 4 : //삭제
				System.out.print("사번 : ");
				department = sc.nextLine();
				dao.delete(department);
				break;

			case 5 : //선택2번 : 입사일자
				System.out.print("입사일자 (yyyy-mm-dd) : ");
				date = sc.nextLine();
				System.out.println("사번"+ "\t" + "이름"+ "\t" + "입사일자" + "\t" + "급여");
				dao.select(date);
				break;
			case 6 : //선택6번 : 프로그램 종료
				run = false;
				sc.close();
				System.out.println("프로그램 종료");

			}
		}

	}



	}


