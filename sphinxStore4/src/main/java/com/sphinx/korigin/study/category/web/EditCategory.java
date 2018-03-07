package com.sphinx.korigin.study.category.web;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditCategory {
	
	/*CategoryService cs = new CategoryServiceImpl();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		String cid = request.getParameter("cid");
		String parentCid = request.getParameter("parentIds");
		String title = request.getParameter("title");
		System.out.println(
				"cid:" + cid + "parentCid:" + parentCid + "title:" + title);
		ServletContext app = request.getServletContext();
		Map<String, ShoppingCategory> categoryMap = (Map<String, ShoppingCategory>) app
				.getAttribute("categoryMap");
		ShoppingCategory c = categoryMap.get(cid);
		c.setParent(parentCid);
		c.setTitle(title);
		cs.modifyCategory(c);
		categoryMap.replace(cid, c);
		app.setAttribute("categoryMap", categoryMap);
		
		return getNextPage();
	}
*/
}
