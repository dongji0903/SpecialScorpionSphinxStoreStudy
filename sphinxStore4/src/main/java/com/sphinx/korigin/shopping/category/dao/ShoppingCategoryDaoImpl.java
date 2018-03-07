package com.sphinx.korigin.shopping.category.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.shopping.category.domain.ShoppingCategory;

@Repository("ShoppingCategoryDao")
public class ShoppingCategoryDaoImpl extends AbstractDaoJdbc implements ShoppingCategoryDao {

	@Override
	public String insertCategoy(ShoppingCategory category) {
		String sql = "insert into Category(category_id, category_name, super_id)"
				+ " values(?, ?, ?)";
		String id = generateID("Category", "category_id", "CAT");
		jdbcTemplate.update(sql, new Object[] { id, category.getCategoryName(),
				category.getSuperId() });
		return id;
	}

	@Override
	public void removeCategoy(ShoppingCategory category) {
		String sql = "delete from Category where category_name = ?";
		jdbcTemplate.update(sql, category.getCategoryName());
	}

	@Override
	public void updateCategoy(ShoppingCategory category) {
		String sql = "update Category set category_name = ?, super_id = ?"
				+ " where category_id = ?";
		jdbcTemplate.update(sql, new Object[] { category.getCategoryName(),
				category.getSuperId(), category.getCategoryId() });
	}

	@Override
	public List<ShoppingCategory> selectAllCategoryList() {
		String sql = "select category_id, category_name, super_id"
				+ " from Category";
		return jdbcTemplate.query(sql, new RowMapper<ShoppingCategory>() {
			@Override
			public ShoppingCategory mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				ShoppingCategory category = new ShoppingCategory();
				category.setCategoryId(rs.getString("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				category.setSuperId(rs.getString("super_id"));
				return category;
			}
		});
	}

	@Override
	public ShoppingCategory selectCategoryByName(String categoryName) {
		String sql = "select category_id, category_name, super_id"
				+ " from Category where category_name = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<ShoppingCategory>() {

			@Override
			public ShoppingCategory mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				ShoppingCategory category = new ShoppingCategory();
				category.setCategoryId(rs.getString("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				category.setSuperId(rs.getString("super_id"));
				return category;
			}
		}, categoryName);
	}

	@Override
	public ShoppingCategory selectCategoryById(String categoryId) {
		String sql = "select category_id, category_name, super_id"
				+ " from Category where category_id = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<ShoppingCategory>() {

			@Override
			public ShoppingCategory mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				ShoppingCategory category = new ShoppingCategory();
				category.setCategoryId(rs.getString("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				category.setSuperId(rs.getString("super_id"));
				return category;
			}
		}, categoryId);
	}
	/**
	 * 하위 카테고리에 대한 정보 없음
	 */
	@Override
	public List<ShoppingCategory> selectRootCategoryList() {
		String sql = "select category_id, category_name, super_id"
				+ " from Category where super_id is null";
		return jdbcTemplate.query(sql, new RowMapper<ShoppingCategory>() {
			@Override
			public ShoppingCategory mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				ShoppingCategory category = new ShoppingCategory();
				category.setCategoryId(rs.getString("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				category.setSuperId(rs.getString("super_id"));
				return category;
			}
		});
	}

	@Override
	public List<ShoppingCategory> selectCategoryListByParentId(String superId) {
		String sql = "select category_id, category_name, super_id"
				+ " from Category where super_id = ?";
		return jdbcTemplate.query(sql, new RowMapper<ShoppingCategory>() {
			@Override
			public ShoppingCategory mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				ShoppingCategory category = new ShoppingCategory();
				category.setCategoryId(rs.getString("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				category.setSuperId(rs.getString("super_id"));
				return category;
			}
		}, superId);
	}

}
