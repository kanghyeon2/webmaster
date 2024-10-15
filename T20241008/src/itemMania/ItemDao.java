package itemMania;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
	PreparedStatement pstmt;
	Connection conn = null;
	ResultSet rs;

	public void getOpen() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// db 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.27:1521:xe", "java", "1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end of getOpen()

	public void getClose() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// end of getClose()

	public int memberInsert(Member member) { // 회원가입
		getOpen();
		String checkAllsql = "select count(*) from tbl_user where mem_id = ?";
		String sql = ""
				+ "insert into tbl_user(mem_id, mem_password, mem_name, mem_phone, mem_residentnumber, mem_account) "
				+ "values(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement checkPstmt = conn.prepareStatement(checkAllsql);
			checkPstmt.setString(1, member.getId());
			ResultSet result = checkPstmt.executeQuery();
			if (result.next() && result.getInt(1) > 0) { // 입력 아이디의 행개수가 1개이상 있으면
				System.out.println("아이디가 이미 존재");
				return 0;
			}

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getResidentnumber());
			pstmt.setString(6, member.getAno());

			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	Member checkMember(String id, String pwd) { // id pwd 체크
		getOpen();
		String sql = "select * from tbl_user " + "where mem_id = ? " + "and mem_password = ?"; // 조건에 맞으면 1 아니면 0
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				Member member = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
				member.setName(rs.getString("mem_name"));
				return member;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
		return null;
	}

	public void selectAll() { //아이템 목록보기
		getOpen();
		String sql = "select * from tbl_item order by itemname";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Item item = new Item(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7));
				System.out.print("상품명" + "\t" + "게임" + "\t" + "가격" + "\t" + "서버" + "\t" + "남은개수" + "\t" + "등록일\n");
				System.out.println(item.getItemname() + "\t" + item.getGame() + "\t" + item.getServer() + "\t"
						+ item.getPrice() + "\t" + item.getNum() + "\t" + item.getRegistrationdate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
	}

	public int select(String gamename) {	
		getOpen();
		String checkAllsql = "select count (*) from tbl_item where game = ?";
		String sql = "select * from tbl_item where game = ? ";
		try {
			PreparedStatement checkPstmt = conn.prepareStatement(checkAllsql);
			checkPstmt.setString(1, gamename);
			ResultSet result = checkPstmt.executeQuery();
			if (result.next() && result.getInt(1) == 0) {
				System.out.print("판매가능 아이템이 없습니다.\n");
				return -1;
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gamename);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Item item = new Item(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7));
				System.out.print("상품명" + "\t" + "게임" + "\t" + "서버" + "\t" + "가격" + "\t" + "남은개수" + "\t" + "등록일\n");
				System.out.println(item.getItemname() + "\t" + item.getGame() + "\t" + item.getServer() + "\t"
						+ item.getPrice() + "\t" + item.getNum() + "\t" + item.getRegistrationdate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
		return 0;
	}

	public int itemInsert(Item item) { // 아이템 등록 메소드
		getOpen();
		//tbl_user 테이블에서 계좌를 가져와서 등록할때 계좌도 넣기
		String sql = "" + "insert into tbl_item(itemname, game, price, server, num, mem_id) " + "values(?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item.getItemname());
			pstmt.setString(2, item.getGame());
			pstmt.setInt(3, item.getPrice());
			pstmt.setString(4, item.getServer());
			pstmt.setInt(5, item.getNum());
			pstmt.setString(6, item.getMemid());

			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getClose();
		return 0;
	}

	public int update(String itemname, int price, int num) { // 아이템 수정 및 삭제 메소드
		getOpen();
		String sql = "" + "update tbl_item " + "set price = ?, " + "	   num = ?	" + "where itemname=?";
		PreparedStatement pstmt;
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, num);
			pstmt.setString(3, itemname);
			int rs = pstmt.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
		return 0;
	}

	public int delete(String itemname) { // 아이템 수정 및 삭제 메소드
		getOpen();
		String sql = "delete from tbl_item where itemname=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, itemname);
			int rs = pstmt.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
		return 0;
	}

	public int purchase(String itemname, int num, String memberid) { // 구매 메소드
		getOpen();
		//구매했을때 구매 등록한 계좌 잔액에 돈 추가하기 (update)
		//1.itemname으로 memid를 검색 하여 그 memid의 값에 계좌를 찾아 + 구매금액
		//result.getString(3) = 아이템의 멤버 아이디
		//위 멤버아이디의  mem_mileage를  mem_mileage + 구매금액으로 업데이트 
		// 구매한 사람 계좌에서 돈 차감(구매할 돈보다 없을경우 마일리지 충전하라고 알림 주기)
		//1. 지금 로그인 아이디 상태에서 tbl_user의 mem_mileage - 구매 금액 
		String selectAllsql = "select price, num, itemname, mem_id from tbl_item where itemname = ? "; 
		String sql = "" + "update tbl_item " + "set num = ? " + "where itemname = ?";
		String purchaseIsql = "insert into tbl_purchase (purchase_id, mem_id, itemname, num, total_price) "
							+ "values(purchaseseq.nextVal, ? ,? ,? ,?)";
		String deletesql = "delete from tbl_item where itemname = ?";
		String updatesql = "update tbl_user set mem_mileage = ? where mem_id = ?";
		String selectsql = "select mem_mileage from tbl_user where mem_id = ?";
		try {
			PreparedStatement selectallPstmt = conn.prepareStatement(selectAllsql);
			selectallPstmt.setString(1, itemname);
			ResultSet result = selectallPstmt.executeQuery();
			result.next();

			// 아이템 재고 체크
			if (result.getInt(2) < num) {
				System.out.println("재고부족");
				return -1;
			};

//			// tbl_item에 구매한후 업데이트
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, (result.getInt(2) - num));
//			pstmt.setString(2, itemname);
//			pstmt.executeQuery();
//			System.out.print(num + "개의 상품을 구매하셨습니다.\n");
//			System.out.print(num * (result.getInt(1)) + "원이 송출되었습니다.\n");

			// tbl_purchase에 구매내역 추가
//			PreparedStatement purchaseIpstmt = conn.prepareStatement(purchaseIsql);
//			purchaseIpstmt.setString(1, memberid);
//			purchaseIpstmt.setString(2, itemname);
//			purchaseIpstmt.setInt(3, num);
//			purchaseIpstmt.setInt(4, num * result.getInt(1));
//			purchaseIpstmt.executeUpdate();
//			if ((result.getInt(2) - num) == 0) {
//				purchaseIpstmt = conn.prepareStatement(deletesql);
//				purchaseIpstmt.setString(1, itemname);
//				purchaseIpstmt.executeUpdate();
//			}
			
			//이 아이템 주인의 마일리지에 추가 
			int number = 0;
			int number1 = 0;
			pstmt = conn.prepareStatement(selectsql);
			pstmt.setString(1, memberid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				number =rs.getInt("mem_mileage");
			}
			pstmt.setString(1, result.getString(4));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				number1 =rs.getInt("mem_mileage");
			}
					
