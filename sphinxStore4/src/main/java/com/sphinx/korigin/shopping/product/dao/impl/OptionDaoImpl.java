package com.sphinx.korigin.shopping.product.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.shopping.product.dao.OptionDao;
import com.sphinx.korigin.shopping.product.domain.Option;

@Repository("OptionDao")
public class OptionDaoImpl extends AbstractDaoJdbc implements OptionDao {

	@Override
	public String insertOption(String optionName, String productId) {
		String sql = "insert into Options(option_id, option_name, product_id)"
				+ " values(?, ?, ?)";
		String id = generateID("Options", "option_id", "OP");
		jdbcTemplate.update(sql,
				new Object[] { id, optionName, productId });
		return id;
	}

	@Override
	public void updateOption(Option option) {
		String sql = "update Options set option_name = ? where option_id = ?";
		jdbcTemplate.update(sql,
				new Object[] { option.getOptionName(), option.getOptionId() });
	}

	@Override
	public void removeOption(Option option) {
		String sql = "delete from Options where option_id = ?";
		jdbcTemplate.update(sql, option.getOptionId());
	}

	@Override
	public Option selectOptionById(String optionId) {
		String sql = "select option_id = ?, option_name = ?, product_id = ? "
				+ "from Options where option_id = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Option>() {
			@Override
			public Option mapRow(ResultSet rs, int rowNum) throws SQLException {
				Option option = new Option();
				option.setOptionId(rs.getString("option_id"));
				option.setOptionName(rs.getString("option_name"));
				return option;
			}
		}, optionId);
	}

	@Override
	public List<Option> selectOptionListByProductId(String productId) {
		String sql = "select option_id = ?, option_name = ?, product_id = ? "
				+ "from Options where product_id = ?";
		return jdbcTemplate.query(sql, new RowMapper<Option>() {
			@Override
			public Option mapRow(ResultSet rs, int rowNum) throws SQLException {
				Option option = new Option();
				option.setOptionId(rs.getString("option_id"));
				option.setOptionName(rs.getString("option_name"));
				return option;
			}
		}, productId);
	}

}
