package com.sphinx.beautea.category.web.controller.create.sub;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.service.CategoryService;

@Controller
public class CreateSubCategory {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/admin/category/addsub", method=RequestMethod.GET)
	public String movePageByCreateSubCate(Model model, HttpServletRequest request) {
		List<Category> root_list = categoryService.getRootCategoryList();//최상위 카테고리 리스트
		Map<String, Category> AllCate = categoryService.getAllCategoryList();
		
		if (request.getServletContext().getAttribute("rootcate") == null) {
			request.getServletContext().setAttribute("rootcate", root_list);
		}
		
		if (request.getServletContext().getAttribute("allcate") == null) {
			request.getServletContext().setAttribute("allcate", AllCate);
		}
		
		return "admin/category/add/subcategory/add_subcategory";
	}

}
