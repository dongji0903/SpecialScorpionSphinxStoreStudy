package com.sphinx.korigin.shopping.product.dao;

import java.util.List;

public interface ProductCategoryLinkDao {
	public void insertLink(String productId, String categoryId);

	public List<String> selectProductIdsByCategoryId(String... categoryId);

	public List<String> selectCategoryIdsByProductId(String productId);
}
