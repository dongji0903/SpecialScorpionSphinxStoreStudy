package com.sphinx.beautea.product.web.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.beautea.product.domain.Product;
import com.sphinx.beautea.product.service.ProductService;

@Controller
public class DeatilViewController {
	@Autowired
	ProductService productService;
	@RequestMapping(value="/view/product", method=RequestMethod.GET)
	public String LoadProduct(@RequestParam("productId") String id,
			Model model) {
		
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "index-2";
	}
}
