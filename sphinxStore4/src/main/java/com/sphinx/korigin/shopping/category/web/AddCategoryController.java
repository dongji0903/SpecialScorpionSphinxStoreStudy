package com.sphinx.korigin.shopping.category.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.sphinx.korigin.shopping.category.domain.ShoppingCategory;
import com.sphinx.korigin.shopping.category.service.ShoppingCategoryService;

@Controller
@RequestMapping(value = "/admin/category")
public class AddCategoryController {
	
	@Autowired
	private ShoppingCategoryService categoryService;
	
	/** 카테고리 추가를 처리하는 메소드 */
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String addCategory(Model m, ShoppingCategory category) {
		System.out.println(category);
		categoryService.addCategory(category);
		m.addAttribute("생성완료", "msg");
		return "korigin/admin/category/addCategory";	
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public String addCategory(Model m) {
		return "korigin/admin/category/addCategory";	
	}
	
}
