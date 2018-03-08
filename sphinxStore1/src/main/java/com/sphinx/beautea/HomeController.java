package com.sphinx.beautea;

import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.category.common.MiniComparator;
import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.service.CategoryService;

/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping("/") : post, get 공통적인 value값을 가질 때 맨 위에 올려서 쓸수있음
public class HomeController {
	@Autowired
	CategoryService categoryService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//폼 디스플레이(get)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		if (request.getServletContext().getAttribute("rootcate") == null ||
				request.getServletContext().getAttribute("allcate") == null) {
			
			List<Category> root_list = categoryService.getRootCategoryList();//최상위 카테고리 리스트
			Collections.sort(root_list, new MiniComparator());
			Map<String, Category> AllCate = categoryService.getAllCategoryList();
			
			request.getServletContext().setAttribute("rootcate", root_list);
			request.getServletContext().setAttribute("allcate", AllCate);
		}
		
		
		return "index";
	}
	
	
//폼 처리(post)
/* @RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}*/
	
}
