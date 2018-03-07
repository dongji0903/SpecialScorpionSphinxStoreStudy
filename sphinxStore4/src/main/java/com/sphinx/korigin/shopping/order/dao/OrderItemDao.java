package com.sphinx.korigin.shopping.order.dao;

import java.util.List;

import com.sphinx.korigin.shopping.order.domain.OrderItem;

public interface OrderItemDao {
	public void addOrderItem(OrderItem orderItem, String orderId);

	public void updateOrderItem(OrderItem orderItem);

	public void deleteOrderItem(OrderItem orderItem);

	public OrderItem getOrderItemByOrderItemId(String orderItemId);

	public List<OrderItem> getOrderItemListByOrderId(String orderId);
}
