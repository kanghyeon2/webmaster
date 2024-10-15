package practice태백;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao extends DAO{
	//필드
	
	Book book = new Book();
	
	public String noRe(Connection conn, String title) {
		
		try {
			conn = getConn();
			
			String sql = "" +
					 "select title " +
				     "from   book " +
				     "where title=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Book bd = new Book();
				return rs.getString(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(conn);
		}
		return null;
		
	}
	
	//3.insert메소드
	public int insert(Connection conn, Book book) throws SQLException {
		//연결성공되면 아래
		
		String sql = "" +
	     "insert into book (title, " +
	     "                  writer, " +
	     "                  price, " +
	     "                  bnum ) "+
	     "values (?, "+
	     "        ?, " +
	     "        ?, " +
	     "        ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getWriter());
		pstmt.setInt(3, book.getBookPrice());
		pstmt.setString(4, book.getBookNum());
		int rows = pstmt.executeUpdate();
		pstmt.close();
		return rows;
	}
	//4.select where 조건에 따른 검색(책제목)
	public int selectWhere(Connection conn, String titleForCondition) throws SQLException {
		String sql = "" +
	                 "select * " +
				     "from book " +
	                 "where title like ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, titleForCondition + "%");
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Book book = new Book();
			book.setTitle(rs.getString(1));
			book.setWriter(rs.getString(2));
			book.setBookPrice(rs.getInt(3));
			book.setBookNum(rs.getString(4));
			System.out.println(book);
		}
		int rows = pstmt.executeUpdate();
		pstmt.close();
		rs.close();
		return rows;
		
		
		
		
	}
	//5.select 목록전체 조회
	public int selectAll(Connection conn) throws SQLException {
		String sql = "" +
	                 "select * " +
				     "from   book";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Book book = new Book();
			book.setTitle(rs.getString(1));
			book.setWriter(rs.getString(2));
			book.setBookPrice(rs.getInt(3));
			book.setBookNum(rs.getString(4));
			System.out.println(book);
		}
		int rows = pstmt.executeUpdate();
		pstmt.close();
		rs.close();
		return rows;
		
	}
	//6.delete 삭제
	public int delete(Connection conn, String isbn) throws SQLException {
		String sql = "" +
	                 "delete " +
				     "from   book " +
	                 "where  bnum=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, isbn);
		int rows = pstmt.executeUpdate();
		pstmt.close();
		return rows;
	}
	//7.update 메소드(책제목 : 변경할 책변호, 밴경할 책가격 입력 => 수정)
	public int update(Connection conn, String title, String changeIsbn, int changePrice) throws SQLException {
		String sql = "" +
	                 "update book " +
				     "set    bnum=?, price=? " +
				     "where  title=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);	//업데이트된 행 수 반환
		pstmt.setString(1, changeIsbn);
		pstmt.setInt(2, changePrice);
		pstmt.setString(3, title);
		int rows = pstmt.executeUpdate();
		pstmt.close();
		return rows;
	}

	

}
