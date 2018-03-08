package com.sphinx.beautea.order.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.beautea.common.primary.CreatePrimary;
import com.sphinx.beautea.order.dao.OrderDao;
import com.sphinx.beautea.order.domain.Order;

@Repository("OrderDao")
public class OrderDaojdbcImpl implements OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplete;
	
	@Override
	public String addOrder(Order order) {
		String sql = "insert into Orders (id, customerId, orderDate, state, del, "
				+ "totalPrice, recipient, recipientAddr, memo) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		CreatePrimary primary = CreatePrimary.getInstance();
		String id = "or" + primary.createPrimaryKey();
		Date date = new java.sql.Date(order.getOrderDate().getTime());
		
		jdbcTemplete.update(sql, new Object[] {id, order.getCustomerId(), 
				date, order.getState(), false, order.getTotalPrice(), 
				order.getRecipient(), order.getRecipientAddr(), order.getMemo()});
		return id;
	}

	
	
	
	@Override
	public void updateOrder(Order order) {
		String sql = "update Orders set customerId = ?, state = ?, del = ?, "
				+ "totalPrice = ?, recipient = ?, recipientAddr = ?, memo = ? "
				+ "where id = ?";
		jdbcTemplete.update(sql, new Object[] {order.getCustomerId(), 
				order.getState(), order.isDel(), order.getTotalPrice(), 
				order.getRecipient(), order.getRecipientAddr(), order.getMemo(), 
				order.getOrderId()});
	}

	
	
	
	@Override
	public void deleteOrder(Order order) {
		String sql = "delete from Orders where id = ?";
		jdbcTemplete.update(sql, new Object[] {order.getOrderId()});
	}

	
	
	
	@Override
	public Order findOrderById(String orderId) {
		String sql = "select id, customerId, orderDate, state, del, totalPrice, recipient, recipientAddr, memo "
				+ "from Orders where id = ?";
		return jdbcTemplete.queryForObject(sql, new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int arg1) throws SQLException {
				Order order = new Order();
				order.setOrderId(orderId);
				order.setCustomerId(rs.getString(2));
				order.setOrderDate(rs.getDate(3));
				order.setState(rs.getString(4));
				order.setDel(rs.getBoolean(5));
				order.setTotalPrice(rs.getDouble(6));
				order.setRecipient(rs.getString(7));
				order.setRecipientAddr(rs.getString(8));
				order.setMemo(rs.getString(9));
				return order;
			}
			
		}, orderId);
	}

	
	
	
	@Override
	public List<Order> findOrderListByCustomerId(int start, int amount,
			String customerId) {
		String sql = "select id, customerId, orderDate, state, del, totalPrice, recipient, recipientAddr, memo "
				+ "from Orders "
				+ "where customerId = ? and del = ? "
				+ "ORDER BY orderDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		return jdbcTemplete.query(sql, new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int arg1) throws SQLException {
				Order order = new Order();
				order.setOrderId(rs.getString(1));
				order.setCustomerId(customerId);
				order.setOrderDate(rs.getDate(3));
				order.setState(rs.getString(4));
				order.setDel(rs.getBoolean(5));
				order.setTotalPrice(rs.getDouble(6));
				order.setRecipient(rs.getString(7));
				order.setRecipientAddr(rs.getString(8));
				order.setMemo(rs.getString(9));
				return order;
			}
			
		}, new Object[] {customerId, false, start, amount});
	}

	
	
	//이거 모르겠어욤
	@Override
	public List<Order> findOrderListByDate(Date startDate, Date endDate,
			int start, int amount) {
		String sql = "select id, customerId, orderDate, state, del, totalPrice, "
				+ "recipient, recipientAddr, memo from Orders "
				+ "where orderDate >= ? and orderDate <= ? and del = ? "
				+ "ORDER BY orderDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		//잘 모르겠어용...
		return jdbcTemplete.query(sql, new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int arg1) throws SQLException {
				Order order = new Order();
				order.setOrderId(rs.getString(1));
				order.setCustomerId(rs.getString(2));
				order.setOrderDate(rs.getDate(3));
				order.setState(rs.getString(4));
				order.setDel(rs.getBoolean(5));
				order.setTotalPrice(rs.getDouble(6));
				order.setRecipient(rs.getString(7));
				order.setRecipientAddr(rs.getString(8));
				order.setMemo(rs.getString(9));
				return order;
			}
			
		}, new Object[] {startDate, endDate, false, start, amount});
		
	}

	
	
	
	@Override
	public int countOrderByCustomerId(String customerId) {
		String sql = "select count(id) from Orders where customerId = ?";
		return jdbcTemplete.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
				int count = rs.getInt(1);
				return count;
			}
			
		}, customerId);
	}

	
	
	//이것도 잘 모르겠다
	@Override
	public int countOrderByDate(Date startDate, Date endDate) {
		String sql = "select count(id) from Orders "
				+ "where orderDate >= ? and orderDate <= ?";
		return jdbcTemplete.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				int count = rs.getInt(1);
				return count;
			}
			
		}, new Object[] {startDate, endDate});
	}

	
	
	
	@Override
	public List<Order> findOrderListByCustomerId(String customerId) {
		String sql = "select id, customerId, orderDate, state, del, totalPrice, "
				+ "recipient, recipientAddr, memo from Orders "
				+ "where customerId = ? and del = false";
		return jdbcTemplete.query(sql, new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int arg1) throws SQLException {
				Order order = new Order();
				order.setOrderId(rs.getString(1));
				order.setCustomerId(customerId);
				order.setOrderDate(rs.getDate(3));
				order.setState(rs.getString(4));
				order.setDel(rs.getBoolean(5));
				order.setTotalPrice(rs.getDouble(6));
				order.setRecipient(rs.getString(7));
				order.setRecipientAddr(rs.getString(8));
				order.setMemo(rs.getString(9));
				return order;
			}
			 
		}, customerId);
	}




	@Override
	public double sumTotalPricePurchased(String customerId) {
		String sql = "select sum(totalPrice) from Orders where customerId = ?";
		return jdbcTemplete.queryForObject(sql, new RowMapper<Double>() {

			@Override
			public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
				double price = rs.getDouble(1);
				return price;
			}
		}, customerId);
	}




	@Override
	public List<Order> findOrderListByDate(String customerId, Date startDate,
			Date endDate, int start, int amount) {
		String sql = "select id, customerId, orderDate, state, del, totalPrice, "
				+ "recipient, recipientAddr, memo from Orders "
				+ "where orderDate >= ? and orderDate <= ? and del = ? and customerId = ? "
				+ "ORDER BY orderDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		//잘 모르겠어용...
		return jdbcTemplete.query(sql, new RowMapper<Order>() {

			@Override
			public Order mapRow(ResultSet rs, int arg1) throws SQLException {
				Order order = new Order();
				order.setOrderId(rs.getString(1));
				order.setCustomerId(rs.getString(2));
				order.setOrderDate(rs.getDate(3));
				order.setState(rs.getString(4));
				order.setDel(rs.getBoolean(5));
				order.setTotalPrice(rs.getDouble(6));
				order.setRecipient(rs.getString(7));
				order.setRecipientAddr(rs.getString(8));
				order.setMemo(rs.getString(9));
				return order;
			}
			
		}, new Object[] {startDate, endDate, false, customerId, start, amount});
	}

	
	
	
}
