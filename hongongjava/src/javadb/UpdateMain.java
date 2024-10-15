package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateMain {

	public static void main(String[] args) {
		// 연결하기
		Connection conn = null;

		// jdbc등록
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결
			conn = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "java", // 계정
					"1234" // 비밀번호
			);
			System.out.println("연결성공");

			// 데이터 수정
			String sql = "" 
						+ "update boards " 
						+ "set btitle=?, bcontent=?, bwriter=? " 
						+ "where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(
					sql, new String[] { "bno", "btitle", "bcontent", "bwriter" });
			pstmt.setString(1, "2024년");
			pstmt.setString(2, "10월 5일");
			pstmt.setString(3, "홍길");
			pstmt.setInt(4, 4);

			int rows = pstmt.executeUpdate();
			System.out.println("수정된 갯수 : " + rows);
			if (rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int bno = rs.getInt(1);
					String btitle = rs.getString(2);
					String bcontent = rs.getString(3);
					String bwriter = rs.getString(4);
					System.out.println("저장된 번호 : " + bno + "  " + btitle + "  " + bcontent + "  " + bwriter);
				}
				System.out.println("수정성공");
				rs.close();
			} else {
				System.out.println("수정실패");
			}

			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("연결끊기");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
