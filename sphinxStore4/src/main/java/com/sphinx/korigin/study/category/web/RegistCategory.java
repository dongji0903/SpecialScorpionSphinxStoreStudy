package com.sphinx.korigin.study.category.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistCategory {
	/*
	CategoryService cs = new CategoryServiceImpl();
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String parentCid = request.getParameter("parentIds");
		String title = request.getParameter("title");
		ShoppingCategory c = new ShoppingCategory(title);
		c.setParent(parentCid);
		Map<String, ShoppingCategory> categoryMap = (Map<String, ShoppingCategory>) request
				.getServletContext().getAttribute("categoryMap");
		String cid = cs.createCategory(c);
		c.setCid(cid);
		categoryMap.put(cid, c);
		
		if(parentCid!=null) {
		categoryMap.get(parentCid).addChild(cid);
		}
		request.getServletContext().setAttribute("categoryMap", categoryMap);
		
		return getNextPage();
	}*/

}
