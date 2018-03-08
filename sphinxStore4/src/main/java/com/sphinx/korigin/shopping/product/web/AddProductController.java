package com.sphinx.korigin.shopping.product.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.korigin.shopping.category.domain.ShoppingCategory;
import com.sphinx.korigin.shopping.product.domain.Option;
import com.sphinx.korigin.shopping.product.domain.Product;
import com.sphinx.korigin.shopping.product.service.OptionService;
import com.sphinx.korigin.shopping.product.service.ProductService;

@Controller
@RequestMapping(value = "/admin/product")
public class AddProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private OptionService optionservice;

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String addProductView() {
		return "korigin/admin/product/addProduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(ShoppingCategory category, Product product) {
		String id = productService.addProduct(product);
		productService.addLink(category.getCategoryId(), id);
		return "korigin/admin/product/addProduct";
	}

	@RequestMapping(value = "/addOption", method = RequestMethod.GET)
	public String addOptionView() {
		return "korigin/admin/product/addOption";
	}

	@RequestMapping(value = "/addOption", method = RequestMethod.POST)
	public String addOption(Model m, @RequestParam Map<String, String> params) {
		String productId = params.get("productId");
		Map<String, Option> optionMap = new HashMap<String, Option>();
		Map<String, String> keyMap = new HashMap<String, String>();
		Map<String, String> valueMap = new HashMap<String, String>();
		for (String key : params.keySet()) {
			String[] array = key.split("_");
			if (array[0].equals("option")) {
				Option option = new Option();
				option.setOptionName(params.get(key));
				optionMap.put(array[1], option);
			}
			if (array[0].equals("key")) {
				keyMap.put(key, params.get(key));
			}
			if (array[0].equals("value")) {
				valueMap.put(key, params.get(key));
			}
		}
		optionservice.addOption(optionMap, keyMap, valueMap, productId);
		return "korigin/admin/product/addOption";
	}
}
