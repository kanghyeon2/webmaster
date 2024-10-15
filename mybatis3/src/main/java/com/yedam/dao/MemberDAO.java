package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.vo.Member;

public class MemberDAO extends DAO	{
	//회원목록.
	public List<Member> memberList(){
		List<Member>list = new ArrayList<>();
		getOpen();
		try {
			pstmt = conn.prepareStatement("select * from tbl_member");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		getClose();
		return list;
	}
}
