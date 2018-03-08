package com.sphinx.beautea.customer.web.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.beautea.customer.domain.Customer;
import com.sphinx.beautea.customer.service.CustomerService;
import com.sphinx.beautea.order.service.OrderService;

@Controller
@RequestMapping(value = "/login")

public class LoginController {
	@Autowired
	CustomerService customerService;
	@Autowired
	OrderService orderService;
	
	static int saramincounting;
	
	@RequestMapping(method = RequestMethod.GET)
	public String ChkLoginByGet(HttpServletRequest request) {
			HttpSession session = request.getSession();
			String referrer = request.getHeader("Referer"); //로그인 이전페이지 url을 받아옴
			if (session.getAttribute("uri") == null) { // 기록된 url이 없다면 새로운 기록을 시작함
				session.setAttribute("uri", referrer); // session에 이전 url을 올려둠
			}
			return "customer/login/login_form";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String ChkLoginByPost(
			@RequestParam("id") String id,
			@RequestParam("password") String password, 
			Model model, HttpSession session, HttpServletRequest request) {

		if(isString(id, password) == false) {
			String error = "아이디 또는 비밀번호를 정확히 입력해 주세요.";
			model.addAttribute("error", error);
			return "customer/login/login_form";
		}
		
		Customer customer = customerService.getCustomerBySphinxId(id);
		
		if (customer.getSphinxId().equalsIgnoreCase("saramin")) {
			saramincounting++;
			System.out.println("사람인 채용자 로그인, 현재까지 채용자 로그인 횟수 : "+ saramincounting +"회");
		}
		
		session.setAttribute("customer", customer);
		session.setAttribute("totalPurchase", orderService.sumTotalPricePurchased(customer.getCustomerId()));
		
		String uri = (String)session.getAttribute("uri"); //로그인페이지에서 session에 올려둔 이전페이지 url을 가지고옴
		uri = uri.replaceAll("http://", ""); //http://제외
		uri = uri.substring(uri.indexOf("/"), uri.length()); //주소를 제외 후 그 뒤 링크로 이동
		
		String[] defaults = {"join", "customer/successjoin", "order", "order/successorder"}; //뒤로가기에서 제외될 uri
		
		for (String s : defaults) {
			if (uri.equalsIgnoreCase("/"+s)) {
				uri = "/";
			}
		}
		
		session.removeAttribute("uri");
		return "redirect:"+ uri;
	}
	
	
	public Boolean isString(String id, String password) {
		Customer customer = null;
		try {
			customer = customerService.getCustomerBySphinxId(id);
		} catch(EmptyResultDataAccessException e) {
			return false;
		}
		
		if (password.equals(customer.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
	
}
