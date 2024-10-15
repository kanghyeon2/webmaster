package practice태백;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookMain {
	/*
	1도서등록 2.도서검색 3.도서전체 출력 4.도서삭제 5.도서정보변경 6.종료

	도서 객체 : 책제목, 저자, 가격, 책번호

	도서main에 다 만들기 : 전체메뉴 반복실행
			     메뉴별로 작업
	*/
	
	static Scanner scanner = new Scanner(System.in);
	static Book book;
	static BookDao dao = new BookDao();
	//싱글톤 객체를 리턴받았음.
	static MemberDao mdao = MemberDao.getInstance();
	static Connection conn = null;
	static Member member = null;

	public static void main(String[] args) {
		memberManage();
		bookManage();
	} //end of main
	

	static void bookManage() { //도서관리.
		boolean run = true;
		
		while(run) {
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("1.도서등록 | 2.도서검색 | 3.도서 전체 목록 | 4. 도서삭제 | 5.도서 정보 변경 | 6. 종료");
			System.out.println("------------------------------------------------------------------------------");
			System.out.print("메뉴 이동 > ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			
			
			switch(menuNum) {
			case 1:
				//도서등록
				System.out.println("[도서등록]");
				System.out.println("책 제목을 입력하세요 > ");
				String title = scanner.nextLine();
				String checkTitle = dao.noRe(conn, title);
				if(title.equals(checkTitle)) {
					System.out.println("중복된 책 제목입니다.\n메뉴로 돌아갑니다.");
					break;
				}
				
				System.out.println("저자를 입력하세요 > ");
				String writer = scanner.nextLine();
				System.out.println("책 가격을 입력하세요 > ");
				int bookPrice = Integer.parseInt(scanner.nextLine());
				System.out.println("책 번호를 입력하세요 > ");
				String bookNum = scanner.nextLine();
				
				
				try {
					conn = dao.getConn();
					System.out.println("연결성공");
					book = new Book(title, writer, bookNum, bookPrice);
					
					//데이터 입력
					int rows = dao.insert(conn, book);
					if(rows > 0) {
						System.out.println("저장 성공");
					} else {
						System.out.println("저장 실패");
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				} finally {
					dao.closeConn(conn);
				}

				break;
			case 2:
				//도서검색 책 제목으로 검색
				System.out.println("검색할 책 제목을 입력하세요");
				String titleForCondition= scanner.nextLine();
				try {
					conn = dao.getConn();
					System.out.println("연결성공");
					int rows = dao.selectWhere(conn, titleForCondition);
					if(rows > 0) {
						System.out.println("가져오기 성공");
					} else {
						System.out.println("가져오기 실패");
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				//도서전체 조회
				System.out.println("전체 도서 목록을 조회합니다.");

				try {
					conn = dao.getConn();
					System.out.println("연결성공");
					
					int rows = dao.selectAll(conn);
					if(rows > 0) {
						System.out.println("가져오기 성공");
					} else {
						System.out.println("가져오기 실패");
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				//도서 삭제 책번호 받기
				System.out.println("[도서삭제]");
				System.out.println("삭제할 책의 isbn코드를 입력하세요 > ");
				String inputIsbn = scanner.nextLine();
				
				try {
					conn = dao.getConn();
					System.out.println("연결성공");
					int rows = dao.delete(conn, inputIsbn);
					if(rows > 0) {
						System.out.println("삭제 성공");
					} else {
						System.out.println("삭제 실패");
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				//도서정보변경
				//책제목 : 변경할 책번호, 변경할 책 가격입력 => 수정
				System.out.println("[도서 정보 변경]");
				System.out.println("변경할 책의 제목을 입력하세요 > ");
				String inputTitle = scanner.nextLine();
				
				System.out.println("변경할 책 번호를 입력하세요 > ");
				String changeIsbn = scanner.nextLine();
				
				System.out.println("변경할 가격을 입력하세요 > ");
				int changePrice = Integer.parseInt(scanner.nextLine());
				
				try {
					int rows = dao.update(conn, inputTitle, changeIsbn, changePrice);
					if(rows > 0) {
						System.out.println("변경 성공");
					} else {
						System.out.println("변경 실패");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			}
		}//end of while
	}//end of bookManage
	
	static void memberManage() { //회원관리
		while(true) {
			System.out.println("아이디를 입력하세요 > ");
			String id = scanner.nextLine();
			System.out.println("비밀번호를 입력하세요 > ");
			String pw = scanner.nextLine();
			
			//교수님 해설
			member = mdao.checkMember(id, pw);
			if(member != null) {
				//널이 아니면 무한루프를 빠져나오고 아래 if문 실행됨.
				break;
			} else {
				System.out.println("아이디와 비밀번호를 확인해주세요");
			}	

			
		} //end of 로그인 체크
		
		//권한이 user => 도서관리 처리.
		if(member.getResponsibility().equals("User")) {
			System.out.println(member.getMemberName() + "님 환영합니다.");
			System.out.println("메뉴를 선택해주세요\n");
			bookManage();
		//권한이 admin => 회원관리 처리.
		} else if (member.getResponsibility().equals("Admin")) {
			System.out.println("관리자 메뉴입니다.");
			

			while(true) {
				
				System.out.println("------------------------------------");
				System.out.println("1.회원목록 | 2.회원가입 | 3.회원삭제 | 4.종료");
				System.out.println("----------------------------------\n");
				System.out.println("메뉴를 선택해주세요 > ");
				int menuNum = Integer.parseInt(scanner.nextLine());
				String id = null;
				int result = 0;
				
				switch(menuNum) {
				case 1:
//					회원 목록 출력
					List<Member> list = mdao.memberList();
					System.out.println("[회원목록]\n");
					for(Member ele : list) {
						System.out.println(ele.toString());
					}
					break;
				case 2:
					System.out.println("[회원가입]");
					System.out.println("아이디 입력 > ");
					id = scanner.nextLine();
					
					Member check = mdao.idCheck(id);
					if(id.equals(check.getMemberId())) {
						System.out.println("아이디 중복입니다 \n처음부터 진행해주세요.");
						break;
					}
					
					System.out.println("비밀번호 입력 > ");
					String pw = scanner.nextLine();
					
					System.out.println("이름 입력 > ");
					String name = scanner.nextLine();
					
					System.out.println("전화번호 입력 > ");
					String phone = scanner.nextLine();
					
					result = mdao.join(id, pw, name, phone);
					if(result > 0) {						
						System.out.println("계정 생성 완료");
					} else {
						System.out.println("계정 생성 실패");
					}
					break;
				case 3:
					System.out.println("[회원삭제]");
					System.out.println("삭제할 회원의 아이디 입력 > ");
					id = scanner.nextLine();
					result = mdao.memberDel(id);
					if(result > 0) {
						System.out.println("회원정보가 삭제되었습니다.");
					} else {
						System.out.println("계정 삭제 실패");
					}
					break;
				case 4:
					System.out.println("시스템을 종료합니다.");
					return;
				default :
				}
			
			}
		}
		

	} //end of memberManager

}
