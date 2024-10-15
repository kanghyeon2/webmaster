package itemMania;

import java.util.List;
import java.util.Scanner;

public class ItemApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ItemDao Idao = new ItemDao();
		int SelNo = 0;
		Member member = null;
		boolean run = true;

		while (run) {
			System.out.println(" ------------------------");
			System.out.println("|  1. 회원가입    2. 로그인 |");
			System.out.println(" ------------------------");
			System.out.println("메뉴 선택 > ");
			SelNo = Integer.parseInt(sc.nextLine());

			switch (SelNo) {
			case 1:
				System.out.print("아이디 : ");
				String id = sc.nextLine();
				System.out.print("비밀번호 : ");
				String pwd = sc.nextLine();
				System.out.print("이름 : ");
				String name = sc.nextLine();
				System.out.print("휴대폰 번호 : ");
				String phone = sc.nextLine();
				System.out.print("주민 번호 : ");
				String residentnumber = sc.nextLine();
				System.out.print("계좌번호 : ");
				String ano = sc.nextLine();
				member = new Member(id, pwd, name, phone, residentnumber, ano, 0);
//				Idao = new ItemDao();
				Idao.memberInsert(member);
				break;

			// 로그인 체크
			case 2:
				while (true) { // id, pwd 정상적이면 true / 없거나 예외 false
					System.out.println("아이디를 입력>>");
					String login_id = sc.nextLine();
					System.out.println("패스워드를 입력>>");
					String login_pwd = sc.nextLine();

					member = Idao.checkMember(login_id, login_pwd);
					if (member != null) {
						System.out.println(member.getName() + "\t환영합니다.");
						while (run) {
							System.out.println(
									" ---------------------------------------------------------------------------------------------------------------------------");
							System.out.println(
									"|  1. 구매(판매 목록)    2. 아이템 등록    3. 구매내역    4. 등록된 아이템 목록    5. 리뷰 보기    6. 잔액 충전    7. 잔액 확인    8 . 나가기  |");
							System.out.println(
									" ---------------------------------------------------------------------------------------------------------------------------");
							System.out.println("메뉴 선택 > ");
							SelNo = Integer.parseInt(sc.nextLine());

							switch (SelNo) {
							case 1:
								while (run) {
									System.out.println(" --------------------------------------------------------");
									System.out.println("|  1. 리니지m  2. 메이플  3. 로스트아크  4. 로드나인  5. 뒤로가기 |");
									System.out.println(" --------------------------------------------------------");
									System.out.println("게임 선택 > ");
									int GameNo = Integer.parseInt(sc.nextLine());
									String gamename;
									if (GameNo == 1) {
										gamename = "리니지m";
										int a = Idao.select(gamename);
										if (a == -1)
											continue;
									} else if (GameNo == 2) {
										gamename = "메이플";
										int a = Idao.select(gamename);
										if (a == -1)
											continue;
									} else if (GameNo == 3) {
										gamename = "로스트아크";
										int a = Idao.select(gamename);
										if (a == -1)
											continue;
									} else if (GameNo == 4) {
										gamename = "로드나인";
										int a = Idao.select(gamename);
										if (a == -1)
											continue;
									} else {
										break;
									}
									System.out.println("구매하시겠습니까");
									System.out.println("y / n");
									String No = sc.nextLine();
									if (No.equals("y")) {
										while (true) { // id, pwd 정상적이면 true / 없거나 예외 false

											System.out.print("구매할 상품명 : ");
											String itemname = sc.nextLine();
											System.out.print("구매개수 : ");
											int num = Integer.parseInt(sc.nextLine());
											Idao.purchase(itemname, num, login_id);

											System.out.println("리뷰를 남기시겠습니까");
											System.out.println("y / n");
											No = sc.nextLine();
											if (No.equals("y")) {
												System.out.println("리뷰 : ");
												String review = sc.nextLine();
												Idao.reviewInsert(itemname, review);
												break;
											} else
												break;
										}
										
									}
								} // end of 로그인체크
								break;
								// 구매 메소드
							case 2:
								while (run) {
									System.out.println(" ---------------------------------------------------------------------");
									System.out.println("|  1. 상품 등록    2. 가격 및 개수 수정    3. 판매 삭제    4. 판매 및 구매 메뉴  |");
									System.out.println(" ---------------------------------------------------------------------");
									System.out.println("메뉴 선택 > ");
									SelNo = Integer.parseInt(sc.nextLine());
									if (SelNo == 1) {
										System.out.print("상품명 : ");
										String itemname = sc.nextLine();
										System.out.print("게임 : ");
										String game = sc.nextLine();
										System.out.print("가격 : ");
										int price = Integer.parseInt(sc.nextLine());
										System.out.print("서버 : ");
										String server = sc.nextLine();
										System.out.print("판매개수 : ");
										int num = Integer.parseInt(sc.nextLine());

										Item item = new Item(itemname, game, price, server, num,"", login_id);
										Idao.itemInsert(item);
										break;

									} else if (SelNo == 2) {
										System.out.print("상품명 : ");
										String itemname = sc.nextLine();
										System.out.println("가격 : ");
										int price = Integer.parseInt(sc.nextLine());
										System.out.print("개수 : ");
										int num = Integer.parseInt(sc.nextLine());
										Idao.update(itemname, price, num);
										break;
									} else if (SelNo == 3) {
										System.out.print("상품명 : ");
										String itemname = sc.nextLine();
										Idao.delete(itemname);
										break;
									} else
										break;
								}
								break;

							case 3:
								System.out.println(" ----------------------------------------------------------------");
								System.out.println("1.목록 보기    2. 구매 내역 삭제하기    3. 판매 및 구매 메뉴");
								System.out.println(" ----------------------------------------------------------------");
								System.out.println("선택 > ");
								int No = Integer.parseInt(sc.nextLine());
								if (No == 1) {
									System.out.println(member.getName() + "님의 구매내역은");
									List<Purchase> list = Idao.getPurchaseHistory(login_id, login_pwd);
									for (Purchase ele : list) {
										System.out.println(ele.toString());
									}

									continue;
								} else if (No == 2) {
									System.out.println("삭제원하는 번호 : ");
									int deleteNo = Integer.parseInt(sc.nextLine());
									Idao.historyDelete(deleteNo);
									break;
								} else {
									break;
								}

							case 4:
								System.out.println("아이템목록");
								Idao.selectAll();
								break;

							case 5:
								System.out.print("원하는 리뷰 아이템명 : ");
								String itemname = sc.nextLine();
								Idao.selectReview(itemname);
								break;

							case 6:
								// 충전
								System.out.print("충전 금액 : ");
								int price = Integer.parseInt(sc.nextLine());
								Idao.charge(login_id, price);
								break;
								
							case 7 :
								System.out.print("마일리지 : ");
								Idao.checkCharge(login_id);
								System.out.println();
								break;
							case 8:
								run = false;
								System.out.print("프로그램 종료");
								break;
							}
						}
						break;

					}
					System.out.println("아이디와 비밀번호를 확인하세요");
				} // end of 로그인체크

			}

		}
		sc.close();
	}
}// end of class
