package com.sphinx.beautea.category.web.controller.delete;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.service.CategoryService;

@Controller
public class DeleteCategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/admin/category/delete/choicesub", method = RequestMethod.GET)
	public String deleteCategory(@RequestParam("categoryId") String s,
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
		
		model.addAttribute("id", s);
		model.addAttribute("subcate", row_list);
		model.addAttribute("parents", parent_list);
		model.addAttribute("all", AllList);
		
		return "admin/category/delete/delete_category";
	}
	
	
	@RequestMapping(value = "/admin/category/delete/choicesub", method = RequestMethod.POST)
	public String deleteSuccessCategory(@ModelAttribute Category category, @RequestParam("ret") String ret, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		Map<String, Category> AllCate = (Map<String, Category>)request.getServletContext().getAttribute("allcate");
		category = AllCate.get(category.getCategoryId());
		category.setDel(true);
		categoryService.updateCategory(category);
		
		try {
			ret = URLEncoder.encode(ret, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getServletContext().removeAttribute("rootcate");
		request.getServletContext().setAttribute("rootcate", categoryService.getRootCategoryList());
		request.getServletContext().removeAttribute("allcate");
		request.getServletContext().setAttribute("allcate", categoryService.getAllCategoryList());
		return "redirect:/admin/category/delete/choicesub?categoryId="+ ret;
	}
	
	public List<Category> getParents(Category cate, Map<String, Category> AllCate) {
		List<Category> parents = categoryService.getParentCategoryListById(cate.getCategoryId(), AllCate);
		return parents;
	}
}
