package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.MemberVO;

//interface 기능정의
//구현클래스 기능 실행
public interface MemberMapper {
	
	public List<MemberVO> members();
	public int insertMember(MemberVO member);
	public int updateMember(MemberVO member);
	public int deleteMember(String memberid);
	public MemberVO selectMember(String memberId); //단건조회
}
