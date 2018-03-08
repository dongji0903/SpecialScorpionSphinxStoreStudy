package com.sphinx.beautea.order.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.beautea.common.domain.PageUtil;
import com.sphinx.beautea.order.dao.OrderDao;
import com.sphinx.beautea.order.domain.Order;
import com.sphinx.beautea.order.domain.OrderItem;
import com.sphinx.beautea.order.service.OrderItemService;
import com.sphinx.beautea.order.service.OrderService;
import com.sphinx.beautea.product.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItemService orderItemService;
	@Autowired
	ProductService productService;
	
	@Override
	public String addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderDao.addOrder(order);
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		orderDao.updateOrder(order);
	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub
		orderDao.deleteOrder(order);
	}

	@Override
	public Order getOrderById(String orderId) {
		// TODO Auto-generated method stub
		Order order =  orderDao.findOrderById(orderId);
		setOrderItem(order);
		
		return order;
	}

	@Override
	public List<Order> getOrderListByCustomerId(int page, String customerId) {
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		int start = amount * (page - 1);
		List<Order> order_list =  orderDao.findOrderListByCustomerId(start, amount, customerId);
		
		for (Order order : order_list) {
			setOrderItem(order);
		}
		
		return order_list;
	}

	@Override
	public List<Order> getOrderListByDate(Date startDate, Date endDate,
			int page) {
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		int start = amount * (page - 1);
		List<Order> order_list = orderDao.findOrderListByDate(startDate, endDate, start, amount);
		
		for (Order order : order_list) {
			setOrderItem(order);
		}
		
		return order_list;
	}

	@Override
	public int countOrderByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return orderDao.countOrderByCustomerId(customerId);
	}

	@Override
	public int countOrderByDate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return orderDao.countOrderByDate(startDate, endDate);
	}

	@Override
	public List<Order> getOrderListByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		List<Order> order_list = orderDao.findOrderListByCustomerId(customerId);
		
		for (Order order : order_list) {
			setOrderItem(order);
		}
		
		return order_list;
	}

	@Override
	public double sumTotalPricePurchased(String customerId) {
		// TODO Auto-generated method stub
		return orderDao.sumTotalPricePurchased(customerId);
	}
	
	
	//Order에 orderItem을 셋팅함
	public void setOrderItem(Order order) {
		List<OrderItem> list = orderItemService.getOrderItemListByOrderId(order.getOrderId());
		for (OrderItem o : list) {
			String id = o.getProduct().getProductId();
			o.setProduct(productService.getProductById(id));
		}
		order.setOrderItemList(list);
	}

	@Override
	public List<Order> getOrderListByDate(String customerId, Date startDate,
			Date endDate, int page) {
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		int start = amount * (page - 1);
		
		List<Order> order_list = orderDao.findOrderListByDate(customerId, startDate, endDate, start, amount);
		
		for (Order order : order_list) {
			setOrderItem(order);
		}
		
		return order_list;
	}


}
