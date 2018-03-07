package com.sphinx.korigin.shopping.product.domain;

import java.util.Date;
import java.util.List;

import com.sphinx.korigin.shopping.category.domain.ShoppingCategory;

public class Product {
	private String productId;
	private String productName;
	private double price;
	private List<String> fileName;
	private String content;
	private String comment;
	private List<Option> option;
	private List<ShoppingCategory> Category;
	private Date regDate;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productId) {
		super();
		this.productId = productId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<String> getFileName() {
		return fileName;
	}

	public void setFileName(List<String> fileName) {
		this.fileName = fileName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Option> getOption() {
		return option;
	}

	public void setOption(List<Option> option) {
		this.option = option;
	}

	public List<ShoppingCategory> getCategory() {
		return Category;
	}

	public void setCategory(List<ShoppingCategory> category) {
		Category = category;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", price=" + price + ", fileName=" + fileName
				+ ", content=" + content + ", comment=" + comment + ", option="
				+ option + ", Category=" + Category + ", regDate=" + regDate
				+ "]";
	}

}
