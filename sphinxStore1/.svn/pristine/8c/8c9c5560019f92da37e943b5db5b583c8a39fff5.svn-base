package com.sphinx.beautea.customer.web.controller.mypage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.service.CategoryService;
import com.sphinx.beautea.customer.domain.Customer;

@Controller
public class MyPageIndexController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypageIndex(HttpSession session, HttpServletRequest request) {
		Customer customer = (Customer)session.getAttribute("customer");
		String[] images = {"bronze", "silver", "gold", "diamond", "vip"};
		if(customer == null) {
			return "redirect: /";
		}
		
		@SuppressWarnings("unchecked")
		Map<String, Category> AllCate = (Map<String, Category>)request.getServletContext().getAttribute("allcate");
	
		List<Category> boardCategory = new ArrayList<>();
		for(String key : AllCate.keySet()) {
			Category category = AllCate.get(key);
			if(category.getType() == 1) {
				boardCategory.add(category);
			}
		}
		List<Category> boardcateList = new ArrayList<>();
		for(Category cate : boardCategory) {
			List<Category> parents = new ArrayList<>();
			if(cate.getParentId() == "0") {
				parents.add(cate);
			}
			for(Category p : parents) {
				if(cate.getParentId() == p.getCategoryId()) {
					boardcateList.add(cate);
				}
			}
		}
		
		boardCategory.clear();
		if (request.getServletContext().getAttribute("boardcateList") == null) {
			request.getServletContext().setAttribute("boardcateList", boardcateList);
		}

		request.setAttribute("icon", images[customer.getLevel() - 1]);
		
		return "customer/mypage/mypage_index";
	}
}
