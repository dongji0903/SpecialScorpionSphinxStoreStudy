package com.sphinx.korigin.study.shop.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dug.controller.command.Command;

public class SetKeyword extends Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		String name = (String) session.getAttribute("name"); // 검색어

		if (name == null || (!name.equals(request.getParameter("search"))
				&& request.getParameter("search") != null)) {
			/*
			 * 세션에 검색어가 없거나 새로운 검색어를 입력시 검색후 text창의 입력값은 사라지기 때문에 null값이 아니라는 조건
			 * 추가
			 */
			session.setAttribute("name", request.getParameter("search"));
			/*
			 * 페이지를 넘기는 과정에서 파라미터값에 의해 기존값이 null이 되지 않기 위하여 if문을 사용하여 세션에 검색어가
			 * 없을때만 파라미터값을 세션에 저장
			 */
		}

		return getNextPage();
	}

}
