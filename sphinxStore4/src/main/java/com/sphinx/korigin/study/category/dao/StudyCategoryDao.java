package com.sphinx.korigin.study.category.dao;

import java.util.List;
import java.util.Map;
import com.sphinx.korigin.study.category.domain.Category;

public interface StudyCategoryDao {

	public String createCategory(Category c);

	public void modifyCategory(Category c);

	public Map<String,Category> findAllCategory();

	public Category findCategory(String cid);		//'degree/cid' 형태의 문자열

	public List<Category> findCategoryByTitle(String title);		//카테고리명 중복을 허용
	
	public List<Category> findFirstCategories();

	public void deleteCategory(String cid);

	public void deleteCascadeCategory(String cid);
}
