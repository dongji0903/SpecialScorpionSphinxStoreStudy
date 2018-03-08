package com.sphinx.korigin.study.shop.dao;

import java.util.List;

import com.dug.domain.shop.Order;

public interface OrderDao {
	
	List<Order> selectAllOrders();
	
	String insertOrder(Order ovo);
	
	Order selectOrder(String num);

}
