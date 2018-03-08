package com.sphinx.beautea.customer.web.controller.admin.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.common.domain.PageUtil;
import com.sphinx.beautea.customer.domain.Customer;
import com.sphinx.beautea.customer.service.CustomerService;

@Controller
public class ManageAdminController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/admin/customer/admin", method = RequestMethod.GET)
	public String manageAdmin(@ModelAttribute("command") Customer customer, 
			HttpServletRequest request, HttpSession session) {
		int page;
		try {
			String pageStr = (String)session.getAttribute("page");
			page = Integer.parseInt(pageStr);
			request.setAttribute("page", page);
			session.removeAttribute("page");
		} catch(NumberFormatException e) {
			page = 1;
			request.setAttribute("page", page);
		}
		int count = customerService.countAdmin();
		
		PageUtil pageUtil = new PageUtil();
		List<Integer> pageList = pageUtil.getPages(count, page);
		
		List<Customer> admins = customerService.getAdmin(page);
		
		request.setAttribute("maxList", pageUtil.getMaxPage(count));
		request.setAttribute("pageList", pageList);
		request.setAttribute("admins", admins);
		return "admin/customer/admin/adminlist";
	}
	
}
