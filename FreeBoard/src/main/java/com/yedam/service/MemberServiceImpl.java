package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

// mysql(insertMember, updateMember)
//-> oracle (memb
public class MemberServiceImpl implements MemberService{
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	
	@Override
	public boolean addMember(MemberVO member) {
		return mapper.insertMember(member)==1 ;
	}

	@Override
	public boolean retireMember(String memberId) {
		return mapper.deleteMember(memberId)==1;
	}
	
	@Override
	public List<MemberVO> memberList() {
		return mapper.members();
	}
	
	//로그인
	@Override
	public MemberVO loginCheck(String id, String pwd) {
		// TODO Auto-generated method stub
		return mapper.loginMember(id, pwd);
	}
}
