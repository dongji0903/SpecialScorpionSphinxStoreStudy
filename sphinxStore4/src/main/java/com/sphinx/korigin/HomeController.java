package com.sphinx.korigin;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

import com.sphinx.korigin.shopping.category.domain.ShoppingCategory;
import com.sphinx.korigin.shopping.category.service.ShoppingCategoryService;
import com.sphinx.korigin.study.category.domain.Category;
import com.sphinx.korigin.study.study.service.StudyCategoryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController implements ApplicationContextAware {
	private WebApplicationContext context;
	@Autowired
	private ShoppingCategoryService shoppingCategoryService;
	@Autowired
	private StudyCategoryService studyCategoryService;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		/*model.addAttribute("contents", "customer/shopping/index.jsp");
		 return "korigin/customer/shopping/index"; 
		return "korigin/default";*/
		return "korigin/study/form/main_Form";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
		Map<String, ShoppingCategory> shoppingCategoryMap = shoppingCategoryService
				.getAllCategory();
		List<ShoppingCategory> shoppingRootCategoryList = shoppingCategoryService
				.getRootCategoryList();
		Map<String, Category> studyCategoryMap = studyCategoryService
				.findAllCategories();
		List<Category> studyRootCategoryList = studyCategoryService
				.findFirstCategories();

		context.getServletContext().setAttribute("shoppingCategoryMap",
				shoppingCategoryMap);
		context.getServletContext().setAttribute("shoppingRootCategoryList",
				shoppingRootCategoryList);
		context.getServletContext().setAttribute("studyCategoryMap",
				studyCategoryMap);
		context.getServletContext().setAttribute("studyRootCategoryList",
				studyRootCategoryList);
		System.out.println("shopping:" + shoppingRootCategoryList);
		System.out.println("study:" + studyRootCategoryList);

	}

}
