package com.sphinx.korigin.shopping.order.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sphinx.korigin.shopping.order.dao.OrderDao;
import com.sphinx.korigin.shopping.order.dao.OrderDaoJdbcImpl;
import com.sphinx.korigin.shopping.order.domain.Order;
import com.sphinx.korigin.shopping.order.domain.OrderItem;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderItemService orderItemService;
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public String addOrder(Order order) {
		for(OrderItem orderItem : order.getOrderItemList()) {
			orderItemService.addOrderItem(orderItem, order.getOrderId());
		}
		return orderDao.addOrder(order);
	}

	@Override
	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
	}

	@Override
	public void deleteOrder(Order order) {
		for(OrderItem orderItem : order.getOrderItemList()) {
			orderItemService.deleteOrderItem(orderItem);
		}
		orderDao.deleteOrder(order);
	}

	@Override
	public Order getOrderById(String orderId) {
		Order order= orderDao.getOrderById(orderId);
		order.setOrderItemList(orderItemService.getOrderItemListByOrderId(orderId));
		return order;
	}

	@Override
	public List<Order> getOrderByDate(Date startDate, Date endDate, int start,
			int amount) {
		List<Order> orders=orderDao.getOrderByDate(startDate, endDate, start, amount);
		for(Order order:orders) {
			order.setOrderItemList(orderItemService.getOrderItemListByOrderId(order.getOrderId()));
		}
		return orders;
	}

	@Override
	public List<Order> getOrderByCustomerId(Date startDate, Date endDate,
			String customerId, int start, int amount) {
		List<Order> orders=orderDao.getOrderByCustomerId(startDate, endDate, customerId, start, amount);
		for(Order order:orders) {
			order.setOrderItemList(orderItemService.getOrderItemListByOrderId(order.getOrderId()));
		}
		return orders;
	}

	
	public static void main(String[] args) {
		String config = "com/sphinx/korigin/order/service/serviceTest.xml";
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				config);
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		OrderDaoJdbcImpl orderDaoJdbcImpl=new OrderDaoJdbcImpl();
		orderDaoJdbcImpl.setJdbcTemplate(context.getBean("jdbcTemplate", JdbcTemplate.class));
		orderServiceImpl.setOrderDao(orderDaoJdbcImpl);
		Order order= new Order();
		order.setCustomerId("billy");
		orderServiceImpl.addOrder(order);
		order.setCustomerId("mother");
		order.setOrderId("OD000001");
		orderServiceImpl.updateOrder(order);
	}

}
