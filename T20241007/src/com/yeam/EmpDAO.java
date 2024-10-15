package com.yeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpDAO {
	Connection conn = null;

	// 연결설정 메소드(void)
	public void getOpen() {
		// database 연결
		// jdbc 등록
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
	}

	// 연결끊기 메소드(void)
	public void getClose() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 1. 등록 메소드
	public int insert(Employee employee) {
		getOpen();
		String checkAllsql = "select count(*) from employee_table where emp_department = ?";
		String sql = "" + "insert into employee_table(emp_department, emp_name, emp_phone, emp_date, emp_salary) "
				+ "values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		try {
			PreparedStatement checkPstmt = conn.prepareStatement(checkAllsql);
			checkPstmt.setString(1, employee.getDepartment());
			ResultSet result = checkPstmt.executeQuery();
			if (result.next() && result.getInt(1) > 0) { // 입력 사번의 행개수가 1개이상 있으면
				System.out.println("사원번호가 이미 존재");
				return 0;
			}

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getDepartment());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getPhone());
			pstmt.setString(4, employee.getDate());
			pstmt.setInt(5, employee.getSalary());
			// select
			// sql문장 실행
			int rows = pstmt.executeUpdate();
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	// 2 .목록 메소드
	public List<Employee> selectAll() {
		getOpen();
		String sql = "select * from employee_table " +"order by emp_date";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5));
				System.out.println(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
		return null;
	}

	// 3. 수정 메소드
	public int update(String department, int salary) {
		getOpen();

		String sql = "" + "update employee_table " + "set emp_salary=? " + "where emp_department=?";
		PreparedStatement pstmt;
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, salary);
			pstmt.setString(2, department);
			int rs = pstmt.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
		return 0;
	}

// 4. 삭제 메소드
	public int delete(String department) {
		getOpen();
		String checkAllsql = "select count(*) from employee_table where emp_department = ?";
		String sql = "delete from employee_table " + "where emp_department=?";
		PreparedStatement pstmt;
		try {
			PreparedStatement checkPstmt = conn.prepareStatement(checkAllsql);
			checkPstmt.setString(1, department);
			ResultSet result = checkPstmt.executeQuery();
			if (result.next() && result.getInt(1) == 0) {
				System.out.println("삭제할 사번이 없습니다.");
				return 0;
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, department);
			int rs = pstmt.executeUpdate();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
		return 0;
	}

	// 5. 조회메소드
	public int select(String date) {
		getOpen();
		String checkAllsql = "select count(*) from employee_table where emp_date = ?";
		String sql = "select * from employee_table " + "where emp_date=? " ;
		PreparedStatement pstmt;
		try {
			PreparedStatement checkPstmt = conn.prepareStatement(checkAllsql);
			checkPstmt.setString(1, date);
			ResultSet result = checkPstmt.executeQuery();
			if (result.next() && result.getInt(1) == 0) { // 입사날짜 사람 없을때
				System.out.println("입력한 입사 날짜의 사람이 없습니다.");
				return 0;
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, date);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5));
				System.out.println(emp.getDepartment() + "\t"+ emp.getName() + "\t" + emp.getDate().substring(0,10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
		return 0;
	}

}// class 메소드
