package com.sphinx.korigin.study.shop.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dug.controller.command.Command;

public class RemoveKeyword extends Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();

		if(session.getAttribute("name") != null) {
			session.removeAttribute("name");			
		}
		
		return getNextPage();
	
	}
}