package com.sphinx.beautea.category.web.controller.delete;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.service.CategoryService;

@Controller
public class MoveDeletePageController {

	@Autowired
	CategoryService categoryService;
	@RequestMapping("/admin/category/delete")
	public String movePage(HttpServletRequest request) {
		List<Category> root_list = categoryService.getRootCategoryList();//최상위 카테고리 리스트
		Map<String, Category> AllCate = categoryService.getAllCategoryList();
		
		if (request.getServletContext().getAttribute("rootcate") == null) {
			request.getServletContext().setAttribute("rootcate", root_list);
		}
		
		if (request.getServletContext().getAttribute("allcate") == null) {
			request.getServletContext().setAttribute("allcate", AllCate);
		}
		
		return "admin/category/delete/select_rootcategory";
	}
}
