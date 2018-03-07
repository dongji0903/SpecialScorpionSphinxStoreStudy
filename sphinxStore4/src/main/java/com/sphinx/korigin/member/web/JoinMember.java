package com.sphinx.korigin.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JoinMember {
	/*MemberDao md = MemberDaojdbcImpl.getInstance();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		Member user = new Member(request.getParameter("userId"));
		String user_Email = request.getParameter("userEmail");
		String user_Phone = request.getParameter("userPhoneNum0")
				+ request.getParameter("userPhoneNum1")
				+ request.getParameter("userPhoneNum2");
		String[] user_hobbies = request.getParameterValues("userHobby");
		if(user_hobbies!=null) {
			int count = user_hobbies.length - 1;
			user_hobbies[count] = request.getParameter("userOtherHobby");
			String hobbies = "";
			for (String hobby : user_hobbies) {
				hobbies += (hobby + "/");
			}
			
			user.setHobbies(hobbies);
		}
		user.setPassword(request.getParameter("userPass"));
		user.setNickName(request.getParameter("nickName"));
		user.setName(request.getParameter("userName"));
		user.setBirth(request.getParameter("userBirth"));
		user.setAddress(request.getParameter("userAddr"));
		user.setEmail(user_Email);
		user.setPhonenumber(user_Phone);


		md.joinMember(user);

		return getNextPage();
	}*/

}
