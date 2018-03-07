package com.sphinx.korigin.member.service;

import com.sphinx.korigin.member.domain.Member;

public interface MemberService {
	public Member login(String id, String pwd);

	public String addCustomer(Member customer);
	
	public int checkId(String id);
}
