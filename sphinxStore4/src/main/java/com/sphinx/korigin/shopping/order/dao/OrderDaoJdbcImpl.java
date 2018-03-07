package com.sphinx.korigin.shopping.order.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.shopping.order.domain.Order;

@Repository
public class OrderDaoJdbcImpl extends AbstractDaoJdbc implements OrderDao {

	@Override
	public String addOrder(Order order) {
		String sql = "insert into orders"
				+ "(order_id,customer_id,recipient,recipient_addr,memo,total_Price,order_Date,state)"
				+ " values(?,?,?,?,?,?,?,?)";
		String id = generateID("orders", "order_id", "OD");
		try {
			jdbcTemplate.update(sql,
					new Object[] { id, order.getCustomerId(),
							order.getRecipient(), order.getRecipientAddr(),
							order.getMemo(), order.getTotalPrice(),
							order.getOrderDate(), order.getState() });
			return id;
		} catch (DataAccessException e) {
			return null;
		}
	}

	@Override
	public void updateOrder(Order order) {
		String sql = "update orders set  "
				+ " customer_id=?,recipient=?,recipient_addr=?,memo=?,total_Price=?,order_Date=?,state=?,del=?"
				+ " where order_id=?";
		if (jdbcTemplate.update(sql, new Object[] { order.getCustomerId(),
				order.getRecipient(), order.getRecipientAddr(), order.getMemo(),
				order.getTotalPrice(), order.getOrderDate(), order.getState(),
				order.getDel(), order.getOrderId() }) == 0) {
			throw new NullPointerException();
		}
	}

	@Override
	public void deleteOrder(Order order) {
		String sql = "delete from orders where order_id=?";
		if (jdbcTemplate.update(sql, order.getOrderId()) == 0) {
			throw new NullPointerException();
		}
	}

	@Override
	public Order getOrderById(String orderId) {
		String sql = "select customer_id,recipient,recipient_addr,memo,total_Price,order_Date,state,del"
				+ " from orders where order_id=?";
		try {
			return jdbcTemplate.queryForObject(sql, new RowMapper<Order>() {

				@Override
				public Order mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Order order = new Order();
					order.setOrderId(orderId);
					order.setCustomerId(rs.getString("customer_id"));
					order.setDel(rs.getBoolean("del"));
					order.setMemo(rs.getString("memo"));
					order.setOrderDate(rs.getDate("order_date"));
					order.setRecipient(rs.getString("recipient"));
					order.setRecipientAddr(rs.getString("recipient_addr"));
					order.setState(rs.getString("state"));
					order.setTotalPrice(rs.getDouble("total_price"));

					return order;
				}

			}, orderId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Order> getOrderByDate(Date startDate, Date endDate, int start,
			int amount) {
		String sql = "select order_id,customer_id,recipient,recipient_addr,memo,total_Price,order_Date,state,del"
				+ " from orders where order_Date>=? and order_Date<=?"
				+ " order by order_Date desc offset ? rows fetch next ? rows only";
		List<Order> orders = jdbcTemplate.query(sql,
				new Object[] { startDate, endDate, start, amount },
				new RowMapper<Order>() {

					@Override
					public Order mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Order order = new Order();
						order.setOrderId(rs.getString("order_id"));
						order.setCustomerId(rs.getString("customer_Id"));
						order.setDel(rs.getBoolean("del"));
						order.setMemo(rs.getString("memo"));
						order.setOrderDate(rs.getDate("order_date"));
						order.setRecipient(rs.getString("recipient"));
						order.setRecipientAddr(rs.getString("recipient_addr"));
						order.setState(rs.getString("state"));
						order.setTotalPrice(rs.getDouble("total_price"));
						return order;
					}

				});
		if (orders == null || orders.isEmpty()) {
			throw new NullPointerException();
		} else {
			return orders;
		}
	}

	@Override
	public List<Order> getOrderByCustomerId(Date startDate, Date endDate,
			String customerId, int start, int amount) {
		String sql = "select order_id,recipient,recipient_addr,memo,total_Price,order_Date,state,del"
				+ " from orders where customer_id=? and order_Date>=? and order_Date<=?"
				+ " order by order_Date desc offset ? rows fetch next ? rows only";

		List<Order> orders = jdbcTemplate.query(sql,
				new Object[] { customerId, startDate, endDate, start, amount },
				new RowMapper<Order>() {

					@Override
					public Order mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Order order = new Order();
						order.setOrderId(rs.getString("order_id"));
						order.setCustomerId(customerId);
						order.setDel(rs.getBoolean("del"));
						order.setMemo(rs.getString("memo"));
						order.setOrderDate(rs.getDate("order_date"));
						order.setRecipient(rs.getString("recipient"));
						order.setRecipientAddr(rs.getString("recipient_addr"));
						order.setState(rs.getString("state"));
						order.setTotalPrice(rs.getDouble("total_price"));
						return order;
					}

				});
		if (orders == null || orders.isEmpty()) {
			throw new NullPointerException();
		} else {
			return orders;
		}
	}

	public static void main(String[] args) {
		String config = "com/sphinx/korigin/order/dao/mytest.xml";
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				config);
		OrderDaoJdbcImpl sdo = new OrderDaoJdbcImpl();
		sdo.setJdbcTemplate(
				context.getBean("jdbcTemplate", JdbcTemplate.class));

		System.out.println(sdo.getOrderByDate(new Date(118, 1, 10),
				new Date(118, 1, 20), 0, 20));

	}
}
