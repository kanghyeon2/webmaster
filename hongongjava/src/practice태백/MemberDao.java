package practice태백;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//c / r / u / d 만들어야 함.
//목록 가져오기(조회조건), 등록하기, 수정하기, 삭제하기, 단건조회
public class MemberDao extends DAO{
	
	//부모 클래스가 가지고 있는 자원들을 모두 사용가능
	
	//인스턴스를 계속 만들면 자원이 부족해질 수 있음 그럴때 싱글톤으로 만들면 됨.
	private static MemberDao instance = new MemberDao();
	private MemberDao() {};
	public static MemberDao getInstance() {
		return instance;
	}
	
	//목록조회
	List<Member> memberList() {
		//반환할 변수 선언 현재는 아무 값이 없음 쿼리 결과를 담을거임
		List<Member> result = new ArrayList<>();
		
		String sql =  "select member_id, "
				+ "       password, "
				+ "       member_name,"
				+ "       phone, "
				+ "       responsibility, "
				+ "       creation_date "
				+ "from   tbl_member ";
		
		try {
			conn = getConn();

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//데이터가 몇건 있는지 알 수 없으니까 while이 더 좋음 for문보다
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setPassword(rs.getString("password"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				member.setCreationDate(rs.getDate("creation_date"));
				
				//여기까지 만든 member를 리스트어레이에 추가
				result.add(member);
			}
			rs.close();
			pstmt.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(conn);
		}
		
		return result;
				
			
	}	//end of memberList()
	
	//아이디와 비밀번호를 확인해서 있으면 true 없으면 false를 반환하기(꼭 true false상관없음)
	//회원의 권한도 추가해서 가져오기
	Member checkMember(String id, String pw) {
		Member member = new Member();
		
		String sql = "select member_name, "
				+ "          responsibility "
				+ "   from   tbl_member	"
				+ "   where  member_id=? "
				+ "   and    password=? ";
		
		try {
			conn = getConn();
			//count는 쿼리 실행 결과의 개수를 가져옴
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			//아이디가 프라이머리키라서 반복문이 필요없음 어차피 하나만 있음
			if(rs.next()) {
				member.setMemberName(rs.getString("member_name"));
				member.setResponsibility(rs.getString("responsibility"));
				
				rs.close();
				pstmt.close();
				
				return member;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(conn);
		}
		//id 와 pw가 없으면 false
		return null;
		
	}
	
	
	public Member idCheck(String id) {
		Member member = new Member();
		String sql = "select member_id "
				+ "   from   tbl_member "
				+ "   where  member_id = ?";
		
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setMemberId(rs.getString(1));
				return member;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	//회원가입 메소드 만들기(insert)
	public int join(String id, String pw, String name, String phone) {
		int result = 0;
		String sql = "insert into tbl_member(member_id, "
				+ "                          password, "
				+ "                          member_name, "
				+ "                          phone) "
				+ "   values(?,"
				+ "          ?,"
				+ "          ?,"
				+ "          ?)";
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			
			result = pstmt.executeUpdate();
			pstmt.close();
			
			return result;
			
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn(conn);
		}
		
		return result;
	}
	
	//회원삭제 메소드 만들기
	public int memberDel(String id) {
		int rows = 0;
		String sql = "delete "
				+ "   from   tbl_member "
				+ "   where  member_id = ? ";
		
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rows = pstmt.executeUpdate();
			
			pstmt.close();
			return rows;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	

	
}
