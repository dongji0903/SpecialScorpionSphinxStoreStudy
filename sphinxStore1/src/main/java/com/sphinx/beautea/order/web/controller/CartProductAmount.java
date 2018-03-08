package com.sphinx.beautea.order.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.beautea.order.domain.Cart;
import com.sphinx.beautea.order.domain.OrderItem;

@Controller
public class CartProductAmount {
	@RequestMapping(value="/shopping/cart/product/editquantity", method=RequestMethod.POST)
	public String changeQuantity(@RequestParam("orderItemId") String id, 
			@RequestParam("quantity") int quantity, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		
		session.removeAttribute("cart");
		
		OrderItem orderItem = cart.getOrderItemMap().get(id);
		orderItem.setQuantity(quantity);
		cart.updateOrderItem(orderItem);

		session.setAttribute("cart", cart);
		
		return "redirect:/cart";
	}
}
