package com.sphinx.beautea.customer.web.controller.admin.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManageCustomerPageController {
	@RequestMapping(value = "/admin/customer/customerpage", method = RequestMethod.GET)
	public String adminPage(HttpSession session, HttpServletRequest request) {
		
		String page = request.getParameter("page");
		session.setAttribute("page", page);
		
		return "redirect:/admin/customer/customer";
	}
}
