package com.sphinx.korigin.member.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class GetPointLog {

	/*MemberDao mdao = MemberDaojdbcImpl.getInstance();
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		List<pointLog> log = mdao.getPointLog((String)session.getAttribute("userId"));
		System.out.println((String)session.getAttribute("userId"));
		request.setAttribute("pointLog", log);	

		return getNextPage();
	}
*/
}
