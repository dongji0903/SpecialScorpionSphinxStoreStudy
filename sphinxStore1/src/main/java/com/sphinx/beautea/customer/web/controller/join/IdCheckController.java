package com.sphinx.beautea.customer.web.controller.join;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sphinx.beautea.customer.service.CustomerService;

@Controller
public class IdCheckController {
	@Autowired
	CustomerService customerService;
	
	@ResponseBody
	@RequestMapping(value = "/join/idcheck", method = RequestMethod.POST)
	public boolean check(HttpServletRequest request) {
		String id = request.getParameter("id");
		boolean check = customerService.idcheck(id);
		return check;
	}
	
}


