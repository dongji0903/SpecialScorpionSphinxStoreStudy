package com.sphinx.korigin.study.shop.web.cart;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dug.controller.command.Command;
import com.dug.dao.shop.ItemDao;
import com.dug.dao.shop.impl.ItemDaoImpl;
import com.dug.domain.shop.Item;

public class AddCart extends Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		ItemDao iDao = ItemDaoImpl.getInstance();
		Cookie[] cookies = request.getCookies();
		
		String userId = (String) session.getAttribute("userId");
		String num = request.getParameter("num");
		String count = request.getParameter("count");
		String type1 = request.getParameter("type1");
		String type2 = request.getParameter("type2");

		Item ivo = iDao.selectItem(num);
		/* 아이디_cart_장바구니에 넣을 상품명 */
		String cartName = userId + "_cart_" + num;
		/* 중복 장바구니 물품 확인 */
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cartName)) {
				String name[] = cartName.split("-");
				if (name.length == 1) {
					cartName += "-1";
				} else {
					/* 확인시 이름에 추가기입 */
					int nextNum = Integer.parseInt(name[1]);
					nextNum++;
					String newCartName = name[0] + "-" + nextNum;
					cartName = newCartName;
				}
			}
		}
		/* 상품id(0), 상품이름(1), 상품가격(2), 상품수량(3), 상품옵션1(4), 상품옵션2(5) */
		String cartValue = num + "," + ivo.getName() + "," + ivo.getPrice()
				+ "," + count + "," + type1 + "," + type2;
		try {
			saveCookie(response, cartName,
					URLEncoder.encode(cartValue, "euc-kr"));
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.info("cartMake: " + cartName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return getNextPage();

	}

}
