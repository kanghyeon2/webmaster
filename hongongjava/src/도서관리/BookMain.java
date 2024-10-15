package 도서관리;

import java.util.List;
import java.util.Scanner;

public class BookMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MemberDao mdao = MemberDao.getInstance(); // 싱글톤 방식
		Member member = null;
//		MemberDao mdao = new MemberDao();

		// 로그인 체크
		while (true) { // id, pwd 정상적이면 true / 없거나 예외 false
			System.out.println("아이디를 입력>>");
			String id = sc.nextLine();
			System.out.println("패스워드를 입력>>");
			String pwd = sc.nextLine();

			// 정상적 로그인되면 "홍길동" 환영메세지
//			String name = mdao.checkMember(id, pwd);
			member = mdao.checkMember(id, pwd);
			if (member != null) {
				System.out.println(member.getMemberName() + "\t환영합니다.");
				break;
			}
			System.out.println("아이디와 비밀번호를 확인하세요");
		} // end of 로그인체크

		// 권한이 User => 도서관리 처리
		if (member.getResponsibility().equals("User")) {
			bookManage();
		} else if (member.getResponsibility().equals("Admin")) {
			// 권한이 Admin => 회원관리 처리
			memberManage();
		}

	}// end of main

	static void bookManage() { // 도서관리
		BookDao dao = new BookDao();
		boolean run = true;
		int cnt = 0;

		while (run) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("1. 도서등록 2. 도서검색 3. 도서전체 조회 4. 도서삭제 5. 도서 정보 변경 6. 종료 ");
			System.out.println("--------------------------------------------------------------");
			System.out.println("메뉴 선택 > ");
			int SelNo = Integer.parseInt(sc.nextLine());
			switch (SelNo) {
			case 1: // 선택1번 : 도서등록
				System.out.println("[도서등록]");
				System.out.print("책제목 : ");
				String title = sc.nextLine();
				System.out.print("저자 : ");
				String writer = sc.nextLine();
				System.out.println("가격 : ");
				int price = Integer.parseInt(sc.nextLine());
				System.out.print("책번호 : ");
				String bnum = sc.nextLine();

				Book book = new Book(title, writer, price, bnum);
				dao = new BookDao();
				cnt = dao.insert(book);
				if (cnt == 1) {
					System.out.println("추가 성공");
				} else {
					System.out.println("추가 실패");
				}
				break;
			case 2: // 선택2번 : 도서검색 = > 책제목으로 검색
				System.out.print("책제목 : ");
				String title1 = sc.nextLine();
				dao.select(title1);

				break;
			case 3: // 선택3번 : 도서전체 조회
				dao.selectAll();
				break;
			case 4: // 선택4번 : 도서삭제
				System.out.print("책제목 : ");
				String title2 = sc.nextLine();
				int rows = dao.delete(title2);
				if (rows == 1) {
					System.out.println("성공");
				} else {
					System.out.println("실패");
				}
				break;

			case 5: // 선택5번 : 도서 정보 변경
				System.out.print("책제목 : ");
				String title3 = sc.nextLine();
				System.out.println("가격 : ");
				int price1 = Integer.parseInt(sc.nextLine());
				System.out.print("책번호 : ");
				String bnum1 = sc.nextLine();
//				dao.update(title3, price1, bnum1);
				int rows1 = dao.update(title3, price1, bnum1);
				if (rows1 == 1) {
					System.out.println("성공");
				} else {
					System.out.println("실패");
				}
				break;

			case 6: // 선택6번 : 프로그램 종료
				run = false;
//				sc.close();
				System.out.println("프로그램 종료");

			}
		} // end of while
	}// end of bookManage();

	static void memberManage() { // 회원관리
		System.out.println("관리자 메뉴입니다");
		MemberDao mdao = MemberDao.getInstance(); // 싱글톤 방식
		boolean run = true;
//		int cnt = 0;
		while (run) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("1. 회원등록 2. 회원검색 3 회원목록 출력 4. 회원 정보삭제 6. 회원 정보 변경 6. 종료 ");
			System.out.println("----------------------------------------------------------------");
			System.out.println("메뉴 선택 > ");
			int SelNo = Integer.parseInt(sc.nextLine());
			switch (SelNo) {
			case 1:
				System.out.println("[회원등록]");
				System.out.println("아이디 : ");
				String memberId = sc.nextLine();
				System.out.println("비밀번호 : ");
				String password = sc.nextLine();
				System.out.println("회원 이름 : ");
				String memberName = sc.nextLine();
				System.out.println("휴대폰 번호 : ");
				String phone = sc.nextLine();
				System.out.println("권한 : ");
				String responsibility = sc.nextLine();
				System.out.println("날짜 : ");
				String creationDate = sc.nextLine();
				Member member = new Member(memberId, password, memberName, phone, responsibility, creationDate);		
				
				mdao.insert(member);

				break;
			case 5:// 회원목록 출력
				List<Member> list = mdao.memberList();
				System.out.print("--------------------------------");
				System.out.print(" 회원목록 ");
				System.out.println("--------------------------------");

				for (Member member11 : list) {
					System.out.println(member11.toString());
				}
				break;
			}// end of memberManage();
		}
	}
}
