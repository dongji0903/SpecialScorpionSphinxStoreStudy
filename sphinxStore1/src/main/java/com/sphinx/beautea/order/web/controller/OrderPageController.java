package com.sphinx.beautea.order.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.order.domain.Cart;
import com.sphinx.beautea.order.service.OrderService;

@Controller
public class OrderPageController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			Cart cart = (Cart)session.getAttribute("cart");
			
			List<String> orderItemList = new ArrayList<>();
			double price = 0;
			
			if(request.getParameter("orderItems") == null || request.getParameter("orderItems").length() < 1) {
				for(String key : cart.getOrderItemMap().keySet()) {
					orderItemList.add(key);
					price += cart.getOrderItemMap().get(key).getPrice();
				}
				
			} else {
				String orderItems = request.getParameter("orderItems");
				for(String o : orderItems.split("/")) {
					orderItemList.add(o);
					price += cart.getOrderItemMap().get(o).getPrice();
				}
			}
			
			request.setAttribute("price", price);
			session.setAttribute("orderItemList", orderItemList);
		} catch (NullPointerException e) {
			String error = "잘못된 접근입니다.";
			request.setAttribute("error", error);
			return "error_page";
		}
		return "customer/order/order_form";
	}
}
