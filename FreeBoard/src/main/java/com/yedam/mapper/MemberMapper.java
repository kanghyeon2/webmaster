package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

//interface 기능정의
//구현클래스 기능 실행
public interface MemberMapper {
	
	public List<MemberVO> members();
	public int insertMember(MemberVO member);
	public int updateMember(MemberVO member);
	public int deleteMember(String memberid);
	public MemberVO selectMember(String memberId); //단건조회
	
	//아이디와 비번 조회
	public MemberVO loginMember(@Param("id") String id, @Param("pwd") String pwd);
}
