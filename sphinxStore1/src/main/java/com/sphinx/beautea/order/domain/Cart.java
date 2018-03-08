package com.sphinx.beautea.order.domain;

import java.util.HashMap;
import java.util.Map;

import com.sphinx.beautea.product.domain.Option;
import com.sphinx.beautea.product.domain.Product;

public class Cart {
	private Map<String, OrderItem> orderItemMap = new HashMap<>();

	
	public void addOrderItem(OrderItem orderItem) {
		orderItemMap.put(orderItem.getOrderItemId(), orderItem);
	}
	
	public void updateOrderItem(OrderItem orderItem) {
		removeOrderItem(orderItem.getOrderItemId());
		orderItemMap.put(orderItem.getOrderItemId(), orderItem);
	}
	
	public void removeOrderItem(String orderItemId) {
		orderItemMap.remove(orderItemId);
	}
	
	public double getTotalPrice() {
		double price = 0;
		for(String key : orderItemMap.keySet()) {
			OrderItem orderItem = orderItemMap.get(key);
			Product orderProduct = orderItem.getProduct();
			price += orderItem.getQuantity() * orderProduct.getPrice();
			
			for (Option option : orderProduct.getOptionList()) {
				for (String keys : option.getOptionValueMap().keySet()) {
					price += orderItem.getQuantity() * option.getOptionValueMap().get(keys);
				}
			}
		}
		
		return price;
	}
	
	
	public int countCartItem() {
		int amount = orderItemMap.size();
		return amount;
	}
	
	
	public Map<String, OrderItem> getOrderItemMap() {
		return orderItemMap;
	}

	public void setOrderItemMap(Map<String, OrderItem> orderItemMap) {
		this.orderItemMap = orderItemMap;
	}
	
	
}
