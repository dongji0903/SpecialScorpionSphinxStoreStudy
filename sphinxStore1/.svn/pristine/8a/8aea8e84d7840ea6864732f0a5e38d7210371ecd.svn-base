package com.sphinx.beautea.category.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.beautea.category.common.MiniComparator;
import com.sphinx.beautea.category.dao.CategoryDao;
import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.common.primary.CreatePrimary;

@Repository
public class CategoryDaoJdbcImpl implements CategoryDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		String sql = "insert into category(id, name, parent, del, types) "
				+ "values(?,?,?,?,?)";
		CreatePrimary primary = CreatePrimary.getInstance();
		String id = "ca" + primary.createPrimaryKey();
		jdbcTemplate.update(sql, new Object[] { id, category.getCategoryName(),
				category.getParentId(), false, category.getType() });
	}

	@Override
	public void updateCategory(Category category) {
		String sql = "update category set name = ?, parent = ?, del = ?, types = ? where id = ?";
		jdbcTemplate.update(sql, new Object[] { category.getCategoryName(),
				category.getParentId(), category.isDel(), category.getType(), category.getCategoryId()});

	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		String sql = "delete from category where id = ?";
		jdbcTemplate.update(sql, new Object[] {category.getCategoryId()});

	}

	@Override
	public Category getCategoryById(String categoryId) {
		// TODO Auto-generated method stub
		String sql = "select id, name, parent, del, types from category where id = ? and del = false order by id asc";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				Category category = new Category();
				category.setCategoryId(rs.getString(1));
				category.setCategoryName(rs.getString(2));
				category.setParentId(rs.getString(3));
				category.setDel(rs.getBoolean(4));
				category.setType(rs.getInt(5));
				return category;
			}
			
		}, categoryId);
	}

	@Override
	public List<Category> getCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		String sql = "select id, name, parent, del, types from category where name = ? and del = false order by id asc";
		List<Category> list =  jdbcTemplate.query(sql, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				Category category = new Category();
				category.setCategoryId(rs.getString(1));
				category.setCategoryName(rs.getString(2));
				category.setParentId(rs.getString(3));
				category.setDel(rs.getBoolean(4));
				category.setType(rs.getInt(5));
				return category;
			}
			
		}, categoryName);
		
		Collections.sort(list, new MiniComparator());
		
		return list;
	}

	@Override
	public Map<String, Category> getAllCategoryList() {
		// TODO Auto-generated method stub
		String sql = "select id, name, parent, del, types from category where del = false order by id asc";
		List<Category> allList = jdbcTemplate.query(sql, new RowMapper<Category>() {
			@Override
			public Category mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				Category category = new Category();
				category.setCategoryId(rs.getString(1));
				category.setCategoryName(rs.getString(2));
				category.setParentId(rs.getString(3));
				category.setDel(rs.getBoolean(4));
				category.setType(rs.getInt(5));
				return category;
			}
			
		});
		
		Map<String, Category> allMap = new HashMap<>();
		for (Category c : allList) {
			allMap.put(c.getCategoryId(), c);
		}
		return allMap;
	}

	@Override
	public List<Category> getRootCategoryList() {
		// TODO Auto-generated method stub
		String sql = "select id, name, parent, del, types from category where parent = ? and del = false order by id asc";
		List<Category> list = jdbcTemplate.query(sql, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				Category category = new Category();
				category.setCategoryId(rs.getString(1));
				category.setCategoryName(rs.getString(2));
				category.setParentId(rs.getString(3));
				category.setDel(rs.getBoolean(4));
				category.setType(rs.getInt(5));
				return category;
			}
			
		}, 0);
		
		Collections.sort(list, new MiniComparator());
		
		return list;
	}
	
	@Override
	public List<Category> getCategoryListbyType(int type) {
		// TODO Auto-generated method stub
		String sql = "select id, name, parent, del, types from category where type = ? and del = false order by id asc";
		List<Category> list = jdbcTemplate.query(sql, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				Category category = new Category();
				category.setCategoryId(rs.getString(1));
				category.setCategoryName(rs.getString(2));
				category.setParentId(rs.getString(3));
				category.setDel(rs.getBoolean(4));
				category.setType(rs.getInt(5));
				return category;
			}
			
		}, type);
		
		Collections.sort(list, new MiniComparator());
		
		return list;
	}

	@Override
	public List<Category> getDeleteCategoryList() {
		// TODO Auto-generated method stub
		String sql = "select id, name, parent, del, types from category where del = ? and del = true order by id asc";
		List<Category> list = jdbcTemplate.query(sql, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int arg1)
					throws SQLException {
				// TODO Auto-generated method stub
				Category category = new Category();
				category.setCategoryId(rs.getString(1));
				category.setCategoryName(rs.getString(2));
				category.setParentId(rs.getString(3));
				category.setDel(rs.getBoolean(4));
				category.setType(rs.getInt(5));
				return category;
			}
			
		}, true);
		
		Collections.sort(list, new MiniComparator());
		
		return list;
	}

	public void setJdbcTemplate(JdbcTemplate jdcTemplate) {
		this.jdbcTemplate = jdcTemplate;
	}


}
