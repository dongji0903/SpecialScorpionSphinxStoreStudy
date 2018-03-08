package com.sphinx.korigin.shopping.category.service;

import java.util.List;
import java.util.Map;

import com.sphinx.korigin.shopping.category.domain.ShoppingCategory;

public interface ShoppingCategoryService {
	public void addCategory(ShoppingCategory category);

	public void updateCategory(ShoppingCategory category);

	public void deleteCategory(ShoppingCategory category);

	public Map<String, ShoppingCategory> getAllCategory();

	public ShoppingCategory getCategoryById(String categoryId);

	public ShoppingCategory getCategoryByName(String categoryName);

	public List<ShoppingCategory> getSubCategoryListByparentId(String categoryId);

	public List<ShoppingCategory> getRootCategoryList();
	
	/*
	 * public List<Category> getSubCategoryListByparentId(String categoryId,
	 * Map<String, Category>);
	 */

}
