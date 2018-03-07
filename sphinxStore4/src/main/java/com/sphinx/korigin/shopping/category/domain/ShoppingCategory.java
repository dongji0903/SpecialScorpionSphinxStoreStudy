package com.sphinx.korigin.shopping.category.domain;

import java.util.List;

public class ShoppingCategory {
	private String superId;
	private String categoryId;
	private String categoryName;
	private List<ShoppingCategory> subCategory;
	private boolean del;

	public String getSuperId() {
		return superId;
	}

	public void setSuperId(String superId) {
		this.superId = superId;
	}

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

	public List<ShoppingCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<ShoppingCategory> subCategory) {
		this.subCategory = subCategory;
	}

	public boolean getDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "Category [superId=" + superId + ", categoryId=" + categoryId
				+ ", categoryName=" + categoryName + ", subCategory="
				+ subCategory + ", del=" + del + "]";
	}

}
