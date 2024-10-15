package 도서관리;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDao extends DAO { // DAO 클래스 상속
//	Connection conn = null;
//
//	// 1. 연결설정 메소드(void)
//	public void getOpen() {
//		// database 연결
//		// jdbc 등록
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			// db 연결
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "1234");
//			System.out.println("연결성공");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	// 2. 연결끊기 메소드(void)
//	public void getClose() {
//		if (conn != null) {
//			try {
//				conn.close();
//				System.out.println("연결끊음");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

	// 3. insert 메소드
	public int insert(Book book) {
		getOpen();

		// 데이터 추가
		String sql = "" + "insert into book(title,writer,price,bnum) " + "values(?, ?, ?, ?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getBnum());
			// select
			// sql문장 실행
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	// 4. select : 조건에 따른 검색(책제목) 메소드
	public int select(String title1) {
		getOpen();
		String sql = "select * from book " + "where title=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title1);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Book bk = new Book(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				System.out.println(bk);
			}
			// 생성자 안만들면
//			while (rs.next()) {
//				Book bk = new Book();
//				bk.setPrice(rs.getInt(1));
//				bk.setTitle(rs.getString(2));
//				bk.setWriter(rs.getString(3));
//				bk.setBnum(rs.getString(4));
//				System.out.println(bk);
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}
		return 0;
	}

	// 5. select : 목록전체 조회 메소드
	public List<Book> selectAll() {
		getOpen();
		String sql = "select * from book";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Book bk = new Book(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				System.out.println(bk);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getClose();
		return null;
	}

	// 6. delete 메소드 (북번호 이용)
	public int delete(String title2) {
		getOpen();
		String sql = "delete from book " + "where title=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title2);
			int rs = pstmt.executeUpdate();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}
		return 0;
	}

	// 7. update 메소드 (책제목의 가격과 책번호 수정)
	public int update(String title3, int price1, String bnum1) {
		getOpen();
		String sql = "" + "update book " + "set price=?, bnum=? " + "where title=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price1);
			pstmt.setString(2, bnum1);
			pstmt.setString(3, title3);
			int rs = pstmt.executeUpdate();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}
		return 0;
	}
}// end class
