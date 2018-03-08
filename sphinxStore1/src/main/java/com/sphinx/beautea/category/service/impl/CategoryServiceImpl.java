package com.sphinx.beautea.category.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.beautea.category.common.MiniComparator;
import com.sphinx.beautea.category.dao.CategoryDao;
import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.service.CategoryService;
import com.sphinx.beautea.common.domain.DateComparator;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.addCategory(category);
		
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.updateCategory(category);
		
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.deleteCategory(category);
		
	}

	@Override
	public Category getCategoryById(String categoryId) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryById(categoryId);
	}

	@Override
	public List<Category> getCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryByName(categoryName);
	}

	@Override
	public Map<String, Category> getAllCategoryList() {
		// TODO Auto-generated method stub
		Map<String, Category> map = categoryDao.getAllCategoryList();
		Set<String> keys = map.keySet();
		
		Map<String, Category> map2 = new HashMap<>();
		
		List<String> list = new ArrayList<>(keys);
		Collections.sort(list, new DateComparator());
		
		for (String key : list) {
			map2.put(key, map.get(key));
		}
		
		return map2;
	}

	@Override
	public List<Category> getSubCategoryListByParentId(Category category) {
		// TODO Auto-generated method stub
		
		List<Category> RowList = new ArrayList<>();
		for (Category c : category.getSubCategoryList(category)) {
			RowList.addAll(c.getSubCategoryList(c));
		}
		
		return RowList;
	}

	@Override
	public List<Category> getRootCategoryList() {
		// TODO Auto-generated method stub
		
		List<Category> root_list = categoryDao.getRootCategoryList();//최상위 카테고리 리스트를 Dao를 이용해서 가지고옴
		Map<String, Category> AllCate = getAllCategoryList(); //모든 카테고리들을 불러옴.
		List<Category> cate_list = new ArrayList<>(); //완성된 최상위 카테고리들을 담을 리스트 생성
		
		for (Category c : root_list) { //최상위 들을 for문 도린다.
			cate_list.add(setSubCategoryList(c, AllCate));//자기의 하위를 끝까지 찾아 내려간후 list에 담는다.
		}
		
		return cate_list; //완성된 최상위 카테고리 리스트를 return
	}

	@Override
	public List<Category> getParentCategoryListById(String categoryId,
			Map<String, Category> categoryList) {
		// TODO Auto-generated method stub
		Category category= categoryList.get(categoryId);
		List<Category> parentList = new ArrayList<>();
		if (!category.getParentId().equals("0")) {
			parentList.add(categoryList.get(category.getParentId()));
			parentList.addAll(getParentCategoryListById(category.getParentId(), categoryList));
		}
		
		Collections.sort(parentList, new MiniComparator());
		
		return parentList;
	}

	@Override
	public List<Category> getCategoryListbyType(int type) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryListbyType(type);
	}

	@Override
	public List<Category> getDeleteCategoryList() {
		// TODO Auto-generated method stub
		return categoryDao.getDeleteCategoryList();
	}

	@Override
	public Category setSubCategoryList(Category category,
			Map<String, Category> categoryList) {
		// TODO Auto-generated method stub
		for (String s : categoryList.keySet()) {
			Category c = categoryList.get(s);
			if (c != null && c.getParentId().equals(category.getCategoryId())) {
				category.getSubCategory().add(setSubCategoryList(c, categoryList));
			}
		}
		return category;
	}
}
