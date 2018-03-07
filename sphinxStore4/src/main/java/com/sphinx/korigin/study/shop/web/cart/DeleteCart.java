package com.sphinx.korigin.study.shop.web.cart;

import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dug.controller.command.Command;

public class DeleteCart extends Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String cartName = request.getParameter("cartName");
		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cartName)) {
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
				Logger logger = Logger.getLogger(this.getClass().getName());
				logger.info("cartDelete: " + cartName);
			}
		}
		return getNextPage();
	}
}
