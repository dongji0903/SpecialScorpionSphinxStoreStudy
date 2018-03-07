package com.sphinx.korigin.study.study.web.quiz;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.sphinx.korigin.study.category.domain.Category;

@Controller
public class SetQuizController {

	@RequestMapping(value = "/quiz/", method = RequestMethod.GET)
	public String setCategoryView(WebApplicationContext context, Model m) {
		List<Category> studyRootCategoryList = (List<Category>) context.getServletContext()
				.getAttribute("studyRootCategoryList");
		m.addAttribute("categories", studyRootCategoryList);
		return null;
	}
}
