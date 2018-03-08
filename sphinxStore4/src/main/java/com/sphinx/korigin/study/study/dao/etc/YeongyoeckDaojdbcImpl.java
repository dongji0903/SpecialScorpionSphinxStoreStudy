package com.sphinx.korigin.study.study.dao.etc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;

@Repository("YeongyoeckDao")
public class YeongyoeckDaojdbcImpl extends AbstractDaoJdbc
		implements YeongyoeckDao {
String sql;
	@Override
	public List<String> getAllYeongyoeck() {
		sql="select title from yeongyoeck";
		return jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
	}

	@Override
	public void addYeongyoeck(String s) {
		sql="insert into yeongyoeck(title) values(?)";
		jdbcTemplate.update(sql, s);
	}

}
