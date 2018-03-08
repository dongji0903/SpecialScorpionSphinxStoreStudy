package com.sphinx.beautea.customer.web.controller.join;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class ShowPrivacyController {

	@RequestMapping(value = "/join/privacy", method = RequestMethod.GET)
	public String privacy(HttpServletRequest request) {
		request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String Ccode = (String)request.getServletContext().getAttribute("useability");
		String Ccode2 = (String)request.getServletContext().getAttribute("agreePrivacy");
		List<String> useability = new ArrayList<>();
		List<String> agreePrivacy = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(Ccode)));
			BufferedReader br2 = new BufferedReader(new FileReader(new File(Ccode2)));
			while (br.readLine() != null) {
				useability.add(br.readLine());
			}
			while (br2.readLine() != null) {
				agreePrivacy.add(br2.readLine());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("useability", useability);
		request.setAttribute("agreePrivacy", agreePrivacy);
		
		return "customer/join/privacypolicy";
	}
}
