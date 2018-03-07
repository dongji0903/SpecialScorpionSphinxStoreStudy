package com.sphinx.korigin.shopping.product.service;

import java.util.List;
import java.util.Map;

import com.sphinx.korigin.shopping.product.domain.Option;

public interface OptionService {
	public void addOption(Map<String, Option> optionMap,
			Map<String, String> keyMap, Map<String, String> valueMap,
			String productId);

	public void updateOption(Option option);

	public void deleteOption(Option option);

	public Option getOptionById(String optionId);

	public List<Option> getOptionListByProductId(String productId);

}
