package com.sphinx.beautea.order.service;

import java.util.List;

import com.sphinx.beautea.order.domain.OrderItem;

public interface OrderItemService {

	public void addOrderItem(OrderItem orderItem, String orderId);
	//한 주문에 여러개의 orderItem이 담기니까 orderId를 넣어줌
	
	public void updateOrderItem(OrderItem orderItem);
	
	public void deleteOrderItem(OrderItem orderItem);
	
	public OrderItem getOrderItemByOrderItemId(String orderItemId);
	
	public List<OrderItem> getOrderItemListByOrderId(String orderId);
	//주문 코드로 DB에서 해당하는 주문의 OrderId로 객체들을 찾아옴.
	
}
