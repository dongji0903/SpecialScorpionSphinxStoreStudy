package com.sphinx.beautea.product.web.controller.admin.add;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.service.CategoryService;
import com.sphinx.beautea.product.service.OptionService;
import com.sphinx.beautea.product.service.ProductService;

@Controller
public class AddProductController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	OptionService optionService;
	
	@RequestMapping(value = "/admin/product/add", method = RequestMethod.GET)
	public String addProductForm(ServletRequest request, Model model) {
		List<Category> categoryList = (List<Category>)request.getAttribute("clist");
		
		@SuppressWarnings("unchecked")
		List<Category> root_List = (List<Category>) request.getServletContext().getAttribute("rootcate");
		@SuppressWarnings("unchecked")
		Map<String, Category> AllCate = (Map<String, Category>)request.getServletContext().getAttribute("allcate");

		List<Category> category_list = new ArrayList<>();
		Map<String, List<Category>> parent_list = new HashMap<>();
		
		for (Category c : root_List) {
			category_list.addAll(c.getSubCategoryList(c));
		}
		
		for (Category c : category_list) {
			parent_list.put(c.getCategoryId(), getParents(c, AllCate));
		}
		
		model.addAttribute("categoryList", category_list);
		model.addAttribute("parents", parent_list);
		
		return "admin/product/add/add_product";
	}
	
	@RequestMapping(value = "/admin/product/add", method = RequestMethod.POST)
	public String addProduct() {
		
		
		return "";
	}
	
	public List<Category> getParents(Category cate, Map<String, Category> AllCate) {
		List<Category> parents = categoryService.getParentCategoryListById(cate.getCategoryId(), AllCate);
		return parents;
	}
}
