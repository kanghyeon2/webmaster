package 연습;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountDao {
	Connection conn = null;

	// 1. 연결 메소드
	public void getOpen() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// db 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "1234");
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 2. 연결 끊기 메소드
	public void getClose() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("연결끊음");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 3. insert 메소드
	public int insert(Account account) {
		getOpen();

		// 데이터 추가

//		String checkSql = "SELECT COUNT(*) FROM account WHERE ano = ?";
		String sql = "" + "insert into account(ano,owner,balance) " + "values(?, ?, ?)";
		PreparedStatement pstmt;
		try {
//			PreparedStatement checkPstmt = conn.prepareStatement(checkSql);
//			checkPstmt.setString(1, account.getAno());
//			ResultSet result = checkPstmt.executeQuery();
//			
//			if (result.next() && result.getInt(1) > 0) {
//				// 계좌가 이미 존재하는 경우
//				System.out.println("계좌 번호가 이미 존재합니다.");
//				return 0; // 또는 다른 적절한 값을 반환
//			}

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAno());
			pstmt.setString(2, account.getOwner());
			pstmt.setInt(3, account.getBalance());

			// select
			// sql문장 실행
			int rows = pstmt.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}
		return 0;

	}

	// 4. select : 조건에 따른 검색(소유자)
	public int select(String owner1) {
		getOpen();
		String sql = "select * from account " + "where owner=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, owner1);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Account ac = new Account(rs.getString(1), rs.getString(2), rs.getInt(3));
				System.out.println(ac);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}
		return 0;

	}

	// 5. selectAll : 전체 조회 메소드
	public List<Account> selectAll() {
		getOpen();
		String sql = "select * from account";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Account ac = new Account(rs.getString(1), rs.getString(2), rs.getInt(3));
				System.out.println(ac);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getClose();
		return null;

	}

	// 6. delete : 삭제 메소드 (계좌 번호 이용)

	public int delete(String ano1) {
		getOpen();
		String sql = "delete from account " + "where ano=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ano1);
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

	// 7. 예금 메소드
	public int deposit(String ano, int money) {
		getOpen();
		String selectsql = "select balance from account where ano = ?"; // 현재 잔액 조회 쿼리
		String sql = "" + // 업데이트 쿼리
				"update account " + "set balance=?" + "where ano=?";

		try {
			PreparedStatement selectPstmt = conn.prepareStatement(selectsql);
			selectPstmt.setString(1, ano);
			ResultSet result = selectPstmt.executeQuery();

			if (result.next()) {
				int currentBalance = result.getInt("balance");
				int newBalance = currentBalance + money;
				PreparedStatement pstmt;
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, newBalance);
				pstmt.setString(2, ano);
				int rs = pstmt.executeUpdate();
				return rs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}
		return 0;
	}

	// 8. 출금 메소드
	public int Withdrawal(String ano, int money) {
		getOpen();
		String selectsql = "select balance from account where ano = ?"; // 현재 잔액 조회 쿼리
		String sql = "" + // 업데이트 쿼리
				"update account " + "set balance=?" + "where ano=?";

		try {
			PreparedStatement selectPstmt = conn.prepareStatement(selectsql);
			selectPstmt.setString(1, ano);
			ResultSet result = selectPstmt.executeQuery();
			if (result.next()) {
				int currentBalance = result.getInt("balance");
				int newBalance = currentBalance - money;
				PreparedStatement pstmt;
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, newBalance);
				pstmt.setString(2, ano);
				int rs = pstmt.executeUpdate();
				return rs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}
		return 0;
	}

	// 중복확인 메소드
}
