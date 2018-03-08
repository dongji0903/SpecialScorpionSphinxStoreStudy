package com.sphinx.korigin.shopping.product.domain;

import java.util.Map;

public class Option {
	private String optionId;
	private String optionName;
	private Map<String, Double> optionValue;
	private boolean del;

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	public Map<String, Double> getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(Map<String, Double> optionValue) {
		this.optionValue = optionValue;
	}

	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", optionName=" + optionName
				+ ", optionValue=" + optionValue + ", del=" + del + "]";
	}
	
	
}
