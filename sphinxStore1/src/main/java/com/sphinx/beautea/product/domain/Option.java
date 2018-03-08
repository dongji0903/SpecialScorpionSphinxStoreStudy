package com.sphinx.beautea.product.domain;

import java.util.HashMap;
import java.util.Map;

public class Option {

	private String optionId;
	private String optionName;
	private Map<String, Double> optionValueMap = new HashMap<>();
	private boolean del;
	
	
	public void addOptionValue(String optionValue, double addPrice) {
		optionValueMap.put(optionValue, addPrice);
	}
	
	
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
	public Map<String, Double> getOptionValueMap() {
		return optionValueMap;
	}
	public void setOptionValueMap(Map<String, Double> optionValueMap) {
		this.optionValueMap = optionValueMap;
	}
	
}
