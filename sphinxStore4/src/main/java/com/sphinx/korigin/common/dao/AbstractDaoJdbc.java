package com.sphinx.korigin.common.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public abstract class AbstractDaoJdbc {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected String generateID(String tblName, String idName, String prefix) {
		// 테이블명, PK이름, PK접두사 지정시 VARCHAR ID생성해줌
		String sql = "select max(" + idName + ") from " + tblName;
		// column에 영문 정도는 섞여도 max집계는 잘됨
		try {
			return jdbcTemplate.queryForObject(sql, new RowMapper<String>() {
				@Override
				public String mapRow(ResultSet rs, int arg1)
						throws SQLException {
					int num = Integer.parseInt(
							rs.getString(1).substring(prefix.length()));
					return prefix + String.format("%06d", num + 1);
				}
			});
		} catch (NullPointerException e1) {
			return prefix + "000001";
		}
	}
}
