package com.sphinx.korigin.shopping.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.korigin.shopping.order.dao.OrderItemDao;
import com.sphinx.korigin.shopping.order.domain.OrderItem;
import com.sphinx.korigin.shopping.product.service.ProductService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private ProductService productService;

	@Override
	public void addOrderItem(OrderItem orderItem, String orderId) {
		orderItemDao.addOrderItem(orderItem, orderId);
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		orderItemDao.updateOrderItem(orderItem);
	}

	@Override
	public void deleteOrderItem(OrderItem orderItem) {
		orderItemDao.deleteOrderItem(orderItem);
	}

	@Override
	public OrderItem getOrderItemByOrderItemId(String orderItemId) {
		OrderItem orderItem= orderItemDao.getOrderItemByOrderItemId(orderItemId);
		orderItem.setProduct(productService.getProductById(orderItem.getProduct().getProductId()));
		return orderItem;
	}

	@Override
	public List<OrderItem> getOrderItemListByOrderId(String orderId) {
		List<OrderItem> orderItems = orderItemDao.getOrderItemListByOrderId(orderId);
		for(OrderItem orderItem : orderItems) {
			orderItem.setProduct(productService.getProductById(orderItem.getProduct().getProductId()));
		}
		return orderItems;
	}

}
