package com.sphinx.korigin.study.study.service;

import java.util.List;
import java.util.Map;

import com.sphinx.korigin.study.category.domain.Category;

public interface StudyCategoryService {

	public String createCategory(Category c);
	
	public void deleteCategory(String cid);
	
	public void modifyCategory(Category newCat);
	
	public List<Category> findFirstCategories();
	
	public Map<String, Category> findAllCategories();
}
