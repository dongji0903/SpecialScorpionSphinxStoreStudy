package com.sphinx.korigin.shopping.product.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.shopping.product.dao.ProductDao;
import com.sphinx.korigin.shopping.product.domain.Product;

@Repository("ProductDao")
public class ProductDaoImpl extends AbstractDaoJdbc implements ProductDao {

	@Override
	public String insertProduct(Product product) {
		String sql = "insert into Product(product_id, product_name, price, file_name,"
				+ " content, comment, regDate) values(?, ?, ?, ?, ?, ?, ?)";
		String id = generateID("Product", "product_id", "PRODUCT");
		jdbcTemplate.update(sql,
				new Object[] { id, product.getProductName(), product.getPrice(),
						product.getFileName().toString(), product.getContent(),
						product.getComment(), product.getRegDate() });
		return id;
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "update Category set product_name = ?, price = ?,"
				+ " file_name = ?, content = ?, comment = ?, regDate = ?"
				+ " where product_id = ?";
		jdbcTemplate.update(sql,
				new Object[] { product.getProductName(), product.getPrice(),
						product.getFileName(), product.getContent(),
						product.getComment(), product.getRegDate() },
				product.getProductId());
	}

	@Override
	public void removeProduct(Product product) {
		String sql = "delete from Product where product_id = ?";
		jdbcTemplate.update(sql, product.getProductId());
	}

	@Override
	public Product selectProductById(String productId) {
		String sql = "select product_id, product_name, price, file_name, "
				+ "content, comment, regDate from Product where product_id = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Product product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getDouble("price"));
				/* product.setFileName(rs.getString("file_name")); */
				product.setContent(rs.getString("content"));
				product.setComment(rs.getString("comment"));
				product.setRegDate(rs.getDate("regDate"));
				return product;
			}
		}, productId);
	}

	@Override
	public Product selectProductByName(String productName) {
		String sql = "select product_id, product_name, price, file_name, "
				+ "content, comment, regDate from Product where product_name = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Product product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getDouble("price"));
				/* product.setFileName(rs.getString("file_name")); */
				product.setContent(rs.getString("content"));
				product.setComment(rs.getString("comment"));
				product.setRegDate(rs.getDate("regDate"));
				return product;
			}
		}, productName);
	}

	@Override
	public List<Product> selectProductList(int start, int amount) {
		return null;
	}

	@Override
	public List<Product> selectProductListByKeyword(int start, int amount,
			String keyword) {
		String sql = "select product_id, product_name, price, file_name, "
				+ "content, comment, regDate from Product order by regDate desc "
				+ " offset ? rows fetch next ? rows only"
				+ " where product_name like %?%";
		return jdbcTemplate.query(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Product product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getDouble("price"));
				/* product.setFileName(rs.getString("file_name")); */
				product.setContent(rs.getString("content"));
				product.setComment(rs.getString("comment"));
				product.setRegDate(rs.getDate("regDate"));
				return product;
			}
		}, keyword);
	}

	@Override
	public List<Product> selectProductListByCategoryId(int start, int amount,
			String... productId) {
		String sql = "select product_id, product_name, price, file_name, "
				+ "content, comment, regDate from Product ";
		Object[] args = new Object[productId.length + 2];
		for (int i = 0; i < productId.length; i++) {
			if (i > 0) {
				sql += " or product_id = ?";
			} else {
				sql += " where product_id = ?";
			}
			args[i] = productId[i];
		}
		args[args.length - 2] = start;
		args[args.length - 1] = amount;
		for (Object o : args) {
			System.out.println(o);
		}
		sql += " order by regDate desc offset ? rows fetch next ? rows only ";
		System.out.println(sql);
		return jdbcTemplate.query(sql, args, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Product product = new Product();
				product.setProductId(rs.getString("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getDouble("price"));
				/* product.setFileName(rs.getString("file_name")); */
				product.setContent(rs.getString("content"));
				product.setComment(rs.getString("comment"));
				product.setRegDate(rs.getDate("regDate"));
				return product;
			}
		});
	}

}
