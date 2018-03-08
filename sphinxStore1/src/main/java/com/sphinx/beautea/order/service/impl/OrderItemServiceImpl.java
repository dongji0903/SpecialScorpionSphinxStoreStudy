package com.sphinx.beautea.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.beautea.order.dao.OrderItemDao;
import com.sphinx.beautea.order.domain.OrderItem;
import com.sphinx.beautea.order.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	OrderItemDao orderItemDao;
	
	@Override
	public void addOrderItem(OrderItem orderItem, String orderId) {
		// TODO Auto-generated method stub
		orderItemDao.addOrderItem(orderItem, orderId);
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		orderItemDao.updateOrderItem(orderItem);
	}

	@Override
	public void deleteOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		orderItemDao.deleteOrderItem(orderItem);
	}

	@Override
	public OrderItem getOrderItemByOrderItemId(String orderItemId) {
		// TODO Auto-generated method stub
		return orderItemDao.findOrderItemByOrderItemId(orderItemId);
	}

	@Override
	public List<OrderItem> getOrderItemListByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderItemDao.findOrderItemListByOrderId(orderId);
	}


}
