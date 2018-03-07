package com.sphinx.korigin.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class GetMember {
	
	/*MemberDao md = MemberDaojdbcImpl.getInstance();
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("userId"); 
		Member m = md.findMember(id);
		
		request.setAttribute("member", m);
		
		return getNextPage();
	}
*/
}
