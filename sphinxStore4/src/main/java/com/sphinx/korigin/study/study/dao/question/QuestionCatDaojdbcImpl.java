package com.sphinx.korigin.study.study.dao.question;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
@Repository("QuestionCatDao")
public class QuestionCatDaojdbcImpl extends AbstractDaoJdbc implements QuestionCatDao {

	String sql;

	@Override
	public List<String> findQidsOfCategory(String cid) {
		sql = "select qid from question_cat_table " + "where cid=?";
		return jdbcTemplate.queryForList(sql, String.class, cid);
	}

	@Override
	public void addLink(String qid, String cid) {
		sql = "insert into question_cat_table(qid, cid) " + "values(?, ?)";
		jdbcTemplate.update(sql, new Object[] { qid, cid });
	}

	@Override
	public void removeLink(String qid, String cid) {
		sql = "delete from question_cat_table " + "where qid=? and cid=?";
		jdbcTemplate.update(sql, new Object[] { qid, cid });
	}

	@Override
	public List<String> findCidsOfQuestion(String qid) {
		sql = "select cid from question_cat_table " + "where qid=?";
		return jdbcTemplate.queryForList(sql, String.class, qid);
	}

}
