package com.sphinx.korigin.study.shop.web.cart;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dug.controller.command.Command;
import com.dug.dao.shop.ItemDao;
import com.dug.dao.shop.impl.ItemDaoImpl;
import com.dug.domain.shop.Item;
import com.dug.vto.shop.Cart;

public class SetCartList extends Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		ItemDao id = ItemDaoImpl.getInstance();
		List<Cart> cartList = new ArrayList<Cart>();
		
		for (Cookie cookie : cookies) {
			String name[] = cookie.getName().split("_");
			/* 쿠키이름에서 사용자id를 검색 */
			for (int i = 0; i < name.length; i++) {
				/* 해당사용자의 cart인지 확인 */
				if (name[i].equals(session.getAttribute("userId"))) {
					String cart = null;
					try {
						cart = URLDecoder.decode(cookie.getValue(), "euc-kr");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
					/* 검색한 쿠키의 값을 가져옴 */
					String[] cartItem = cart.split(",");
					/* 상품id(0), 상품이름(1), 상품가격(2), 상품수량(3), 상품옵션1(4), 상품옵션2(5) */

					Item ivo = id.selectItem(cartItem[0]);
					Cart cvo = new Cart();
					cvo.setItemId(ivo.getNum());
					cvo.setCount(cartItem[3]);
					cvo.setCartName(cookie.getName());
					cartList.add(cvo);
				}
			}
		}
		System.out.println("cartList: " + cartList.size());
		request.setAttribute("cartList", cartList);
		return getNextPage();
	}
}
