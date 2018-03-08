package com.sphinx.beautea.customer.web.controller.mypage.info;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.beautea.customer.domain.Customer;
import com.sphinx.beautea.customer.service.CustomerService;

@Controller
public class AddAddressController {

	@RequestMapping(value = "/mypage/address", method = RequestMethod.GET)
	public String addAddress(HttpSession session, Model model) {
		if(session.getAttribute("customer") == null) {
			return "redirect: /";
		}
		Customer customer = (Customer)session.getAttribute("customer");
		if(!customer.getAddress().equals("address") && !customer.getPost().equals("post")) {
			String[] address = customer.getAddress().split("/");
			model.addAttribute("address1", address[0]);
			model.addAttribute("address2", address[1]);
			model.addAttribute("post", customer.getPost());
		}
		
		return "customer/mypage/info/add_address";
	}
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/mypage/address", method = RequestMethod.POST)
	public String SuccessAddAddress(HttpSession session, @RequestParam("post") String post, 
			@RequestParam("area1") String address1, @RequestParam("area2") String address2) {
		Customer customer = (Customer)session.getAttribute("customer");
		
		if(post.isEmpty() || address1.isEmpty()) {
			return "redirect: /mypage/address";
		}
		
		String address = address1 + "/" + address2;
		customer.setAddress(address);
		customer.setPost(post);
		customerService.updateCustomer(customer);
		return "redirect: /mypage/address";
	}
	
}
