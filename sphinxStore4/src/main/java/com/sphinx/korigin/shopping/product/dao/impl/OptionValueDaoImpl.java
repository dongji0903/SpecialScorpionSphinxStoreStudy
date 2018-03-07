package com.sphinx.korigin.shopping.product.dao.impl;

import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.shopping.product.dao.OptionValueDao;
import com.sphinx.korigin.shopping.product.domain.Option;

@Repository("OptionValueDao")
public class OptionValueDaoImpl extends AbstractDaoJdbc
		implements OptionValueDao {

	@Override
	public String insertOptionValue(Option option) {
		String id = null;
		System.out.println("option in dao: "+option);
		for (String key : option.getOptionValue().keySet()) {
			String sql = "insert into OptionValue(optionvalue_id, map_key,"
					+ " map_value, option_id)  values(?, ?, ?, ?)";
			id = generateID("OptionValue", "optionvalue_id", "OV");
			jdbcTemplate.update(sql, new Object[] { id, key,
					option.getOptionValue().get(key), option.getOptionId() });
			return id;
		}
		return id;
	}

	@Override
	public void updateOptionValue(String optionId, String mapKey,
			String mapValue) {
		String sql = "update OptionValue set map_key = ?, map_value = ?"
				+ " where option_id = ?";
		jdbcTemplate.update(sql, new Object[] { mapKey, mapValue, optionId });
	}

	@Override
	public void removeOptionValue(String optionValueId) {
		String sql = "delete from OptionValue where optionvalue_id = ?";
		jdbcTemplate.update(sql, optionValueId);
	}

}
