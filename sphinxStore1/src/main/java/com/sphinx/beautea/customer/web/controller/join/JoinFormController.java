package com.sphinx.beautea.customer.web.controller.join;

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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



@Controller
public class JoinFormController {

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinformByGet(@RequestParam(value="lang", required=false) String lang, 
			Model model) {
		
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
		return "customer/join/join_form";
	}
	
	@ModelAttribute("email")
	public List<String> listTest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		String EmailPath = (String)request.getServletContext().getAttribute("emailtxt");
		List<String> emailList = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(EmailPath)));
			String mail = null;
			
				while ((mail = reader.readLine()) != null) {
					emailList.add(mail);
				}
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emailList;
	}
}
