package com.sphinx.korigin.study.study.dao.question;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
@Repository("SheetQuestionDao")
public class SheetQuestionDaojdbcImpl extends AbstractDaoJdbc implements SheetQuestionDao {

	String sql;

	@Override
	public void addLink(String sid, String qid) {
		sql = "insert into sheet_question_table(sid, qid) " + "values(?, ?)";
		jdbcTemplate.update(sql, new Object[] { sid, qid });
	}

	@Override
	public void removeLink(String sid, String qid) {
		sql = "delete from sheet_question_table " + "where sid = ? and qid = ?";
		jdbcTemplate.update(sql, new Object[] { sid, qid });
	}

	@Override
	public List<String> findQidsOfSheet(String sid) {
		sql = "select qid from sheet_question_table " + "where sid = ?";
		return jdbcTemplate.queryForList(sql, String.class, sid);
	}

	@Override
	public List<Integer> findSheetsOfQuestion(String qid) {
		sql = "select sid from sheet_question_table " + "where qid = ?";
		return jdbcTemplate.queryForList(sql, int.class, qid);
	}

}
