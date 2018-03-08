package com.sphinx.beautea.customer.web.controller.mypage.info;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sphinx.beautea.customer.domain.Customer;
import com.sphinx.beautea.customer.service.CustomerService;

@Controller
public class EditMyInfoController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/mypage/editinfo", method = RequestMethod.GET)
	public String editMyInfo(@RequestParam(value="lang", required=false) String lang, 
			Model model, HttpSession session) {
		
		if(session.getAttribute("customer") == null) {
			return "redirect: /";
		}
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String Ccode = (String)req.getServletContext().getAttribute("countrycode");
		Map<String, String> codelist = new HashMap<>();
		String code = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(Ccode)));
			while ((code = br.readLine()) != null) {
				String[] s = code.split(":");
				codelist.put(s[0], s[1]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date(new java.util.Date().getTime());
		
		List<String> keys = new ArrayList<>(codelist.keySet());
		Collections.sort(keys);
		
		
		model.addAttribute("nowDate", date);
		model.addAttribute("codelist", codelist);
		model.addAttribute("keys", keys);
		return "customer/mypage/info/edit_info";
	}
	
	
	@RequestMapping(value = "/mypage/editinfo", method = RequestMethod.POST)
	public String editMyInfoComplete(HttpServletRequest request, 
			HttpServletResponse response, HttpSession session, Model model) {
		
		Customer customer = (Customer)session.getAttribute("customer");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		if(!password.isEmpty() || !password2.isEmpty()) {
			if(!password.equals(password2) || password.length() < 8) {
				return "redirect:/mypage/editinfo";
			}
		}
			
		if(password.isEmpty() && password2.isEmpty()) {
			password = customer.getPassword();
			password2 = "";
		}
		
		String name = request.getParameter("name");
		String phoneNum = request.getParameter("phoneNum");
		String birthDayStr = request.getParameter("birthDay");
		Date birthDay = Date.valueOf(birthDayStr);
		
		customer.setPassword(password);
		customer.setName(name);
		customer.setPhoneNum(phoneNum);
		customer.setBirthday(birthDay);
			
		customerService.updateCustomer(customer);
	
		return "redirect:/mypage/editinfo";
	}
	
}
