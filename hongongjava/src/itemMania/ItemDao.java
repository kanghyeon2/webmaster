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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end of getOpen()	
	public void getClose() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//end of getClose()
	
	public int memberInsert(Member member) { // 회원가입
		getOpen();
		String checkAllsql = "select count(*) from tbl_user where mem_id = ?";
		String sql = ""
				+	"insert into tbl_user(mem_id, mem_password, mem_name, mem_phone, mem_residentnumber, mem_account) "
				+	"values(?, ?, ?, ?, ?, ?)";
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
			
			int rows = pstmt.executeUpdate()	;
			getClose();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	Member checkMember(String id, String pwd) { //id pwd 체크
		getOpen();
		String sql = "select * from tbl_user "
				+"where mem_id = ? "
				+"and mem_password = ?"; //조건에 맞으면 1 아니면 0
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		
		rs = pstmt.executeQuery();
		if(rs.next()) {
			Member member = new Member(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			member.setName(rs.getString("mem_name"));
			return member;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	
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
			rs = pstmt.executeQuery()	;
			while(rs.next()) {
				Item item = new Item(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				System.out.print("상품명" +"\t"+ "게임"	 +"\t"+ "가격"  +"\t" + "서버" +"\t"+ "남은개수"  +"\t"+ "등록일\n");
				System.out.println(item.getItemname()  +"\t"+ item.getGame()  +"\t"+ item.getServer() +"\t"+ item.getPrice() +"\t"+ item.getNum() +"\t"+item.getRegistrationdate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;		
	}


	
	public int itemInsert(Item item) { // 아이템 등록 메소드
		getOpen();		
		String sql = ""
				+	"insert into tbl_item(itemname, game, price, server, num) "
				+	"values(?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item.getItemname());
			pstmt.setString(2, item.getGame());
			pstmt.setInt(3, item.getPrice());
			pstmt.setString(4, item.getServer());
			pstmt.setInt(5, item.getNum());
			
			int rows = pstmt.executeUpdate()	;
			getClose();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int update(String itemname, int price, int num) { //아이템 수정 및 삭제 메소드
		getOpen();
		String sql = "" 
				+ 	"update tbl_item " 
				+ 	"set price = ?, "
				+   "	   num = ?	"
				+ 	"where itemname=?";
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
	
	public int delete(String itemname) { //아이템 수정 및 삭제 메소드
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
	
	public int purchase(String itemname, int num, String memberid) { //구매 메소드
		getOpen();
		String selectAllsql = "select price, num from tbl_item where itemname = ? ";
		String sql = ""
				+   "update tbl_item "
				+	"set num = ? "
				+ 	"where itemname = ?";
		String purchasesql = "insert into tbl_purchase (mem_id, itemname, num, total_price) "
				+ 			"values(? ,? ,? ,?)";
		try {
			PreparedStatement selectPstmt = conn.prepareStatement(selectAllsql);
			selectPstmt.setString(1, itemname);
			ResultSet result = selectPstmt.executeQuery();
			result.next();		
			//아이템 재고 체크
			if(result.getInt(2)<num) {
				System.out.println("재고부족");
				return -1;
			}
			//tbl_item에 구매한후 업데이트
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (result.getInt(2)-num));
			pstmt.setString(2, itemname);
			pstmt.executeQuery();
			System.out.print(num + "개의 상품을 구매하셨습니다.\n");
			System.out.print(num * (result.getInt(1)) + "원이 송출되었습니다.");
			
			//tbl_purchase에 구매내역 추가
			 pstmt = conn.prepareStatement(purchasesql);
	            pstmt.setString(1, memberid);
	            pstmt.setString(2, itemname);
	            pstmt.setInt(3, num);
	            pstmt.setInt(4, num * result.getInt(1)); 
	            pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
		return 0;
	}
	
	public List<Purchase> getPurchaseHistory(String id, String pwd) {//구매내역 체크 메소드
	    getOpen();
	    String sql = "select itemname, purchase_date, num, total_price from tbl_purchase where mem_id = ?";
	    List<Purchase> purchases = new ArrayList<>();

	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, id);
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            String itemName = rs.getString(1);
	            String purchaseDate = rs.getString(2);
	            int quantity = rs.getInt(3);
	            int totalPrice = rs.getInt(4);
	            
	            Purchase purchase = new Purchase(itemName, purchaseDate, quantity, totalPrice);
	            purchases.add(purchase);
	            
	            System.out.println();
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        getClose(); 
	    }
	    
	    return purchases;
	}
	
}//end of class
