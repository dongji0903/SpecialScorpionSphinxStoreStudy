package com.sphinx.beautea.category.web.controller.create.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.service.CategoryService;

@Controller
@RequestMapping("/admin/category/sucaddmain")
public class CreateSucCategory {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String NotFound() {
		return "redirect:/admin/category/create";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String SucCreate(@ModelAttribute Category cate) {
		cate.setParentId("0");
		categoryService.addCategory(cate);
		return "redirect:/admin/category/addmain";
	}
}
