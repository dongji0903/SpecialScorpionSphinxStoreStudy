package com.sphinx.beautea.product.dao;

import java.util.List;

import com.sphinx.beautea.product.domain.Product;

public interface ProductDao {

	public String addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public Product findProductById(String productId);
	
	public List<Product> findProductList(int start, int amount);
	
	public List<Product> searchProductListByKeyword(int start, int amount, String keyword);
	
	//우리조만 있는 것
	public List<Product> findDeleteProduct(int start, int amount);
	
	public int countProduct(boolean del);
	
	public List<Product> searchProductListByName(int start, int amount, String name);
	
}
