package com.sphinx.korigin.member.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.korigin.member.dao.MemberDaoImpl;
import com.sphinx.korigin.member.domain.Member;

/*LoginCustomerController의 Autowired와 세트*/
@Service("MemberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDaoImpl memberDao;

	@Override
	public Member login(String id, String pwd) {
		return memberDao.selectMember(id,pwd);
	}

	@Override
	public String addCustomer(Member customer) {
		customer.setJoinDate(new Date());
		memberDao.insertMember(customer);
		return customer.getSphixId();
	}

	@Override
	public int checkId(String id) {
		return memberDao.countByMemberId(id);
	}
}
