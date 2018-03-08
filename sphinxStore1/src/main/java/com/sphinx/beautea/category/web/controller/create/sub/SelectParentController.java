package com.sphinx.beautea.category.web.controller.create.sub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.service.CategoryService;

@Controller
public class SelectParentController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/admin/category/addsub/selparent", method=RequestMethod.GET)
	public String MoveSelParentPage(@ModelAttribute Category category, HttpServletRequest request, Model model) {
		@SuppressWarnings("unchecked")
		List<Category> rootList = (List<Category>)request.getServletContext().getAttribute("rootcate");
		
		@SuppressWarnings("unchecked")
		Map<String, Category> AllCate = (Map<String, Category>)request.getServletContext().getAttribute("allcate");
		
		for (Category c : rootList) {
			if (c.getCategoryId().equals(category.getCategoryId())) {
					category = c;
					break;
			}
		}
		
		List<Category> row_list = new ArrayList<>();
		row_list.addAll(category.getSubCategoryList(category));
		
		Map<String, List<Category>> parent_list = new HashMap<>();
		for (Category c : row_list) {
			List<Category> parents = categoryService.getParentCategoryListById(c.getCategoryId(), AllCate);
			parent_list.put(c.getCategoryId(), parents);
		}
		
		model.addAttribute("parents", parent_list);
		model.addAttribute("subcate", row_list);		
		return "admin/category/add/subcategory/select_parent";
	}
}
