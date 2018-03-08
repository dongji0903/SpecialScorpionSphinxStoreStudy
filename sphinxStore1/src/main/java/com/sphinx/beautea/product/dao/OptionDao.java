package com.sphinx.beautea.product.dao;

import java.util.List;

import com.sphinx.beautea.product.domain.Option;

public interface OptionDao {

	public void addOption(Option option, String productId);
	
	public void updateOption(Option option);
	
	public void deleteOption(Option option);
	
	public void deleteOptionValue(String optionId);
	
	public Option getOptionById(String optionId);
	
	public List<Option> getOptionListByProductId(String productId);
	
	// 우리 조만 있는 것
	public List<Option> getDeleteOptionListByProductId(String productId);
	
	
}
