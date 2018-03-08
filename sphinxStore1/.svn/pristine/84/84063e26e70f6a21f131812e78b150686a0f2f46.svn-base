package com.sphinx.beautea.order.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.beautea.order.dao.OrderItemDao;
import com.sphinx.beautea.order.domain.OrderItem;
import com.sphinx.beautea.product.domain.Product;

@Repository("OrderItemDao")
public class OrderItemDaojdbcImpl implements OrderItemDao {
	@Autowired
	private JdbcTemplate jdbcTemplete;
	
	//잘.. 모르겠숴요..
	
	
	@Override
	public void addOrderItem(OrderItem orderItem, String orderId) {
		String sql = "insert into OrderItem (id, quantity, productId, state, "
				+ "orderId) values (?, ?, ?, ?, ?)";
		jdbcTemplete.update(sql, new Object[] {orderItem.getOrderItemId(), orderItem.getQuantity(), 
				orderItem.getProduct().getProductId(), orderItem.getState(), 
				orderId});
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		String sql = "update OrderItem set quantity = ?, productId = ?, state = ? "
				+ "where id = ?";
		jdbcTemplete.update(sql, new Object[] {orderItem.getQuantity(), 
				orderItem.getProduct().getProductId(), orderItem.getState(), 
				orderItem.getOrderItemId()});
	}

	@Override
	public void deleteOrderItem(OrderItem orderItem) {
		String sql = "delete from OrderItem where id = ?";
		jdbcTemplete.update(sql, new Object[] {orderItem.getOrderItemId()});
	}

	@Override
	public OrderItem findOrderItemByOrderItemId(String orderItemId) {
		String sql = "select id, quantity, productId, state, orderId "
				+ "from OrderItem where id = ?";
		return jdbcTemplete.queryForObject(sql, new RowMapper<OrderItem>() {

			@Override
			public OrderItem mapRow(ResultSet rs, int arg1)
					throws SQLException {
				OrderItem orderItem = new OrderItem();
				orderItem.setOrderItemId(orderItemId);
				orderItem.setQuantity(rs.getInt(2));
				Product product = new Product();
				product.setProductId(rs.getString(3));
				orderItem.setProduct(product); 
				orderItem.setState(rs.getString(4));
				return orderItem;
			}
			
		}, orderItemId);
	}

	@Override
	public List<OrderItem> findOrderItemListByOrderId(String orderId) {
		String sql = "select id, quantity, productId, state, orderId "
				+ "from OrderItem where orderId = ?";
		return jdbcTemplete.query(sql, new RowMapper<OrderItem>() {

			@Override
			public OrderItem mapRow(ResultSet rs, int arg1)
					throws SQLException {
				OrderItem orderItem = new OrderItem();
				orderItem.setOrderItemId(rs.getString(1));
				orderItem.setQuantity(rs.getInt(2));
				Product product = new Product();
				product.setProductId(rs.getString(3));
				orderItem.setProduct(product); 
				orderItem.setState(rs.getString(4));
				return orderItem;
			}
			
		}, orderId);
	}

}
