package com.sphinx.beautea.order.service;

import java.sql.Date;
import java.util.List;

import com.sphinx.beautea.order.domain.Order;

public interface OrderService {

	public String addOrder(Order order);
	
	public void updateOrder(Order order);
	
	public void deleteOrder(Order order);
	
	public Order getOrderById(String orderId);
	
	public List<Order> getOrderListByCustomerId(String customerId);
	
	public List<Order> getOrderListByCustomerId(int page, String customerId);
	
	public List<Order> getOrderListByDate(Date startDate, Date endDate, int page);
	
	public List<Order> getOrderListByDate(String customerId, Date startDate, Date endDate, int page);
	
	//우리조만 있는 것 
	public int countOrderByCustomerId(String customerId);
	
	public int countOrderByDate(Date startDate, Date endDate);
	
	public double sumTotalPricePurchased(String customerId);
	
}
