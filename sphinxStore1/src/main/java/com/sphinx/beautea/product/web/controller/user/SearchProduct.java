package com.sphinx.beautea.product.web.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sphinx.beautea.product.domain.Product;
import com.sphinx.beautea.product.service.ProductService;

@Controller
public class SearchProduct {
	@Autowired
	ProductService productService;
	
	
	@ResponseBody
	@RequestMapping(value="/menu/searchByName", method=RequestMethod.POST, produces = "application/text; charset=utf8")
	public String SearchByName(@RequestParam("keyword") String keyword) {
		List<Product> productList = productService.searchProductListByName(0, 10, keyword);
		
		String product = null;
		
		for (Product p : productList) {
			if (product == null) {
				product = p.getProductId() +"/"+ p.getProductName() +"/"+ p.getPrice();
			} else {
				product = product + ":" + p.getProductId() +"/"+ p.getProductName() +"/"+ p.getPrice();
			}
		}
		
		if (productList.size() == 0) {
			return "null";
		} else {
			return product;
		}
	}
}
