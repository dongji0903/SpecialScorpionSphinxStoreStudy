package com.sphinx.beautea.customer.web.controller.mypage.lookup;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.beautea.customer.domain.Customer;
import com.sphinx.beautea.order.domain.Order;
import com.sphinx.beautea.order.service.OrderService;

@Controller
public class LookupOrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/mypage/lookup", method=RequestMethod.GET) //주문 조회 페이지 첫방문시 최근 주문내역을 1페이지 분량 들고감
	public String LookupByCustomerId(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
		List<Order> order = orderService.getOrderListByCustomerId(1, customer.getCustomerId());
		if (order != null && !order.isEmpty()) {
			Collections.sort(order, new com.sphinx.beautea.common.domain.OrderComparator());
			model.addAttribute("orders", order);
		}
		model.addAttribute("date", new java.sql.Date(new java.util.Date().getTime()));
		return "customer/mypage/lookup/lookuporder";
	}
	
	@RequestMapping(value="/mypage/lookup/dateSearch", method=RequestMethod.POST) //원하는 날짜에 해당하는 주문 내역을 불러옴
	public String LookupByDate(HttpServletRequest request, Model model,
			@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
		List<Order> order = orderService.getOrderListByDate(customer.getCustomerId(), startDate, endDate, 1);
		
		if (order != null && !order.isEmpty()) {
			Collections.sort(order, new com.sphinx.beautea.common.domain.OrderComparator());
			model.addAttribute("orders", order);
		}

		model.addAttribute("date", new java.sql.Date(new java.util.Date().getTime()));
		
		return "customer/mypage/lookup/lookuporder";
	}
	
	@RequestMapping(value="/mypage/lookup/detailshow", method=RequestMethod.GET)
	public String DetailLookup(@RequestParam("orderId") String orderId, HttpServletRequest request) {
		return null;
	}
}
