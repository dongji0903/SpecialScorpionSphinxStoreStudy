package com.sphinx.beautea.product.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.beautea.common.primary.CreatePrimary;
import com.sphinx.beautea.product.dao.OptionDao;
import com.sphinx.beautea.product.domain.Option;

@Repository("OptionDao")
public class OptionDaojdbcImpl implements OptionDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addOption(Option option, String productId) {
		CreatePrimary primary = CreatePrimary.getInstance();
		String pk = null;
		if (option.getOptionId() == null) { 
			pk = "op"+primary.createPrimaryKey();
		} else {
			pk = "op"+option.getOptionId();
		}
		// TODO Auto-generated method stub
		String sql = "INSERT INTO OPTIONS(id, optionName, productId, del) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{pk, option.getOptionName(), productId, false});
		
		addOptionValue(option, pk);
	}
	
	public void addOptionValue(Option option, String optionId) {
		Map<String, Double> value = option.getOptionValueMap();
		int i = 0;
		for (String key : value.keySet()) {
			i++;
			String num = null;
			if(i < 10) {
				num = "0" + i;
			} else {
				num = i + "";
			}
			String pk = "ov" + optionId.substring(2) + num;
			System.out.println(pk);
			String sql = "INSERT INTO OptionValue(id, optionValue, addprice, optionId, del) VALUES (?,?,?,?,?)";
			jdbcTemplate.update(sql, new Object[]{pk, key, value.get(key), optionId, false});
		}
	}

	@Override
	public void updateOption(Option option) {
		String sql = "update Options set optionName = ?, del = ? where id = ?";
		jdbcTemplate.update(sql, new Object[] {option.getOptionName(), option.isDel(), option.getOptionId()});
	}
	
	public void updateOptionValue(Option option, String optionId) {
		String sql = "update OptionValue set optionValue, addprice, del where id = ?";
		Map<String, Double> valueMap = option.getOptionValueMap();
		int i = 0;
		for(String key : valueMap.keySet()) {
			i++;
			String num = null;
			if(i < 10) {
				num = "0" + i;
			} else {
				num = i + "";
			}
			String id = "ov" + optionId.substring(2) + num;
			jdbcTemplate.update(sql, new Object[] {key, valueMap.get(key), option.isDel(), id});
		}
	}

	@Override
	public void deleteOption(Option option) {
		String sql = "delete from Options where id = ?";
		jdbcTemplate.update(sql, new Object[] {option.getOptionId()});
		
	}
	
	@Override
	public void deleteOptionValue(String optionId) {
		String sql = "delete from OptionValue where optionId = ?";
		jdbcTemplate.update(sql, new Object[] {optionId});
	}

	@Override
	public Option getOptionById(String optionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Option> getOptionListByProductId(String productId) {
		String sql = "select id, optionName, del, productId from options where productId = ?";
		List<Option> option_list = jdbcTemplate.query(sql, new RowMapper<Option>() {

			@Override
			public Option mapRow(ResultSet rs, int arg1) throws SQLException {
				Option option = new Option();
				option.setDel(rs.getBoolean(3));
				option.setOptionId(rs.getString(1));
				option.setOptionName(rs.getString(2));
				return option;
			}
			
		}, productId);
		
		List<Option> return_option = new ArrayList<>();
		for (Option o : option_list) {
			return_option.add(getOptionValue(o));
		}
		
		return return_option;
	}
	
	public Option getOptionValue(Option option) {
		String sql = "select id, optionValue, addprice, del, optionId from OptionValue where optionId = ?";
		jdbcTemplate.query(sql, new RowMapper<Option>() {
			@Override
			public Option mapRow(ResultSet rs, int arg1) throws SQLException {
				option.getOptionValueMap().put(rs.getString(2), rs.getDouble(3));
				return null;
			}
			
		}, option.getOptionId());
		
		return option;
	}

	@Override
	public List<Option> getDeleteOptionListByProductId(String productId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
