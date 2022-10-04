package com.deepblue.dab.member.model.service;

import java.util.ArrayList;

import com.deepblue.dab.member.model.vo.Member;

public interface MemberService {
	Member selectMember(String userid);
	int selectDupcheckId(String userid);
	int insertMember(Member member);
	int findPwd(Member member);
	Member selectByid(String userid);
	Member selectByMail(String email);
	int updateMember(Member member);
	int deleteMember(String userid);
	ArrayList<Member> selectList();
	int updateLoginOK(Member member);
}
