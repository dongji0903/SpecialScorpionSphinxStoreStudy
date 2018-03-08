package com.sphinx.beautea.order.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sphinx.beautea.common.primary.CreatePrimary;
import com.sphinx.beautea.order.domain.Cart;
import com.sphinx.beautea.order.domain.OrderItem;
import com.sphinx.beautea.product.domain.Option;
import com.sphinx.beautea.product.domain.Product;
import com.sphinx.beautea.product.service.ProductService;

@Controller
public class CartController {
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/cart/remove", method=RequestMethod.POST)
	public String removeItem(@RequestParam("removeItems") String items, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		Cart cart = (Cart)session.getAttribute("cart");
		
		String[] remove = items.split("/");
		
		for (String key : remove) {
			cart.removeOrderItem(key);
		}
		
		session.removeAttribute("cart");
		
		if (!cart.getOrderItemMap().isEmpty()) {
			session.setAttribute("cart", cart);
		}
		
		return "redirect:/cart";
	}
	
	@ResponseBody
	@RequestMapping(value="/shopping/cart/addcart", method=RequestMethod.POST)
	public int addCart(HttpServletRequest request) {
		String[] optionValue = request.getParameterValues("optionValue");
		String[] quantity = request.getParameterValues("quantity");
		String productId = request.getParameter("productId");
		
		//옵션별로 List에 담아서 그것들을 다시한번 List에 담아서 모아둔다.
		List<List<String>> optionName2 = new ArrayList<>();
		//최종적으로 다 걸러진 프로덕트들이 들어올 리스트
		List<Product> productList = new ArrayList<>();
		
		//옵션별로 나누는과정
		for (String s : optionValue) {
			String[] spl = s.split("/");
			List<String> list = new ArrayList<>();
			for (String s2: spl) {
				list.add(s2);
			}
			optionName2.add(list);
		}
		
		
		int count = optionName2.size();
		
		for (int i = 0; i < count; i++) {
			Product p = productService.getProductById(productId);;
			List<Option> optionList = new ArrayList<>();
			for (Option o : p.getOptionList()) {
				Map<String, Double> valueMap = new HashMap<>();
				for (String s : o.getOptionValueMap().keySet()) {
					Boolean chk = false;
					for (String options : optionName2.get(i)) {
						if (s.equals(options)) {
							chk = true;
						}
					}
					
					if (chk) {
						valueMap.put(s, o.getOptionValueMap().get(s));
					}
				}
				o.setOptionValueMap(valueMap);
				optionList.add(o);
			}
			
			p.setOptionList(optionList);
			productList.add(p);
			
		}
		
		Cart cart = new Cart();
		CreatePrimary primary = CreatePrimary.getInstance();
		Long pr = Long.parseLong(primary.createPrimaryKey());
		for (int i = 0; i < productList.size(); i++) {
			pr = pr+1;
			OrderItem o = new OrderItem();
			o.setProduct(productList.get(i));
			o.setQuantity(Integer.parseInt(quantity[i]));
			o.setOrderItemId("oi" + (pr));
			cart.addOrderItem(o);
		}
		
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") != null) {
			Cart user_cart = (Cart)session.getAttribute("cart");
			for (String key : user_cart.getOrderItemMap().keySet()) {
				cart.addOrderItem(user_cart.getOrderItemMap().get(key));
			}
			
			session.removeAttribute("cart");
		}
		
		session.setAttribute("cart", cart);
		return cart.countCartItem();
	}
}