//			getOpen();
			PreparedStatement updatepstmt = conn.prepareStatement(updatesql);
			if(number>=num*result.getInt(1)) { //num*result.getInt(1) 결제 금액
				number = number-num*result.getInt(1); //
				number1 = number1 + num*result.getInt(1);
				updatepstmt.setInt(1, number1);
				updatepstmt.setString(2, result.getString(4));
				updatepstmt.executeUpdate();
				updatepstmt.setInt(1, number);
				updatepstmt.setString(2, memberid);
				updatepstmt.executeUpdate();
				
				// tbl_item에 구매한후 업데이트
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (result.getInt(2) - num));
				pstmt.setString(2, itemname);
				pstmt.executeQuery();
				System.out.print(num + "개의 상품을 구매하셨습니다.\n");
				System.out.print(num * (result.getInt(1)) + "원이 송출되었습니다.\n");
				
				PreparedStatement purchaseIpstmt = conn.prepareStatement(purchaseIsql);
				purchaseIpstmt.setString(1, memberid);
				purchaseIpstmt.setString(2, itemname);
				purchaseIpstmt.setInt(3, num);
				purchaseIpstmt.setInt(4, num * result.getInt(1));
				purchaseIpstmt.executeUpdate();
				if ((result.getInt(2) - num) == 0) {
					purchaseIpstmt = conn.prepareStatement(deletesql);
					purchaseIpstmt.setString(1, itemname);
					purchaseIpstmt.executeUpdate();
				}

			}else {				
				System.out.println("잔액부족");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
		
		return 0;
	}

	public List<Purchase> getPurchaseHistory(String id, String pwd) {// 구매내역 체크 메소드

		getOpen();
		String sql = "select purchase_id, itemname, purchase_date, num, total_price from tbl_purchase where mem_id = ? order by purchase_id";
		List<Purchase> purchases = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Purchase purchase = new Purchase(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getInt(5));
				purchases.add(purchase);

				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
		return purchases;
	}


	public void reviewInsert(String itemname, String text) {
		getOpen();
		String sql = "insert into review (itemname, review) values (?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, itemname);
			pstmt.setString(2, text);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
	}

	public void selectReview(String itemname) {//리뷰보기
		getOpen();
		String checkAllsql = "select count (*) from review where itemname = ?";
		String sql = "select * from review where itemname = ? order by itemname";
		try {

			PreparedStatement checkAllpstmt = conn.prepareStatement(checkAllsql);
			checkAllpstmt.setString(1, itemname);
			ResultSet result = checkAllpstmt.executeQuery();
			if (result.next() && result.getInt(1) == 0) {
				System.out.print("이 상품의 리뷰가 없습니다.\n");
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, itemname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Review review = new Review(rs.getString(1), rs.getString(2));
				System.out.println("상품명 : " + review.getItemname() + "\t" + "리뷰 내용 : " + review.getReview());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
	}

	public void historyDelete(int deleteNo) {//구매내역 삭제
		getOpen();
		String sql = "delete from tbl_purchase where purchase_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deleteNo);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getClose();
	}

	public void charge(String login_id, int price) {//계좌에 마일리지 추가
		getOpen();
		String allSql = "select mem_mileage from tbl_user where mem_id = ?";
		String sql = "update tbl_user set mem_mileage = ? where mem_id = ?";
		try {
			PreparedStatement allpstmt = conn.prepareStatement(allSql);
			allpstmt.setString(1, login_id);
			ResultSet result = allpstmt.executeQuery();
			result.next();	
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, result.getInt(1) + price);
			pstmt.setString(2, login_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int checkCharge(String login_id) {
		getOpen();
		String sql = "select * from tbl_user where mem_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member mem = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				
				System.out.print(mem.getMileage()+"원");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
		return 0;
	}
}// end of class
