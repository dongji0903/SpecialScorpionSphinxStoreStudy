package com.sphinx.korigin.shopping.category.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.korigin.shopping.category.domain.ShoppingCategory;
import com.sphinx.korigin.shopping.category.service.ShoppingCategoryService;

@Controller
@RequestMapping(value = "/admin/category")
public class FindCategoryController {

	@Autowired
	private ShoppingCategoryService categoryService;

	@RequestMapping(value = "/findCategory", method = RequestMethod.POST)
	public String findCategory(Model m,
			@RequestParam("searchValue") String type,
			@RequestParam("search") String value) {
		ShoppingCategory searchCategory = new ShoppingCategory();
		if (type.equals("name")) {
			searchCategory = categoryService.getCategoryByName(value);
		}
		if (type.equals("id")) {	
			searchCategory = categoryService.getCategoryById(value);
		}
		
		m.addAttribute("msg", "검색완료");
		m.addAttribute("searchCategory", searchCategory);
		return "korigin/admin/category/findCategory";
	}

	@RequestMapping(value = "/findCategory", method = RequestMethod.GET)
	public String findCategory(Model m) {
		return "korigin/admin/category/findCategory";
	}
}
