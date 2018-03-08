package com.sphinx.beautea.category.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.beautea.category.dao.LinkBnCDao;
import com.sphinx.beautea.category.domain.LinkBnC;
import com.sphinx.beautea.common.primary.CreatePrimary;

@Repository
public class LinkBnCDaojdbcImpl implements LinkBnCDao {
	@Autowired
	private JdbcTemplate jdbcTemplete;
	
	@Override
	public void addLinkBnC(LinkBnC linkBnC) {
		String sql = "insert into LinkBnC (id, boardId, categoryId, del) "
				+ "values (?, ?, ?, ?)";
		CreatePrimary primary = CreatePrimary.getInstance();
		String id = "bc" + primary.createPrimaryKey();
		jdbcTemplete.update(sql, new Object[] {id, 
				linkBnC.getBoardId(), linkBnC.getCategoryId(), false});
	}

	
	
	
	@Override
	public void updateLinkBnC(LinkBnC linkBnC) {
		String sql = "update LinkBnC set boardId = ?, categoryId = ?, del = ? "
				+ "where id = ?";
		jdbcTemplete.update(sql, new Object[] {linkBnC.getBoardId(), 
				linkBnC.getCategoryId(), linkBnC.isDel(), linkBnC.getLinkId()});
	}

	
	
	
	@Override
	public void deleteLinkBnC(LinkBnC linkBnC) {
		String sql = "delete from LinkBnC where id = ?";
		jdbcTemplete.update(sql, new Object[] {linkBnC.getLinkId()});
	}
	
	
	

	@Override
	public LinkBnC findLinkBnCById(String linkId) {
		String sql = "select id, boardId, categoryId, del from LinkBnC "
				+ "where id = ?";
		return jdbcTemplete.queryForObject(sql, new RowMapper<LinkBnC>() {

			@Override
			public LinkBnC mapRow(ResultSet rs, int arg1)
					throws SQLException {
				LinkBnC linkBnC = new LinkBnC();
				linkBnC.setLinkId(linkId);
				linkBnC.setBoardId(rs.getString(2));
				linkBnC.setCategoryId(rs.getString(3));
				linkBnC.setDel(rs.getBoolean(4));
				return linkBnC;
			}
			
		}, linkId);
	}

	
	
	
	@Override
	public List<LinkBnC> findLinkBnCListByCategoryId(String categoryId) {
		String sql = "select id, boardId, categoryId, del from LinkBnC "
				+ "where categoryId = ? and del = false";
		return jdbcTemplete.query(sql, new RowMapper<LinkBnC>() {

			@Override
			public LinkBnC mapRow(ResultSet rs, int arg1)
					throws SQLException {
				LinkBnC linkBnC = new LinkBnC();
				linkBnC.setLinkId(rs.getString(1));
				linkBnC.setBoardId(rs.getString(2));
				linkBnC.setCategoryId(categoryId);
				linkBnC.setDel(rs.getBoolean(4));
				return linkBnC;
			}
			
		}, categoryId);
	}

	
	
	
	@Override
	public List<LinkBnC> findLinkBnCListByCategoryId(int start, int amount,
			String categoryId) {
		String sql = "select id, boardId, categoryId, del from LinkBnC "
				+ "where categoryId = ? and del = ? "
				+ "ORDER BY id DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		return jdbcTemplete.query(sql, new RowMapper<LinkBnC>() {

			@Override
			public LinkBnC mapRow(ResultSet rs, int arg1)
					throws SQLException {
				LinkBnC linkBnC = new LinkBnC();
				linkBnC.setLinkId(rs.getString(1));
				linkBnC.setBoardId(rs.getString(2));
				linkBnC.setCategoryId(categoryId);
				linkBnC.setDel(rs.getBoolean(4));
				return linkBnC;
			}
			
		}, new Object[] {categoryId, false, start, amount});
	}

	
	
	
	@Override
	public List<LinkBnC> findLinkBnCListByBoardId(String boardId) {
		String sql = "select id, boardId, categoryId, del from LinkBnC "
				+ "where boardId = ? and del = false";
		return jdbcTemplete.query(sql, new RowMapper<LinkBnC>() {

			@Override
			public LinkBnC mapRow(ResultSet rs, int arg1)
					throws SQLException {
				LinkBnC linkBnC = new LinkBnC();
				linkBnC.setLinkId(rs.getString(1));
				linkBnC.setBoardId(boardId);
				linkBnC.setCategoryId(rs.getString(3));
				linkBnC.setDel(rs.getBoolean(4));
				return linkBnC;
			}
			
		}, boardId);
	}

	
	
	
	@Override
	public int countBoardByCategoryId(String categoryId, boolean del) {
		String sql = "select count(id) from LinkBnC "
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
