package com.sphinx.beautea.category.web.controller.edit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.service.CategoryService;

@Controller
public class LoadSubListController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/admin/category/edit/choicesub")
	public String loadSubList(@RequestParam("categoryId") String s,
			HttpServletRequest request, Model model) {
		@SuppressWarnings("unchecked")
		List<Category> root_List = (List<Category>) request.getServletContext().getAttribute("rootcate");
		@SuppressWarnings("unchecked")
		Map<String, Category> AllCate = (Map<String, Category>)request.getServletContext().getAttribute("allcate");
		List<Category> AllList = new ArrayList<>();
		Map<String, List<Category>> parent_list = new HashMap<>();
		
		Category c = null;
		for (Category cate : root_List) {
			if (cate.getCategoryId().equals(s)) {
				c = cate;
			}
			
			AllList.add(cate);
			for (Category sub : cate.getSubCategory()) {
				AllList.add(sub);
				parent_list.put(sub.getCategoryId(), getParents(sub, AllCate));
			}
		}
		
		List<Category> row_list = c.getSubCategoryList(c);
		

		for (Category cate : row_list) {
			parent_list.put(cate.getCategoryId(), getParents(cate, AllCate));
		}
		
		model.addAttribute("subcate", row_list);
		model.addAttribute("parents", parent_list);
		model.addAttribute("all", AllList);
		
		return "admin/category/edit/sel_editcate";
	}
	
	public List<Category> getParents(Category cate, Map<String, Category> AllCate) {
		List<Category> parents = categoryService.getParentCategoryListById(cate.getCategoryId(), AllCate);
		return parents;
	}
}
