package com.sphinx.korigin.shopping.product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.korigin.shopping.category.domain.ShoppingCategory;
import com.sphinx.korigin.shopping.product.domain.Product;
import com.sphinx.korigin.shopping.product.service.ProductService;

@Controller
@RequestMapping(value = "/admin/product")
public class FindProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/findProduct", method = RequestMethod.POST)
	public String findProduct(Model m, @RequestParam("searchValue") String type,
			@RequestParam("search") String value) {
		Product searchProduct = new Product();
		if (type.equals("name")) {
			searchProduct = productService.getProductByName(value);
		}
		if (type.equals("id")) {
			searchProduct = productService.getProductById(value);
		}
		m.addAttribute("msg", "검색완료");
		m.addAttribute("searchProduct", searchProduct);
		return "korigin/admin/product/findProduct";
	}

	@RequestMapping(value = "/findProduct", method = RequestMethod.GET)
	public String findProductView() {
		return "korigin/admin/product/findProduct";
	}

}
