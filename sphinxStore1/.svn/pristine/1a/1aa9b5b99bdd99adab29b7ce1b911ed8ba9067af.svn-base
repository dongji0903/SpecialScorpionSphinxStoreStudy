package com.sphinx.beautea.order.dao;

import java.util.List;

import com.sphinx.beautea.order.domain.OrderItem;

public interface OrderItemDao {

	public void addOrderItem(OrderItem orderItem, String orderId);
	//한 주문에 여러개의 orderItem이 담기니까 orderId를 넣어줌
	
	public void updateOrderItem(OrderItem orderItem);
	
	public void deleteOrderItem(OrderItem orderItem);
	
	public OrderItem findOrderItemByOrderItemId(String orderItemId);
	
	public List<OrderItem> findOrderItemListByOrderId(String orderId);
	//주문 코드로 DB에서 해당하는 주문의 OrderId로 객체들을 찾아옴.
	
}
