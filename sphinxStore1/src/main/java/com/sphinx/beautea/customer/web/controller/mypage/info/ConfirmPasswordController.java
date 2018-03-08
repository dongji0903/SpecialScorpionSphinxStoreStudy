package com.sphinx.beautea.customer.web.controller.mypage.info;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.beautea.customer.domain.Customer;

@Controller
public class ConfirmPasswordController {

	@RequestMapping(value = "/mypage/confirmpassword", method = RequestMethod.GET)
	public String confirmPassword(HttpSession session) {
		
		if(session.getAttribute("customer") == null) {
			return "redirect: /";
		}
		
		return "customer/mypage/info/confirm_password";
	}

	@RequestMapping(value = "/mypage/confirmpassword", method = RequestMethod.POST)
	public String password(HttpSession session, @RequestParam("password") String password) {
		
		//비번 확인
		Customer customer = (Customer)session.getAttribute("customer");
		
		if(password == null || !password.equals(customer.getPassword())) {
			return "customer/mypage/info/confirm_password";
		}
		
		return "redirect: /mypage/editinfo";
	}
	
}
