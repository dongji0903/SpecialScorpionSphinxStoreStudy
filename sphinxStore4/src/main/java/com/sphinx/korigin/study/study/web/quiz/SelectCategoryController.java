package com.sphinx.korigin.study.study.web.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.sphinx.korigin.study.category.domain.Category;

@Controller
public class SelectCategoryController {

	@Autowired
	private WebApplicationContext context;

	@RequestMapping(value = "/study/selectCategory", method = RequestMethod.GET)
	public String selectCategoryView() {
		return "include:study/quiz/selectCategory";
	}

	@RequestMapping(value = "/study/selectCategory", method = RequestMethod.POST)
	public String selectCategory(Model m,
			@RequestParam("selectCategory") String categoryId,
			@RequestParam("currentPath") String categoryPath,
			@RequestParam("totalCount") String countString) {

		if (categoryId != null) {
			@SuppressWarnings("unchecked")
			Map<String, Category> categoryMap = (Map<String, Category>) context
					.getServletContext().getAttribute("studyCategoryMap");
			Category category = categoryMap.get(categoryId);
			if (category != null) {
				List<Category> subCategories = new ArrayList<>();
				if (category.getChildren() != null
						&& !category.getChildren().isEmpty()) {
					for (String s : category.getChildren()) {
						subCategories.add(categoryMap.get(s));
					}
				}
				m.addAttribute("currentCategory", category);
				if (subCategories != null && !subCategories.isEmpty()) {
					m.addAttribute("categories", subCategories);
					if (categoryPath != null && !categoryPath.equals("")) {
						m.addAttribute("categoryPath",
								categoryPath + ">" + category.getTitle());
					} else {
						m.addAttribute("categoryPath", category.getTitle());
					}
					m.addAttribute("rcount", countString);
				} else {
					m.addAttribute("categoryPath", category.getTitle());

					m.addAttribute("rcount", countString);
				}
			}
		}
		m.addAttribute("url", "korigin/study/study/quiz/selectCategory.jsp");
		return "korigin/study/form/main_Form";
	}
}
