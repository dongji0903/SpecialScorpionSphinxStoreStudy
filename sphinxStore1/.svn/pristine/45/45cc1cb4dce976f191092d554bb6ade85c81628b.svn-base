package com.sphinx.beautea.order.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.order.domain.OrderItem;

@Controller
public class SuccessOrderController {

	@RequestMapping(value = "/order/successorder", method = RequestMethod.GET)
	public String Order(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String customerOrderId = (String)session.getAttribute("customerOrderId");
		String orderId = customerOrderId.substring(2, customerOrderId.length());
		
		List<OrderItem> orderItems = (List<OrderItem>)session.getAttribute("orderItems");
		double totalPrice = (double)session.getAttribute("totalPrice");
		
		request.setAttribute("orderId", orderId);
		session.removeAttribute("customerOrderId");
		request.setAttribute("orderItems", orderItems);
		session.removeAttribute("orderItems");
		request.setAttribute("totalPrice", totalPrice);
		session.removeAttribute("totalPrice");
		return "customer/order/success_order";
	}
}
