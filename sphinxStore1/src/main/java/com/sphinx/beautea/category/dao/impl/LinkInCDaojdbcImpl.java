package com.sphinx.beautea.category.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.beautea.category.dao.LinkInCDao;
import com.sphinx.beautea.category.domain.LinkInC;
import com.sphinx.beautea.common.primary.CreatePrimary;

@Repository("LinkInCDao")
public class LinkInCDaojdbcImpl implements LinkInCDao {
	@Autowired
	private JdbcTemplate jdbcTemplete;
	
	@Override
	public void addLinkInC(LinkInC linkInC) {
		String sql = "insert into LinkInC (id, productId, categoryId, del) "
				+ "values (?, ?, ?, ?)";
		CreatePrimary primary = CreatePrimary.getInstance();
		String id = "ic" + primary.createPrimaryKey();
		jdbcTemplete.update(sql, new Object[] {id, linkInC.getProductId(), 
				linkInC.getCategoryId(), false});
	}

	
	
	
	@Override
	public void updateLinkInC(LinkInC linkInC) {
		String sql = "update LinkInC set productId = ?, categoryId = ?, del = ? "
				+ "where id = ?";
		jdbcTemplete.update(sql, new Object[] {linkInC.getProductId(), 
				linkInC.getCategoryId(), linkInC.isDel(), linkInC.getLinkId()});
	}

	
	
	
	@Override
	public void deleteLinkInC(LinkInC linkInC) {
		String sql = "delete from LinkInC where id = ?";
		jdbcTemplete.update(sql, new Object[] {linkInC.getLinkId()});
	}

	
	
	
	@Override
	public LinkInC findLinkInCById(String linkId) {
		String sql = "select id, productId, categoryId, del from LinkInC "
				+ "where id = ?";
		return jdbcTemplete.queryForObject(sql, new RowMapper<LinkInC>() {

			@Override
			public LinkInC mapRow(ResultSet rs, int arg1)
					throws SQLException {
				LinkInC link = new LinkInC();
				link.setLinkId(linkId);
				link.setProductId(rs.getString(2));
				link.setCategoryId(rs.getString(3));
				link.setDel(rs.getBoolean(4));
				return link;
			}
			
		}, linkId);
	}

	
	
	
	@Override
	public List<LinkInC> findLinkInCListByCategoryId(String categoryId) {
		String sql = "select id, productId, categoryId, del from LinkInC "
				+ "where categoryId = ? and del = ?";
		return jdbcTemplete.query(sql, new RowMapper<LinkInC>() {

			@Override
			public LinkInC mapRow(ResultSet rs, int arg1)
					throws SQLException {
				LinkInC link = new LinkInC();
				link.setLinkId(rs.getString(1));
				link.setProductId(rs.getString(2));
				link.setCategoryId(categoryId);
				link.setDel(rs.getBoolean(4));
				return link;
			}
			
		}, new Object[] {categoryId, false});
	}

	
	
	
	@Override
	public List<LinkInC> findLinkInCListByCategoryId(int start, int amount,
			String categoryId) {
		String sql = "select id, productId, categoryId, del from LinkInC "
				+ "where categoryId = ? and del = ? "
				+ "ORDER BY id DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		return jdbcTemplete.query(sql, new RowMapper<LinkInC>() {

			@Override
			public LinkInC mapRow(ResultSet rs, int arg1)
					throws SQLException {
				LinkInC link = new LinkInC();
				link.setLinkId(rs.getString(1));
				link.setProductId(rs.getString(2));
				link.setCategoryId(categoryId);
				link.setDel(rs.getBoolean(4));
				return link;
			}
			
		}, new Object[] {categoryId, false, start, amount});
	}

	
	
	
	@Override
	public List<LinkInC> findLinkInCListByProductId(String productId) {
		String sql = "select id, productId, categoryId, del from LinkInC "
				+ "where productId = ? and del = ?";
		return jdbcTemplete.query(sql, new RowMapper<LinkInC>() {

			@Override
			public LinkInC mapRow(ResultSet rs, int arg1)
					throws SQLException {
				LinkInC link = new LinkInC();
				link.setLinkId(rs.getString(1));
				link.setProductId(productId);
				link.setCategoryId(rs.getString(3));
				link.setDel(rs.getBoolean(4));
				return link;
			}
			
		}, new Object[] {productId, false});
	}

	
	
	
	@Override
	public int countProductByCategoryId(String categoryId, boolean del) {
		String sql = "select count(id) from LinkInC "
				+ "where categoryId = ? and del = ?";
		return jdbcTemplete.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				int count = rs.getInt(1);
				return count;
			}
			
		}, categoryId, del);
	}

	
	
	
}
