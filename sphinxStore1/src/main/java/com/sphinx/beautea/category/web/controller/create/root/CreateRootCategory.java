package com.sphinx.beautea.category.web.controller.create.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //컨트롤러로 인식
public class CreateRootCategory {
	@RequestMapping("/admin/category/addmain")
	//Get
	//@RequestParam("id") String s,
	public String sayHello() {
		return "admin/category/add/maincategory/add_maincategory";
	}
}
