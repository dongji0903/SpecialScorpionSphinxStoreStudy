


package com.sphinx.korigin.shopping.category.dao;

import java.util.List;

import com.sphinx.korigin.shopping.category.domain.ShoppingCategory;

public interface ShoppingCategoryDao {
	public String insertCategoy(ShoppingCategory category);

	public void removeCategoy(ShoppingCategory category);

	public void updateCategoy(ShoppingCategory category);
	
	public List<ShoppingCategory> selectAllCategoryList();
	
	public ShoppingCategory selectCategoryByName(String categoryName);
	
	public ShoppingCategory selectCategoryById(String categoryId);
	
	public List<ShoppingCategory> selectRootCategoryList();
	
	public List<ShoppingCategory> selectCategoryListByParentId(String superId);
	
	
}
