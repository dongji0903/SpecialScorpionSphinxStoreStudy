package com.sphinx.beautea.category.dao;

import java.util.List;
import java.util.Map;

import com.sphinx.beautea.category.domain.Category;

public interface CategoryDao {
public void addCategory(Category category);
	
	public void updateCategory(Category category);
	
	public void deleteCategory(Category category);
	
	public Category getCategoryById(String categoryId);
	
	
	public List<Category> getCategoryByName(String categoryName);
	
	public Map<String, Category> getAllCategoryList();
	
	
	public List<Category> getRootCategoryList(); // 최상위 카테고리 리스트

	// 우리조만 있는 것
	public List<Category> getCategoryListbyType(int type);
	//원하는 type의 카테고리만 리스트에 담에서 return
	
	public List<Category> getDeleteCategoryList();
	//삭제된 카테고리 리스트 불러오기
	
}
