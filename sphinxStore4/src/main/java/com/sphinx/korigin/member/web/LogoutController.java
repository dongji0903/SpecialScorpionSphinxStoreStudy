package com.sphinx.korigin.member.web;


import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LogoutController {
	@RequestMapping(value="/member/logout",method=RequestMethod.GET)
	public String logout(SessionStatus status,WebRequest request) {
		status.setComplete();
		request.removeAttribute("userId", WebRequest.SCOPE_SESSION);
		request.removeAttribute("userName", WebRequest.SCOPE_SESSION);
		return "redirect:/";
	}
	/*@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Enumeration<String> attNames= session.getAttributeNames();
		while(attNames.hasMoreElements()) {
			String attName=attNames.nextElement();
			System.out.println(attName);
			session.removeAttribute(attName);
		}
		session.invalidate();
		return getNextPage();
	}
*/
}
