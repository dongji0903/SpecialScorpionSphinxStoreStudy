package com.sphinx.korigin.shopping.order.domain;

import java.util.Map;

public class Cart {
	private Map<String, OrderItem> orderItemMap;

	public void addOrderItem(OrderItem o) {

	}

	public void updateOrderItem(OrderItem o) {

	}

	public void removeOrderItem(OrderItem o) {

	}

	public double getTotalPrice() {
		return 0;
	}

	public Map<String, OrderItem> getOrderItemMap() {
		return orderItemMap;
	}

	public void setOrderItemMap(Map<String, OrderItem> orderItemMap) {
		this.orderItemMap = orderItemMap;
	}
}
