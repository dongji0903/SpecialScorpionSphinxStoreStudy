package com.sphinx.korigin.study.shop.dao;

public interface StockManagementDao {
	public void updateStock(String num, int stock);
	public void resetStock(String num, int stock);
	public String insertStock(String num, int stock);
	public int selectStock(String num);
}
