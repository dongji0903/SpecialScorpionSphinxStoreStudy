package com.sphinx.korigin.study.study.dao.etc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;

@Repository("YoohyongDao")
public class YoohyongDaojdbcImpl extends AbstractDaoJdbc
		implements YoohyongDao {
String sql;
	@Override
	public List<String> getAllYoohyong() {
		sql="select title from yoohyong";
		return jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
	}

	@Override
	public void addYoohyong(String s) {
		sql="insert into yoohyong(title) values(?)";
		jdbcTemplate.update(sql, s);
	}

}
