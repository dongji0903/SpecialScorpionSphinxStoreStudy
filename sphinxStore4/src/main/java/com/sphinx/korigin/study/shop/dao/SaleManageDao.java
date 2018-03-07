package com.sphinx.korigin.study.shop.dao;

import java.util.List;

public interface SaleManageDao {
	public String insertNumOfSale(String num);
	
	public void updateNumOfSale(String num);

	public List<String> selectTopSale();
}
