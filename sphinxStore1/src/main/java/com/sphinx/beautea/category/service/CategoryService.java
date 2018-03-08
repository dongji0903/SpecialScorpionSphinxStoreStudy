package com.sphinx.beautea.category.service;

import java.util.List;
import java.util.Map;

import com.sphinx.beautea.category.domain.Category;

public interface CategoryService {

	public void addCategory(Category category);
	
	public void updateCategory(Category category);
	
	public void deleteCategory(Category category);
	
	public Category getCategoryById(String categoryId);
	
	public List<Category> getCategoryByName(String categoryName);
	
	public Map<String, Category> getAllCategoryList();
	
	public List<Category> getSubCategoryListByParentId(Category category);
	
	public List<Category> getRootCategoryList(); // 최상위 카테고리 리스트

	// 우리조만 있는 것
	public List<Category> getParentCategoryListById(String categoryId, Map<String, Category> categoryList);
	//부모카테고리를 순차적으로 찾아가는 것
	
	public Category setSubCategoryList(Category category, Map<String,Category> categoryList);

	public List<Category> getCategoryListbyType(int type);
	//원하는 type의 카테고리만 리스트에 담에서 return
	
	public List<Category> getDeleteCategoryList();
	//삭제된 카테고리 리스트 불러오기

	// 나머지는 LinkInCService와 LinkBnCService에서 구현함
}
