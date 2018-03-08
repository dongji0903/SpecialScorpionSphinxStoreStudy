package com.sphinx.beautea.product.web.controller.admin.edit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.domain.LinkInC;
import com.sphinx.beautea.category.service.CategoryService;
import com.sphinx.beautea.category.service.LinkInCService;
import com.sphinx.beautea.common.domain.PageUtil;
import com.sphinx.beautea.product.domain.Product;
import com.sphinx.beautea.product.service.ProductService;

@Controller
public class ChoiceProductController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	LinkInCService linkService;
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/admin/product/edit/choiceproduct", method = RequestMethod.GET)
	public String editForm(HttpServletRequest request) {
		String categoryId = request.getParameter("categoryId");
		
		/*----------------------------------------------------
		-----------------------페이지영역----------------------
		-----------------------------------------------------*/
		String pageStr = "1";
		int page = 1;
		try {
			pageStr = request.getParameter("page");
			page = Integer.parseInt(pageStr);
		} catch(NullPointerException | NumberFormatException e) {
			page = 1;
		}
		
		PageUtil pageUtil = new PageUtil();
		int count = linkService.countProductByCategoryId(categoryId, false);
		List<Integer> pageList = pageUtil.getPages(count, page);
		int maxPage = pageUtil.getMaxPage(count);
		
		request.setAttribute("pageList", pageList);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("page", page);
		
		/*----------------------------------------------------
		-----------------------상품영역-----------------------
		-----------------------------------------------------*/
		
		List<LinkInC> linkList = linkService.getLinkInCListByCategoryId(page, categoryId);
		
		List<Product> productList = new ArrayList<>();
		
		for(LinkInC l : linkList) {
			Product product = productService.getProductById(l.getProductId());
			productList.add(product);
		}
		
		Category category = categoryService.getCategoryById(categoryId);
		
		request.setAttribute("category", category);
		request.setAttribute("productList", productList);
		
		
		/*----------------------------------------------------
		--------------------- 카테고리 영역-------------------
		-----------------------------------------------------*/
		@SuppressWarnings("unchecked")
		List<Category> rootCategory = (List<Category>)request.getServletContext().getAttribute("rootcate");
		@SuppressWarnings("unchecked")
		Map<String, Category> allCategory = (Map<String, Category>)request.getServletContext().getAttribute("allcate");
		
		
		//type이 쇼핑몰인 root 애들만 담아!!
		List<Category> shoppingCate = new ArrayList<>();
		//type이 쇼핑몰인 root 애들 중, 하위애들을 담아 
		Map<String, List<Category>> subCategoryMap = new HashMap<>();
		//지들 하위 애들을 담아욤
		Map<String, List<Category>> parentCategoryMap = new HashMap<>();

		for(Category c : rootCategory) {
			if(c.getType() == 0) {
				shoppingCate.add(c);
				List<Category> subCategory = c.getSubCategoryList(c);
				subCategoryMap.put(c.getCategoryId(), subCategory);
				for(Category s : subCategory) {
					List<Category> parentCategory = categoryService.getParentCategoryListById(s.getCategoryId(), allCategory);
					parentCategoryMap.put(s.getCategoryId(), parentCategory);
				}
			}
		}
		request.setAttribute("shoppingCategory", shoppingCate);
		request.setAttribute("subCategoryMap", subCategoryMap);
		request.setAttribute("parentCategoryMap", parentCategoryMap);
		
		
		
		return "admin/product/edit/choice_product";
	}
}
