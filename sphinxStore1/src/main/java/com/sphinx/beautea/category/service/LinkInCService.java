package com.sphinx.beautea.category.service;

import java.util.List;
import java.util.Map;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.domain.LinkInC;
import com.sphinx.beautea.product.domain.Product;

public interface LinkInCService {

	public void addLinkInC(LinkInC linkInC);
	
	public void updateLinkInC(LinkInC linkInC);
	
	public void deleteLinkInC(LinkInC linkInC);
	
	public LinkInC getLinkInCById(String linkId);
	
	public List<LinkInC> getLinkInCListByCategoryId(String categoryId);
	
	public List<LinkInC> getLinkInCListByCategoryId(int page, String categoryId);
	
	public List<LinkInC> getLinkInCListByProductId(String productId);
	
	public List<Product> getProductListByCategoryId(String categoryId);
	
	public List<Category> getCategoryListByProductId(String productId, 
			Map<String, Category> categoryMap);
	
	public int countProductByCategoryId(String categoryId, boolean del);
}
