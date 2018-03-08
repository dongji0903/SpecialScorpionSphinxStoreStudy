package com.sphinx.beautea.category.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //컨트롤러로 인식
public class CreateCategory {
	@RequestMapping("/admin/category/create")
	//Get
	//@RequestParam("id") String s,
	public String sayHello() {
		return "admin/category/add/add_category";
	}
}
