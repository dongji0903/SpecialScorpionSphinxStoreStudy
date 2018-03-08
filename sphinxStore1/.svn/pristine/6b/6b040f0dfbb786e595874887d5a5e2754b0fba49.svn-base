package com.sphinx.beautea.category.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private String categoryId;
	private String categoryName;
	private String parentId;
	private boolean del;
	private List<Category> subCategory = new ArrayList<>();
	//우리조만 있는 것
	private int type; //게시판인지 쇼핑몰형식인지 구분
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public boolean isDel() {
		return del;
	}
	public void setDel(boolean del) {
		this.del = del;
	}
	public List<Category> getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(List<Category> subCategory) {
		this.subCategory = subCategory;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	//인자로 들어온 카테고리가 가지고있는 하위리스트들의 하위를 끝까지 찾아노느 메소드
	public List<Category> getSubCategoryList(Category category) {
		List<Category> sublist = new ArrayList<>();
		sublist.add(category);
		
		if (category.getSubCategory().isEmpty() == false) {
			for (Category c : category.getSubCategory()) {
				sublist.addAll(getSubCategoryList(c));
			}
		}
		 
		return sublist;
	}
	
	
	
}
