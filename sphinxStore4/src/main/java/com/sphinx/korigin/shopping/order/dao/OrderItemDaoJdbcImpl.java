package com.sphinx.korigin.shopping.order.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.shopping.order.domain.OrderItem;
import com.sphinx.korigin.shopping.product.domain.Product;
@Repository
public class OrderItemDaoJdbcImpl extends AbstractDaoJdbc
		implements OrderItemDao {
	@Override
	public void addOrderItem(OrderItem orderItem, String orderId) {
		String sql="insert into orderItem(orderItem_Id,order_Id,product_Id,quantity)"
				+ " values(?, ?, ?, ?)";
		if(jdbcTemplate.update(sql, new Object[] {
				generateID("orderItem", "orderItem_Id", "OI"),
				orderId,
				orderItem.getProduct().getProductId(),
				orderItem.getQuantity()
		})==0) {
			throw new RuntimeException("OrderItem 추가 실패");
		}
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		String sql="update orderItem set product_Id=?,quantity=?,del=?"
				+ " where orderItem_Id=?";
		if(jdbcTemplate.update(sql, new Object[] {
				orderItem.getProduct().getProductId(),
				orderItem.getQuantity(),
				orderItem.getState(),
				orderItem.getOrderItemId()
		})==0) {
			throw new NullPointerException("OrderItem을 못찾음");
		}
	}

	@Override
	public void deleteOrderItem(OrderItem orderItem) {
		String sql="delete from orderItem"
				+ " where orderItem_Id=?";
		if(jdbcTemplate.update(sql, orderItem.getOrderItemId())==0) {
			throw new NullPointerException("OrderItem을 못찾음");
		}
	}

	@Override
	public OrderItem getOrderItemByOrderItemId(String orderItemId) {
		String sql="select orderItem_Id,product_Id,quantity,del"
				+ " from orderItem"
				+ " where orderItem_Id=?";
		try {
			return jdbcTemplate.queryForObject(sql, new RowMapper<OrderItem>() {

				@Override
				public OrderItem mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					OrderItem orderItem = new OrderItem();
					orderItem.setOrderItemId(orderItemId);
					orderItem.setProduct(new Product(rs.getString("product_Id")));
					orderItem.setQuantity(rs.getInt("quantity"));
					orderItem.setState(rs.getString("del"));
					return orderItem;
				}
			},orderItemId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<OrderItem> getOrderItemListByOrderId(String orderId) {
		String sql="select orderItem_Id,product_Id,quantity,del"
				+ " from orderItem"
				+ " where order_Id=?";
		
			List<OrderItem> orderItems= jdbcTemplate.query(sql, new RowMapper<OrderItem>() {

				@Override
				public OrderItem mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					OrderItem orderItem = new OrderItem();
					orderItem.setOrderItemId(rs.getString("orderItem_Id"));
					orderItem.setProduct(new Product(rs.getString("product_Id")));
					orderItem.setQuantity(rs.getInt("quantity"));
					orderItem.setState(rs.getString("del"));
					return orderItem;
				}
			},orderId);
			
			if(orderItems==null || orderItems.isEmpty()) {
				return null;
			}else {
				return orderItems;
			}
		
	}

}
