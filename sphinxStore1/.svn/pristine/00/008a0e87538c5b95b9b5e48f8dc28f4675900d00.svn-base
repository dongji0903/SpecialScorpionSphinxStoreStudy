package com.sphinx.beautea.category.web.controller.edit;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.service.CategoryService;

@Controller
public class EditSucCategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/admin/category/sucedit", method=RequestMethod.POST)
	public String editCate(@ModelAttribute Category cate, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		Map<String, Category> AllCate = (Map<String, Category>)request.getServletContext().getAttribute("allcate");
		Category category = AllCate.get(cate.getCategoryId());
		
		if (!cate.getParentId().equals("999") && !category.getParentId().equals(cate.getParentId())) {
			category.setParentId(cate.getParentId());
		}
		if (cate.getType() != 999) {
			category.setType(cate.getType());
		}
		if (cate.getCategoryName() != null && cate.getCategoryName().length() > 1) {
			category.setCategoryName(cate.getCategoryName());
		}
		
		categoryService.updateCategory(category);
		
		request.getServletContext().removeAttribute("rootcate");
		request.getServletContext().removeAttribute("allcate");
		
		return "redirect:/admin/category/edit";
	}
}
