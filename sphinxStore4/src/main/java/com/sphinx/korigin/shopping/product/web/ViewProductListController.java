package com.sphinx.korigin.shopping.product.web;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.sphinx.korigin.shopping.category.domain.ShoppingCategory;
import com.sphinx.korigin.shopping.product.domain.Product;
import com.sphinx.korigin.shopping.product.service.ProductService;

@Controller
public class ViewProductListController {

	@Autowired
	private ProductService productService;

	/** 해당 카테고리의 상품들을 뿌려주는 메소드 */
	@RequestMapping(value = "/product/ViewProduct", method = RequestMethod.GET)
	public String viewProductList(
			@RequestParam("categoryId") String categoryId) {

		return "korigin/product/viewProductList";
	}

	@RequestMapping(value = "/product/Catalog", method = RequestMethod.GET)
	public String viewCatalog(@RequestParam("categoryId") String categoryId,
			Model model, ServletRequest request) {
		ShoppingCategory category = (ShoppingCategory) ((Map)request.getServletContext().getAttribute("categoryMap"))
						.get(categoryId);
		List<Product> productList = productService.getProductListByCategoryId(0,
				10, category);
		System.out.println(productList);
		model.addAttribute("productList", productList);
		model.addAttribute("thisCategory", category);
		model.addAttribute("contents","customer/shopping/catalog.jsp");
		return "korigin/default";
	}
}
