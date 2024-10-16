package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;

// 업무처리로직
public interface MemberService {
	boolean addMember(MemberVO member);
	boolean retireMember(String memberId);
	
	//회원 목록
	List<MemberVO>memberList();
}
