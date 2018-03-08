package com.sphinx.korigin.shopping.product.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.shopping.product.dao.OptionsLinkDao;

@Repository("OptionsLinkDao")
public class OptionsLinkDaoImpl extends AbstractDaoJdbc
		implements OptionsLinkDao {

	@Override
	public void insertLink(String optionId, String optionValueId) {
		String sql = "insert into Options_Link(option_Id, optionValue_Id) "
				+ "values(?, ?)";
		jdbcTemplate.update(sql, new Object[] { optionId, optionValueId });
	}

	@Override
	public List<String> selectOptionValueIdsByOptionId(String optionId) {
		String sql = "select optionValue_Id from Options_Link where option_Id = ?";
		return jdbcTemplate.query(sql, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String productId = rs.getString("optionValue_Id");
				return productId;
			}
		}, optionId);
	}

	@Override
	public List<String> selectOptionIdsByOptionValueId(String optionValueId) {
		String sql = "select option_Id from Options_Link where optionValue_Id = ?";
		return jdbcTemplate.query(sql, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String productId = rs.getString("option_Id");
				return productId;
			}
		}, optionValueId);
	}

}
