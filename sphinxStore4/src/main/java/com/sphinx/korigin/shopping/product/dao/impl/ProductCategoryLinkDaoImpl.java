package com.sphinx.korigin.shopping.product.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.shopping.product.dao.ProductCategoryLinkDao;

@Repository("ProductCategoryLinkDao")
public class ProductCategoryLinkDaoImpl extends AbstractDaoJdbc
		implements ProductCategoryLinkDao {

	@Override
	public void insertLink(String productId, String categoryId) {
		String sql = "insert into Product_Category_Link(category_id, product_id) "
				+ "values(?, ?)";
		jdbcTemplate.update(sql, new Object[] { categoryId, productId });
	}

	@Override
	public List<String> selectProductIdsByCategoryId(String... categoryId) {
		List<String> productIds = new ArrayList<>();
		String sql = "select product_id from Product_Category_Link where category_id = ?";
		for(int i=1;i<categoryId.length;i++) {
			sql+=" or category_id = ?";
		}
		return jdbcTemplate.query(sql, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String productId = rs.getString("product_id");
				return productId;
			}
		}, categoryId);
	}

	@Override
	public List<String> selectCategoryIdsByProductId(String productId) {
		String sql = "select category_id from Product_Category_Link where product_id = ?";
		return jdbcTemplate.query(sql, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String productId = rs.getString("category_id");
				return productId;
			}
		}, productId);
	}

}
