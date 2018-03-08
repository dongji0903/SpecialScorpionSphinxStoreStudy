package com.sphinx.beautea.product.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product implements Cloneable {
	
	private String productId;
	private String productName;
	private double price;
	private String content;
	private List<String> fileName;
	private String comment;
	private boolean del;
	private Date regDate;
	private List<Option> optionList = new ArrayList<>();
	/*	private List<Category> category;*/
	
	
	public Product() {
		this.regDate = new Date();
	}
	
	public void options(Option option) {
		optionList.add(option);
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getFileName() {
		return fileName;
	}
	public void setFileName(List<String> fileName) {
		this.fileName = fileName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isDel() {
		return del;
	}
	public void setDel(boolean del) {
		this.del = del;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public List<Option> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<Option> optionList) {
		this.optionList = optionList;
	}
	
	
	/*	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}*/
	
	
}
