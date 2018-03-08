package com.sphinx.beautea.product.web.controller.admin.edit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.service.CategoryService;

@Controller
public class SelectCategoryForEditProduct {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/admin/product/edit/selectcategory", method = RequestMethod.GET)
	public String selectCategory(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<Category> rootCategory = (List<Category>)request.getServletContext().getAttribute("rootcate");
		@SuppressWarnings("unchecked")
		Map<String, Category> allCategory = (Map<String, Category>)request.getServletContext().getAttribute("allcate");
		
		
		//type이 쇼핑몰인 root 애들만 담아!!
		List<Category> shoppingCate = new ArrayList<>();
		//type이 쇼핑몰인 root 애들 중, 하위애들을 담아 
		Map<String, List<Category>> subCategoryMap = new HashMap<>();
		//지들 하위 애들을 담아욤
		Map<String, List<Category>> parentCategoryMap = new HashMap<>();

		for(Category c : rootCategory) {
			if(c.getType() == 0) {
				shoppingCate.add(c);
				List<Category> subCategory = c.getSubCategoryList(c);
				subCategoryMap.put(c.getCategoryId(), subCategory);
				for(Category s : subCategory) {
					List<Category> parentCategory = categoryService.getParentCategoryListById(s.getCategoryId(), allCategory);
					parentCategoryMap.put(s.getCategoryId(), parentCategory);
				}
			}
		}
		request.setAttribute("shoppingCategory", shoppingCate);
		request.setAttribute("subCategoryMap", subCategoryMap);
		request.setAttribute("parentCategoryMap", parentCategoryMap);
		
		return "admin/product/edit/select_category";
	}
	
	
}
