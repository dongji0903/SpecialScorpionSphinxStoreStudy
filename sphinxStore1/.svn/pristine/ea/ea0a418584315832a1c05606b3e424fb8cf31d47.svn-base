package com.sphinx.beautea.customer.web.controller.join;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.customer.domain.Customer;
import com.sphinx.beautea.customer.service.CustomerService;
import com.sphinx.beautea.customer.web.command.JoinCommand;

@Controller
public class JoinController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinformByPost(@ModelAttribute JoinCommand join, Model model) {
		String id = join.getId();
		String password = join.getPassword();
		String password2 = join.getPassword2();
		String name = join.getName();
		String phoneNum = join.getPhoneNum();
		Date birthday = null;
		String email = join.getEmail();
		try {
			birthday = join.getBirthDay();
		} catch(IllegalArgumentException e) {
			return "redirect:/join";
		}
		
		if(!password.equals(password2)) {
			return "redirect:/join";
		}
		if(errorCheck(id) || errorCheck(password) || errorCheck(name) || errorCheck(phoneNum)) {
			return "redirect:/join";
		} 
		
		Customer customer = new Customer();
		customer.setSphinxId(id);
		customer.setPassword(password);
		customer.setName(name);
		customer.setPhoneNum(phoneNum);
		customer.setBirthday(birthday);
		customer.setEmail(email);
		customer.setAddress("address");
		customer.setPost("post");
		customerService.addCustomer(customer);
		
		return "redirect:/customer/successjoin";
	}
	
	public boolean errorCheck(String a) {
		if(a == null || a.length() < 1) {
			return true;
		} else {
			return false;
		}
	}
}
