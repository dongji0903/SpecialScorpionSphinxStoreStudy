package com.sphinx.korigin.study.shop.web.item;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dug.controller.command.Command;
import com.dug.dao.shop.ItemDao;
import com.dug.dao.shop.impl.ItemDaoImpl;
import com.dug.domain.shop.Item;
import com.dug.vto.shop.Cart;

public class GetCartItems extends Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		List<Cart> cartList = (List<Cart>) request.getAttribute("cartList");
		List<Item> itemList = new ArrayList<>();
		ItemDao idao = ItemDaoImpl.getInstance();
		
		
		for(Cart cart : cartList) {
			itemList.add(idao.selectItem(cart.getItemId()));
		}
		System.out.println("itemList: " + itemList.size());
		request.setAttribute("itemList", itemList);
		
		return getNextPage();
	}

}
