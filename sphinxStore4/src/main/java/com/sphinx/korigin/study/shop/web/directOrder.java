package com.sphinx.korigin.study.shop.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dug.controller.command.Command;
import com.dug.vto.shop.Cart;

public class directOrder extends Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String num = null;
		String count = null;
		String type1 = null;
		String type2 = null;

		if (request.getParameter("num") != ""
				&& request.getParameter("num") != null) {
			num = request.getParameter("num");
		}
		if (request.getParameter("count") != ""
				&& request.getParameter("count") != null) {
			count = request.getParameter("count");
		}
		if (request.getParameter("type1") != ""
				&& request.getParameter("type1") != null) {
			type1 = request.getParameter("type1");
		}
		if (request.getParameter("type2") != ""
				&& request.getParameter("type2") != null) {
			type2 = request.getParameter("type2");
		}
		
		List<Cart> cartList = new ArrayList<>();
		Cart cart = new Cart();
		if (num != null && count != null && type1 != null && type2 != null) {
			cart.setItemId(num);
			cart.setCount(count);
			cartList.add(cart);
		}

		request.setAttribute("cartList", cartList);
		/*
		 * request.setAttribute("type1", type1); request.setAttribute("type2",
		 * type2);
		 */

		return getNextPage();
	}

}
