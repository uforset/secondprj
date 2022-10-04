package com.deepblue.dab.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepblue.dab.member.model.dao.MemberDao;
import com.deepblue.dab.member.model.vo.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member selectMember(String userid) {
		return memberDao.selectMember(userid);
	}

	@Override
	public int selectDupcheckId(String userid) {
		return memberDao.selectDupCheckId(userid);
	}

	@Override
	public int insertMember(Member member) {
		return memberDao.insertMember(member);
	}

	@Override
	public int findPwd(Member member) {
		return memberDao.findPwd(member);
	}

	@Override
	public int updateMember(Member member) {
		return memberDao.updateMember(member);
	}

	@Override
	public int deleteMember(String userid) {
		return memberDao.deleteMember(userid);
	}

	@Override
	public Member selectByid(String userid) {
		// TODO Auto-generated method stub
		return memberDao.selectByid(userid);
	}

	@Override
	public Member selectByMail(String email) {
		// TODO Auto-generated method stub
		return memberDao.selectByMail(email);
	}

	@Override
	public ArrayList<Member> selectList() {
		return memberDao.selectList();
	}

	@Override
	public int updateLoginOK(Member member) {
		return memberDao.updateLoginOK(member);
	}
	
}
