package com.sphinx.beautea.product.web.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.beautea.category.domain.LinkInC;
import com.sphinx.beautea.category.service.LinkInCService;
import com.sphinx.beautea.product.domain.Product;
import com.sphinx.beautea.product.service.ProductService;
@Controller
public class ShoppingBoardController {
	@Autowired
	LinkInCService linkService;
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/shopping/menu", method = RequestMethod.GET)
	public String SelectCategory(@RequestParam("categoryID") String id,
			HttpServletRequest request, Model model) {
		String page = request.getParameter("page");
		List<LinkInC> links = new ArrayList<>();
		
		if (page == null) {
			page = "1";
		}
		
		links.addAll(linkService.getLinkInCListByCategoryId(Integer.parseInt(page), id));
		List<Product> product_list = new ArrayList<>();
		for (LinkInC link:links) {
			product_list.add(productService.getProductById(link.getProductId()));
		}
		
		model.addAttribute("products", product_list);
		model.addAttribute("categoryID", id);
		return "index-1";
	}
}
