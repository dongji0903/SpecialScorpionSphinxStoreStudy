package com.sphinx.korigin.shopping.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.korigin.shopping.product.domain.Product;
import com.sphinx.korigin.shopping.product.service.OptionService;
import com.sphinx.korigin.shopping.product.service.ProductService;

@Controller
public class ProductDetailController {

	@Autowired
	private ProductService productService;
	@Autowired
	private OptionService optionservice;

	public String getProductDetail(
			@RequestParam("productId") String productId) {
		Product product = productService.getProductById(productId);

		return "";

	}

}
