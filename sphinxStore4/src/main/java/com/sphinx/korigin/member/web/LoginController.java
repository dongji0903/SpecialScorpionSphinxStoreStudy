package com.sphinx.korigin.member.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginController {
	/*MemberDao md = MemberDaojdbcImpl.getInstance();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String input_password = request.getParameter("userPassword");
		String input_id = request.getParameter("userId");
		String idSave = request.getParameter("idSave");
		int result = 100;
		Member m = md.findMember(input_id);
		String name = "";
		String nickName = "";
		String email = "";
		int isAdmin = 0;
		HttpSession session = request.getSession();

		if (m == null) { // result 1: 통과 0:아이디가없음 -1:비밀번호불일치
			result = 0;
		} else {
			String pass = m.getPassword();
			if (!pass.equals(input_password)) {
				result = -1;
			} else {
				result = 1;
				name = m.getName();
				if (idSave != null) {
					saveCookie(response, "id", input_id);
				}else {
					removeCookie(request, response, "id");
				}
				if (m.getMemberType() != null
						&& m.getMemberType().equalsIgnoreCase("admin")) {
					isAdmin = 1;
				}
				nickName = m.getNickName();
				email = m.getEmail();
			}
			session.setAttribute("userId", input_id);
			session.setAttribute("userName", name);
			session.setAttribute("nickName", nickName);
			session.setAttribute("email", email);
			session.setAttribute("isAdmin", isAdmin);
		}
		request.setAttribute("result", result);
		return getNextPage();
	}*/

}
