package com.sphinx.korigin.shopping.product.dao;

import java.util.List;

import com.sphinx.korigin.shopping.product.domain.Option;

public interface OptionDao {

	public String insertOption(String optionName, String productId);
	
	public void updateOption(Option option);
	
	public void removeOption(Option option);
	
	public Option selectOptionById(String optionId);
	
	public List<Option> selectOptionListByProductId(String productId);
}
