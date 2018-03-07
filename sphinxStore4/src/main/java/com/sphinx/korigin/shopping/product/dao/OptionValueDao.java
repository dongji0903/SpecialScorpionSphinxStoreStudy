package com.sphinx.korigin.shopping.product.dao;

import com.sphinx.korigin.shopping.product.domain.Option;

public interface OptionValueDao {
	public String insertOptionValue(Option option);

	public void updateOptionValue(String optionId, String mapKey, String mapValue);

	public void removeOptionValue(String optionValueId);
}
