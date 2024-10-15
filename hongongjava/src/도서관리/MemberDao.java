package 도서관리;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//	목록(조회조건), 등록, 수정, 삭제, 단건
public class MemberDao extends DAO {
	// 싱글톤 방식
	private static MemberDao instance = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {
		return instance;
	}
	
	// Connection, getOpen, getClose
	// 아이디와 비밀번호 확인해서 true 반환 / false 반환
//	boolean checkMember(String id, String pwd) {
//		getOpen();
//		String sql = "select count(1) from tbl_member "
//					+"where member_id = ? "
//					+"and password = ?"; //조건에 맞으면 1 아니면 0try {
//	psmt = conn.prepareStatement(sql);
//	psmt.setString(1, id);
//	psmt.setString(2, pwd);
//	
//	rs = psmt.executeQuery();
//	if(rs.next()) {
//	   int cnt = rs.getInt(1);
//	   if(cnt>0) // id, pwd 정상적이면 true / 없거나 예외 false 
//		   return true;
//	}
//} catch (SQLException e) {
//	e.printStackTrace();
//}
//return false;
//}
	
		//이름반환
	// Connection, getOpen, getClose
	// 아이디와 비밀번호 확인해서 true 반환 / false 반환 -> 회원이름 반환
//		String checkMember(String id, String pwd) { //boolean > string /count > membername
//			getOpen();
//			String sql = "select member_name from tbl_member "
//					+"where member_id = ? "
//					+"and password = ?"; //조건에 맞으면 1 아니면 0
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, id);
//			psmt.setString(2, pwd);
//			
//			rs = psmt.executeQuery();
//			if(rs.next()) {
//				return rs.getString(1); //문자열반환
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	// 아이디와 비밀번호 확인해서 true 반환 / false 반환 -> 회원이름 반환 -> 권한 추가
	Member checkMember(String id, String pwd) { //boolean > string /count > membername
		getOpen();
		String sql = "select member_name, responsibility from tbl_member "
				+"where member_id = ? "
				+"and password = ?"; //조건에 맞으면 1 아니면 0
	try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, pwd);
		
		rs = psmt.executeQuery();
		if(rs.next()) {
			Member member = new Member(null, null, null, null, null, null);
			member.setMemberName(rs.getString("member_name"));
			member.setResponsibility(rs.getString("responsibility"));
			
			return member;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
	
	
	// 목록조회
	List<Member> memberList(){
		getOpen();
		String sql = "select member_id"
					+",member_name"
					+",password"
					+",phone"
					+",responsibility "
					+",creation_date "
					+"from tbl_member ";
		List<Member> result = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member member = new Member(null, null, null, null, null, null);
				member.setMemberId(rs.getString("member_id"));
				member.setPassword(rs.getString("password"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				member.setCreationDate(rs.getString("creation_date"));
				
				result.add(member);
				//commit필수
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;		
	} // end of memberList()
	
	public int insert(Member member) {
		getOpen();
		
		String sql = ""
				+	"insert into book(member_id, password, member_name, phone, responsibility, creation_date) "
				+ 	"values(?, ?, ?, ?, ?, ? )";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getMemberId());
			psmt.setString(2, member.getPassword());
			psmt.setString(3, member.getMemberName());
			psmt.setString(4, member.getPhone());
			psmt.setString(5, member.getResponsibility());
			psmt.setString(6, member.getCreationDate());
			
			int rows = psmt.executeUpdate()	;
			getClose();
			return rows;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	
	
}
