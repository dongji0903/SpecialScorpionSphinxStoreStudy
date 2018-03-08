package com.sphinx.beautea.customer.web.controller.admin.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.common.domain.PageUtil;
import com.sphinx.beautea.customer.domain.Customer;
import com.sphinx.beautea.customer.service.CustomerService;

@Controller
public class ManageCustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/admin/customer/customer", method = RequestMethod.GET)
	public String manageCustomer(HttpServletRequest request, HttpSession session) {
		int page = 1;
		try {
			String pageStr = (String)session.getAttribute("page");
			page = Integer.parseInt(pageStr);
			request.setAttribute("page", page);
			session.removeAttribute("page");
		} catch(NumberFormatException e) {
			page = 1;
			request.setAttribute("page", page);
		}
		int count = customerService.countCustomer(false);
		
		PageUtil pageUtil = new PageUtil();
		List<Integer> pageList = pageUtil.getPages(count, page);
		
		List<Customer> customers = customerService.getAllCustomerList(page);
		
		request.setAttribute("maxPage", pageUtil.getMaxPage(count));
		request.setAttribute("customers", customers);
		request.setAttribute("pageList", pageList);
		return "admin/customer/member/customerlist";
	}
	
}
