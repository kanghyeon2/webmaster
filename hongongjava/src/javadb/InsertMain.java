package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertMain {

	public static void main(String[] args) {
		// 데이터 추가
		Connection conn = null;
		try {
			// jdbc 드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "1234");
			System.out.println("연결 성공");

			// 데이터 추가
			String sql = "" 
							+ "insert into boards (bno, btitle, bcontent, bwriter, bdate) "
							+ "values(seq_bno.nextVal, ?, ?, ?, sysdate)";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno","btitle"});

			pstmt.setString(1, "눈오는 밤");
			pstmt.setString(2, "눈이 펑펑 내려요");
			pstmt.setString(3, "snow");
			
			//sql문 실행
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					int bno = rs.getInt(1); // int bno = rs.getInt(1); 1<<컬럼번호
					String btitle = rs.getString(2);
					System.out.println("저장된 번호 : " + bno + "  " + btitle);

				}
				System.out.println("추가성공");
				rs.close();
			} else {
				System.out.println("추가실패");
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
					System.out.println("연결 끊기");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
