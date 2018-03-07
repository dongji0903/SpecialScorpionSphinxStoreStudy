package com.sphinx.korigin.study.study.dao.exam;

import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
@Repository("SheetFormDao")
public class SheetFormDaojdbcImpl extends AbstractDaoJdbc implements SheetFormDao {
	String sql;

	@Override
	public void addLink(String sid, String fid) {
		sql = "insert into sheet_form_link_table(sid, fid) values(?, ?)";
		jdbcTemplate.update(sql, new Object[] { sid, fid });
	}

	@Override
	public String findFormIdOfSheet(String sid) {
		sql = "select fid from sheet_form_link_table where sid = ?";
		return jdbcTemplate.queryForObject(sql, String.class, sid);
	}

	@Override
	public void removeLinks(String sid) {
		sql = "delete from sheet_form_link_table where sid = ?";
		jdbcTemplate.update(sql, sid);
	}

}
