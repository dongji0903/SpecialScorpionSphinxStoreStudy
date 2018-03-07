package com.sphinx.korigin.member.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAllMember {
	
	/*private MemberManageService ms=new MemberManagerServiceImpl();
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		List<Member> memberList= ms.findAllMembers();
		List<BriefMemberInfo> briefList=new ArrayList<>();
		for(Member m:memberList) {
			BriefMemberInfo bm=new BriefMemberInfo();
			bm.setId(m.getId());
			bm.setName(m.getName());
			bm.setMemberType(m.getMemberType());
			briefList.add(bm);
		}
		request.setAttribute("memberList", briefList);

		return getNextPage();
	}
*/
}
