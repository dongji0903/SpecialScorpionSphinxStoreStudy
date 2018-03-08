package com.sphinx.beautea.customer.web.controller.mypage.info;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.customer.domain.Customer;
import com.sphinx.beautea.customer.service.CustomerService;

@Controller
public class WithdrowController {

	@RequestMapping(value = "/mypage/withdrow", method = RequestMethod.GET)
	public String withdrow() {
		
		return "customer/mypage/info/withdrow";
	}
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/mypage/withdrow", method = RequestMethod.POST)
	public String Successwithdrow(HttpSession session) {
		Customer customer = (Customer)session.getAttribute("customer");
		customer.setDel(true);
		customerService.updateCustomer(customer);
		session.removeAttribute("customer");
		
		return "redirect: /";
	}
}
