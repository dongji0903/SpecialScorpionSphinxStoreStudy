package com.sphinx.beautea.category.web.controller.create.sub;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.service.CategoryService;

@Controller
public class CreateSucSubcategory {
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/admin/category/sucaddsub",method=RequestMethod.POST)
	public String CreateSubCategory(@ModelAttribute Category category, 
			@RequestParam("ret") String ret, HttpServletRequest request) {
		categoryService.addCategory(category);
		
		List<Category> root_list = categoryService.getRootCategoryList();//최상위 카테고리 리스트
		Map<String, Category> AllCate = categoryService.getAllCategoryList();

		request.getServletContext().setAttribute("rootcate", root_list);
		request.getServletContext().setAttribute("allcate", AllCate);
		
		try {
			ret = URLEncoder.encode(ret, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/admin/category/addsub/selparent?categoryId="+ ret;
	}
}
