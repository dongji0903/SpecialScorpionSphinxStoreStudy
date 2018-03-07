package com.sphinx.korigin.shopping.product.dao;

import java.util.List;

public interface OptionsLinkDao {
	public void insertLink(String optionId, String optionValueId);

	public List<String> selectOptionValueIdsByOptionId(String optionId);

	public List<String> selectOptionIdsByOptionValueId(String optionValueId);
}
