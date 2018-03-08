package com.sphinx.korigin.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.korigin.member.domain.Member;
import com.sphinx.korigin.member.service.MemberService;

@Controller
public class AddCustomerController {

	@Autowired
	private MemberService customerService;

	/** 회원가입을 처리하는 메소드 */
	@RequestMapping(value = "/customer/addCustomer", method = RequestMethod.POST)
	public String addCustomer(Model m, Member customer) {
		if(customerService.checkId(customer.getSphixId()) == 0) {
			String id = customerService.addCustomer(customer);
			m.addAttribute("userId", id);
			return "korigin/customer/membership/welcome";
		} else {
			m.addAttribute("type", "sign");
			m.addAttribute("msg", "이미 가입된 아이디입니다.");
			return "korigin/customer/membership/login";
		}
	}
	/* url주소 바꿔야햠 */

}
