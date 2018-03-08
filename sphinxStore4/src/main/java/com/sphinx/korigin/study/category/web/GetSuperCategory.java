package com.sphinx.korigin.study.category.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetSuperCategory {

	/*TestSheetService ts = new TestSheetServiceImpl();
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		String cid = request.getParameter("selectId");

		Map<String, ShoppingCategory> categoryMap = (Map<String, ShoppingCategory>) request
				.getServletContext().getAttribute("categoryMap");
		
		List<ShoppingCategory> toBottomCategories = ts
				.getAllChildren(categoryMap.get(cid));
		List<ShoppingCategory> availableSupers = new ArrayList<>();
		ShoppingCategory presentSuper = categoryMap.get(cid).getParent() != null
				? categoryMap.get(categoryMap.get(cid).getParent())
				: null;
		for (ShoppingCategory c : categoryMap.values()) {
			if (!toBottomCategories.contains(c)) {
				availableSupers.add(c);
			}
		}
		request.setAttribute("presentSuper", presentSuper);
		request.setAttribute("availableCategories", availableSupers);

		return getNextPage();
	}*/

}
