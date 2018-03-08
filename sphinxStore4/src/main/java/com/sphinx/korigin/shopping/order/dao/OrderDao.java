package com.sphinx.korigin.shopping.order.dao;

import java.util.Date;
import java.util.List;

import com.sphinx.korigin.shopping.order.domain.Order;

public interface OrderDao {
	public String addOrder(Order order);

	public void updateOrder(Order order);

	public void deleteOrder(Order order);

	public Order getOrderById(String orderId);

	public List<Order> getOrderByDate(Date startDate, Date endDate, int start,
			int amount);

	public List<Order> getOrderByCustomerId(Date startDate,
			Date endDate,String customerId, int start, int amount);
}
