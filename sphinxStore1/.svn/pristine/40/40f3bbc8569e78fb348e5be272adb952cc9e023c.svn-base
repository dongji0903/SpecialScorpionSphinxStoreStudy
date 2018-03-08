package com.sphinx.beautea.product.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.beautea.common.primary.CreatePrimary;
import com.sphinx.beautea.product.dao.ProductDao;
import com.sphinx.beautea.product.domain.Product;

@Repository("ProductDao")
public class ProductDaojdbcImpl implements ProductDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplete;
	
	@Override
	public String addProduct(Product product) {
		String sql = "insert into Product (id, name, price, content, filename, "
				+ "comment, del, regDate) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		CreatePrimary primary = CreatePrimary.getInstance();
		String id = "pr" + primary.createPrimaryKey();
		Date date = new java.sql.Date(product.getRegDate().getTime());
		
		String filename = null;
		
		for (String s : product.getFileName()) {
			if (filename == null) {
				filename = s;
			} else {
				filename += "/" + s;
			}
		}
		
		jdbcTemplete.update(sql, new Object[] {id, product.getProductName(), 
				product.getPrice(), product.getContent(), filename, 
				product.getComment(), false, date});
		
		return id;
	}

	
	
	
	@Override
	public void updateProduct(Product product) {
		String sql = "update Product set name = ?, price = ?, content = ?, "
				+ "filename = ?, comment = ?, del = ? where id = ?";
		
		jdbcTemplete.update(sql, new Object[] {product.getProductName(), 
				product.getPrice(), product.getContent(), product.getFileName(), 
				product.getComment(), product.isDel(), product.getProductId()});
	}

	
	
	
	@Override
	public void deleteProduct(Product product) {
		String sql = "delete from Product where id = ?";
		
		jdbcTemplete.update(sql, new Object[] {product.getProductId()});
	}

	
	
	
	@Override
	public Product findProductById(String productId) {
		String sql = "select id, name, price, content, filename, comment, del, regDate "
				+ "from Product where id = ?";
		return jdbcTemplete.queryForObject(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Product product = new Product();
				product.setProductId(productId);
				product.setProductName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setContent(rs.getString(4));
				List<String> filename = new ArrayList<>();
				for (String s : rs.getString(5).split("/")) {
					filename.add(s);
				}
				product.setFileName(filename);
				product.setComment(rs.getString(6));
				product.setDel(rs.getBoolean(7));
				product.setRegDate(rs.getDate(8));
				return product;
			}
			
		}, productId);
	}

	
	
	
	@Override
	public List<Product> findProductList(int start, int amount) {
		String sql = "select id, name, price, content, filename, comment, del, regDate "
				+ "from Product where del = ? "
				+ "ORDER BY ENTER_DATE DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		return jdbcTemplete.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Product product = new Product();
				product.setProductId(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setContent(rs.getString(4));
				List<String> filename = new ArrayList<>();
				for (String s : rs.getString(5).split("/")) {
					filename.add(s);
				}
				product.setFileName(filename);
				product.setComment(rs.getString(6));
				product.setDel(rs.getBoolean(7));
				product.setRegDate(rs.getDate(8));
				return product;
			}
			
		}, new Object[] {false, start, amount});
	}




	@Override
	public List<Product> searchProductListByKeyword(int start, int amount,
			String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	@Override
	public List<Product> findDeleteProduct(int start, int amount) {
		String sql = "select id, name, price, content, filename, comment, del, regDate "
				+ "from Product where del = ? "
				+ "ORDER BY ENTER_DATE DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		return jdbcTemplete.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1)
					throws SQLException {
				Product product = new Product();
				product.setProductId(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setContent(rs.getString(4));
				List<String> filename = new ArrayList<>();
				for (String s : rs.getString(5).split("/")) {
					filename.add(s);
				}
				product.setFileName(filename);
				product.setComment(rs.getString(6));
				product.setDel(rs.getBoolean(7));
				product.setRegDate(rs.getDate(8));
				return product;
			}
			
		}, new Object[] {true, start, amount});
	}

	
	
	
	public void setJdbcTemplete(JdbcTemplate jdbcTemplete) {
		this.jdbcTemplete = jdbcTemplete;
	}




	@Override
	public int countProduct(boolean del) {
		String sql = "select count(id) "
				+ "from Product where del = ? ";
		return jdbcTemplete.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				int count = rs.getInt(1);
				return count;
			}

		}, del);
	}




	@Override
	public List<Product> searchProductListByName(int start, int amount,
			String name) {
		
		name = "%"+name+"%";
		String sql = "SELECT id, name, price, content, filename, comment, del, regDate FROM Product "
				+ "WHERE NAME like ? AND DEL = ? order by id DESC "
				+ "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		
		return jdbcTemplete.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				Product product = new Product();
				product.setProductId(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setContent(rs.getString(4));
				List<String> filename = new ArrayList<>();
				for (String s : rs.getString(5).split("/")) {
					filename.add(s);
				}
				product.setFileName(filename);
				product.setComment(rs.getString(6));
				product.setDel(rs.getBoolean(7));
				product.setRegDate(rs.getDate(8));
				return product;
			}
			
		}, new Object[] {name, false, start, amount});
	}
	
}
