package com.sphinx.beautea.customer.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.beautea.common.domain.PageUtil;
import com.sphinx.beautea.common.primary.CreatePrimary;
import com.sphinx.beautea.customer.dao.CustomerDao;
import com.sphinx.beautea.customer.domain.Customer;

@Repository("CustomerDao")
public class CustomerDaojdbcImpl implements CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addCustomer(Customer customer) {

		String sql = "insert into Customer (id, admin, sphinxId, "
				+ "password, del, name, phoneNum, address, post, joinDate, "
				+ "birthday, email, points, level) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		CreatePrimary primary = CreatePrimary.getInstance();
		String id = "cu" + primary.createPrimaryKey();
		Date date = new java.sql.Date(customer.getJoinDate().getTime());
		jdbcTemplate.update(sql, new Object[] {id, false, 
				customer.getSphinxId(), customer.getPassword(), false, 
				customer.getName(), customer.getPhoneNum(), customer.getAddress(), 
				customer.getPost(), date, customer.getBirthday(), 
				customer.getEmail(), 0, 1});
		
	}

	
	
	
	@Override
	public void updateCustomer(Customer customer) {

		String sql = "update Customer set admin = ?, password = ?, del = ?, "
				+ "name = ?, phoneNum = ?, address = ?, post = ?, birthday = ?, "
				+ "email = ?, points = ?, level = ? where id = ?";
		
		jdbcTemplate.update(sql, new Object[] {customer.isAdmin(), 
				customer.getPassword(), customer.isDel(), customer.getName(), 
				customer.getPhoneNum(), customer.getAddress(), customer.getPost(), 
				customer.getBirthday(), customer.getEmail(), customer.getPoint(),
				customer.getLevel(), customer.getCustomerId()});
		
	}

	
	
	
	@Override
	public void deleteCustomer(Customer customer) {

		String sql = "delete from Customer where id = ?";
		
		jdbcTemplate.update(sql, new Object[] {customer.getCustomerId()});
	}


	
	
	@Override
	public Customer findCustomerById(String customerId) {

		String sql = "select id, admin, sphinxId, password, del, name, phoneNum, "
				+ "address, post, joinDate, birthday, email, points, level "
				+ "from Customer where id = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int arg1)
					throws SQLException {

				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				customer.setAdmin(rs.getBoolean(2));
				customer.setSphinxId(rs.getString(3));
				customer.setPassword(rs.getString(4));
				customer.setDel(rs.getBoolean(5));
				customer.setName(rs.getString(6));
				customer.setPhoneNum(rs.getString(7));
				customer.setAddress(rs.getString(8));
				customer.setPost(rs.getString(9));
				customer.setJoinDate(rs.getDate(10));
				customer.setBirthday(rs.getDate(11));
				customer.setEmail(rs.getString(12));
				customer.setPoint(rs.getInt(13));
				customer.setLevel(rs.getInt(14));
				return customer;
			}
			
		}, customerId);
	}

	
	
	
	@Override
	public List<Customer> findAllCustomerList(int page) {

		String sql = "select id, admin, sphinxId, password, del, name, phoneNum, "
				+ "address, post, joinDate, birthday, email, points, level "
				+ "from Customer where del = ? "
				+ "ORDER BY joinDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		
		return jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString(1));
				customer.setAdmin(rs.getBoolean(2));
				customer.setSphinxId(rs.getString(3));
				customer.setPassword(rs.getString(4));
				customer.setDel(rs.getBoolean(5));
				customer.setName(rs.getString(6));
				customer.setPhoneNum(rs.getString(7));
				customer.setAddress(rs.getString(8));
				customer.setPost(rs.getString(9));
				customer.setJoinDate(rs.getDate(10));
				customer.setBirthday(rs.getDate(11));
				customer.setEmail(rs.getString(12));
				customer.setPoint(rs.getInt(13));
				customer.setLevel(rs.getInt(14));
				return customer;
			}
			
		}, new Object[] {false, amount * (page - 1), amount});
	}

	
	
	
	@Override
	public List<Customer> findAdmin(int page) {

		String sql = "select id, admin, sphinxId, password, del, name, phoneNum, "
				+ "address, post, joinDate, birthday, email "
				+ "from Customer where admin = ? and del = ? "
				+ "ORDER BY joinDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		
		return jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString(1));
				customer.setAdmin(rs.getBoolean(2));
				customer.setSphinxId(rs.getString(3));
				customer.setPassword(rs.getString(4));
				customer.setDel(rs.getBoolean(5));
				customer.setName(rs.getString(6));
				customer.setPhoneNum(rs.getString(7));
				customer.setAddress(rs.getString(8));
				customer.setPost(rs.getString(9));
				customer.setJoinDate(rs.getDate(10));
				customer.setBirthday(rs.getDate(11));
				customer.setEmail(rs.getString(12));
				return customer;
			}
			
		}, new Object[] {true, false, amount * (page - 1), amount});
	}

	
	
	
	@Override
	public List<Customer> findCustomerByDel(int page) {
		String sql = "select id, admin, sphinxId, password, del, name, phoneNum, "
				+ "address, post, joinDate, birthday, email, points, level "
				+ "from Customer where del = ? "
				+ "ORDER BY joinDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		
		return jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString(1));
				customer.setAdmin(rs.getBoolean(2));
				customer.setSphinxId(rs.getString(3));
				customer.setPassword(rs.getString(4));
				customer.setDel(rs.getBoolean(5));
				customer.setName(rs.getString(6));
				customer.setPhoneNum(rs.getString(7));
				customer.setAddress(rs.getString(8));
				customer.setPost(rs.getString(9));
				customer.setJoinDate(rs.getDate(10));
				customer.setBirthday(rs.getDate(11));
				customer.setEmail(rs.getString(12));
				customer.setPoint(rs.getInt(13));
				customer.setLevel(rs.getInt(14));
				return customer;
			}
			
		}, new Object[] {true, amount * (page - 1), amount});
	}

	
	
	
	@Override
	public Customer findCustomerBySphinxId(String sphinxId) {

		String sql = "select id, admin, sphinxId, password, del, name, phoneNum, "
				+ "address, post, joinDate, birthday, email, points, level "
				+ "from Customer where sphinxId = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int arg1)
					throws SQLException {

				Customer customer = new Customer();
				customer.setCustomerId(rs.getString(1));
				customer.setAdmin(rs.getBoolean(2));
				customer.setSphinxId(sphinxId);
				customer.setPassword(rs.getString(4));
				customer.setDel(rs.getBoolean(5));
				customer.setName(rs.getString(6));
				customer.setPhoneNum(rs.getString(7));
				customer.setAddress(rs.getString(8));
				customer.setPost(rs.getString(9));
				customer.setJoinDate(rs.getDate(10));
				customer.setBirthday(rs.getDate(11));
				customer.setEmail(rs.getString(12));
				customer.setPoint(rs.getInt(13));
				customer.setLevel(rs.getInt(14));
				return customer;
			}
			
		}, sphinxId);
	}

	
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}




	@Override
	public int countCustomer(boolean del) {

		String sql = "select count(id) from Customer where del = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				int amount = rs.getInt(1);
				return amount;
			}

		}, del);
	}




	@Override
	public int countAdmin() {
		String sql = "select count(id) from Customer where admin = true and del = false";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				int amount = rs.getInt(1);
				return amount;
			}

		});
	}




	@Override
	public boolean idcheck(String sphinxId) {
		String sql = "select count(id) from Customer where sphinxId = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Boolean>() {

			@Override
			public Boolean mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				int count = rs.getInt(1);
				boolean check = false;
				if(count > 0) {
					check = true;
				}
				return check;
			}
		}, sphinxId);
	}

	
}
