package com.sphinx.korigin.shopping.product.service;

import java.util.List;

import com.sphinx.korigin.shopping.category.domain.ShoppingCategory;
import com.sphinx.korigin.shopping.product.domain.Product;

public interface ProductService {
	public String addProduct(Product product);
	
	public void addLink(String categoryId, String productId);

	public void updateProduct(Product product);

	public void deleteProduct(Product product);

	public int countProductByCategoryId(String categoryId);

	public Product getProductById(String productId);

	public Product getProductByName(String productName);

	public List<Product> searchProductByKeyword(int start, int amount,
			String keyword);
	
	public List<Product> getProductListByCategoryId(int start, int amount,
			ShoppingCategory category);
	
	public List<Product> getProductList(int start, int amount);

}
