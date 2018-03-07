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
public class UpdateCategoryController {

	@Autowired
	private ShoppingCategoryService categoryService;
	
	/** 카테고리 추가를 처리하는 메소드 */
	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public String updateCategory(Model m, ShoppingCategory category, @RequestParam("updateCategoryName")String name) {
		category.setCategoryName(name);
		categoryService.updateCategory(category);
		m.addAttribute("msg", "변경완료");
		return "korigin/admin/category/updateCategory";	
	}
	
	@RequestMapping(value = "/updateCategory", method = RequestMethod.GET)
	public String updateCategory(Model m) {
		return "korigin/admin/category/updateCategory";	
	}
}
