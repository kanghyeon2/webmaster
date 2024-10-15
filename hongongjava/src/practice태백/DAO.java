package practice태백;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//db연결하는 객체

//연결, 연결끊기 메소드 상속해주기위한 클래스
public class DAO {
	PreparedStatement pstmt;
	Connection conn = null;
	ResultSet rs;
	
	//메소드
		//1.연결 설정 메소드
		public Connection getConn() throws ClassNotFoundException, SQLException {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
		}
//		2.연결끊기 메소드
		public void closeConn(Connection conn) {
			if(conn != null) {
				try {
					conn.close();				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
