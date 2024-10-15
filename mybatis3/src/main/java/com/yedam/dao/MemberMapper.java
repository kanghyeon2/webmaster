package com.yedam.dao;

import java.util.List;

import com.yedam.vo.Member;

//interface 기능정의
//구현클래스 기능 실행
public interface MemberMapper {
	public List<Member> members();
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(Member member);

}
