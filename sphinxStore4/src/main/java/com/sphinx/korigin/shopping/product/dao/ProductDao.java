package com.sphinx.korigin.shopping.product.dao;

import java.util.List;

import com.sphinx.korigin.shopping.product.domain.Product;

public interface ProductDao {
	public String insertProduct(Product product);

	public void updateProduct(Product product);

	public void removeProduct(Product product);

	public Product selectProductById(String productId);

	public Product selectProductByName(String productName);

	public List<Product> selectProductList(int start, int amount);

	public List<Product> selectProductListByCategoryId(int start, int amount,
			String... categoryId);

	public List<Product> selectProductListByKeyword(int start, int amount,
			String keyword);
}
