package com.sphinx.beautea.order.dao;

import java.sql.Date;
import java.util.List;

import com.sphinx.beautea.order.domain.Order;

public interface OrderDao {

	public String addOrder(Order order);
	
	public void updateOrder(Order order);
	
	public void deleteOrder(Order order);
	
	public Order findOrderById(String orderId);
	
	public List<Order> findOrderListByCustomerId(int start, int amount, String customerId);
	
	public List<Order> findOrderListByDate(Date startDate, Date endDate, int start, int amount);
	
	public List<Order> findOrderListByDate(String customerId, Date startDate, Date endDate, int start, int amount);
	
	//우리조만 있는 것 
	public int countOrderByCustomerId(String customerId);
	
	public int countOrderByDate(Date startDate, Date endDate);
	
	public List<Order> findOrderListByCustomerId(String customerId);
	
	public double sumTotalPricePurchased(String customerId);
}
