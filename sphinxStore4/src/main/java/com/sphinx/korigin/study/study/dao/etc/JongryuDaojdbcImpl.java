package com.sphinx.korigin.study.study.dao.etc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;

@Repository("JongryuDao")
public class JongryuDaojdbcImpl extends AbstractDaoJdbc implements JongryuDao {
	String sql;
	@Override
	public List<String> getAllJongryu() {
		sql="select title from jongryu";
		return jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});
	}

	@Override
	public void addJongryu(String s) {
		sql="insert into jongryu(title) values(?)";
		jdbcTemplate.update(sql, s);
	}

}
