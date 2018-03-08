package com.sphinx.beautea.order.domain;


import com.sphinx.beautea.product.domain.Option;
import com.sphinx.beautea.product.domain.Product;

public class OrderItem {

	private String orderItemId;
	private int quantity;
	private Product product;
	private String state; //반품, 교환, 취소 등등

	
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public double getPrice() {
		Double price = this.product.getPrice();
		for(Option option : product.getOptionList()) {
			for (String key : option.getOptionValueMap().keySet()) {
				price += option.getOptionValueMap().get(key);
			}
		}
		
		return price * this.quantity;
		
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
