package com.sphinx.korigin.shopping.order.domain;

import java.util.Date;
import java.util.List;

public class Order {
	private String orderId;
	private List<OrderItem> orderItemList;
	private String customerId;
	private String recipient;
	private String recipientAddr;
	private String memo;
	private double totalPrice;
	private Date orderDate;
	private String state;
	private boolean del;
	
	

	public Order(String orderId) {
		super();
		this.orderId = orderId;
	}


	public Order() {
		super();
	}


	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipientAddr() {
		return recipientAddr;
	}

	public void setRecipientAddr(String recipientAddr) {
		this.recipientAddr = recipientAddr;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean getDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderItemList=" + orderItemList
				+ ", customerId=" + customerId + ", recipient=" + recipient
				+ ", recipientAddr=" + recipientAddr + ", memo=" + memo
				+ ", totalPrice=" + totalPrice + ", orderDate=" + orderDate
				+ ", state=" + state + ", del=" + del + "]";
	}

}
