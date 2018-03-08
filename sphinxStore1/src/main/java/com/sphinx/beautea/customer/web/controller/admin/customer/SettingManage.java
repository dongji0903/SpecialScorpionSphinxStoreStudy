package com.sphinx.beautea.customer.web.controller.admin.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.beautea.customer.domain.Customer;
import com.sphinx.beautea.customer.service.CustomerService;

@Controller
public class SettingManage {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/admin/customer/settngadmin", method=RequestMethod.POST)
	public String setAdmin(@RequestParam("customerId") String[] customerIds) {
		for (String s : customerIds) {
			Customer customer = customerService.getCustomerById(s);
			customer.setAdmin(true);
			customerService.updateCustomer(customer);
		}
		return "redirect:/admin/customer/customer";
	}
}
