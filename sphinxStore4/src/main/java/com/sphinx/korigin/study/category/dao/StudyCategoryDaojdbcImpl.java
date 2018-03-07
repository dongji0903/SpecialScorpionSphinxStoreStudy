package com.sphinx.korigin.study.category.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.derby.tools.sysinfo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.study.category.domain.Category;

@Repository("StudyCategoryDao")
public class StudyCategoryDaojdbcImpl extends AbstractDaoJdbc implements StudyCategoryDao {

	private String sql;

	@Override
	public String createCategory(Category c) { // 신규등록은 상위로 등록 X
		String newCid = generateID("CATEGORY_TABLE", "CID", "C");
		sql = "insert into category_table (cid,parent_cid, title) values (?, ?, ?)";
		try {
			jdbcTemplate.update(sql, new Object[] { newCid, c.getParent(), c.getTitle() });
			return newCid;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Map<String, Category> findAllCategory() {
		Map<String, Category> categoryMap = new TreeMap<>();
		Map<String, List<String>> familyMap = new HashMap<>();
		sql = "select cid, parent_cid, title from category_table";
		jdbcTemplate.query(sql, new RowMapper<Object>() {
			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				String cid = rs.getString(1);
				String parentCid = rs.getString(2);
				String title = rs.getString(3);
				if (!categoryMap.containsKey(cid)) {
					categoryMap.put(cid, new Category(cid, parentCid, title, null));
				}
				if (parentCid != null && !parentCid.isEmpty()) {
					if (!familyMap.containsKey(parentCid)) {
						familyMap.put(parentCid, new ArrayList<>());
						familyMap.get(parentCid).add(cid);
					} else {
						if (!familyMap.get(parentCid).contains(cid)) {
							familyMap.get(parentCid).add(cid);
						}
					}
				}
				return null;
			}
		});
		for (String parent : familyMap.keySet()) {
			categoryMap.get(parent).setChildren(familyMap.get(parent));
		}
		return categoryMap;
	}

	@Override
	public Category findCategory(String cid) {
		sql = "select parent_cid, title from category_table where cid=?";
		Category cat = jdbcTemplate.queryForObject(sql, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new Category(cid, rs.getString(1), rs.getString(2), null);
			}
		}, cid);
		sql = "select cid from category_table where parent_cid=?";
		List<String> children = jdbcTemplate.query(sql, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString(1);
			}
		}, cid);
		cat.setChildren(children);
		return cat;
	}

	@Override
	public void modifyCategory(Category c) {
		sql = "update category_table set parent_cid=?, title=? where cid=?";
		jdbcTemplate.update(sql, new Object[] { c.getParent(), c.getTitle(), c.getCid() });
	}

	@Override
	public List<Category> findCategoryByTitle(String title) {
		List<Category> categoryList = new ArrayList<>();
		sql = "select cid from category_table where title=?";
		List<String> cidList = jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				return rs.getString(1);
			}

		}, title);
		for (String s : cidList) {
			categoryList.add(findCategory(s));
		}
		return categoryList;
	}

	@Override
	public void deleteCategory(String cid) {
		sql = "delete from category_table where cid=?";
		jdbcTemplate.update(sql, cid);
	}

	@Override
	public void deleteCascadeCategory(String cid) {
		Category category = findCategory(cid);
		if (category.getChildren() != null && !category.getChildren().isEmpty()) {
			for (String c : category.getChildren()) {
				deleteCascadeCategory(c);
			}
		}
		deleteCategory(cid);
	}

	@Override
	public List<Category> findFirstCategories() {
		sql = "select cid from category_table where parent_cid is null or parent_cid=''";
		List<Category> categoryList = new ArrayList<>();
		List<String> sList = jdbcTemplate.query(sql, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
		for (String s : sList) {
			Category c = findCategory(s);
			if (!categoryList.contains(c)) {
				categoryList.add(c);
			}
		}
		return categoryList;
	}

}