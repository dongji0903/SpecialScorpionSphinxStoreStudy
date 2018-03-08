package com.sphinx.beautea.product.service;

import java.util.List;

import com.sphinx.beautea.product.domain.Product;

public interface ProductService {

	public String addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public Product getProductById(String productId);
	
	public List<Product> getProductList(int page);
	
	public List<Product> searchProductListByKeyword(int page, String keyword);
	
	//우리조만 있는 것
	public List<Product> getDeleteProduct(int page);
	
	public int countProduct(boolean del);
	
	public List<Product> searchProductListByName(int start, int amount, String name);
}
