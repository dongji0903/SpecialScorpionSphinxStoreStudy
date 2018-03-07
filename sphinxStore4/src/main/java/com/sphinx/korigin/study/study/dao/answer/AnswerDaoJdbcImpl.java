package com.sphinx.korigin.study.study.dao.answer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.study.study.domain.answer.Answer;

@Repository("AnswerDao")
public class AnswerDaoJdbcImpl extends AbstractDaoJdbc implements AnswerDao {
	String sql;

	@Override
	public void createAnswer(Answer a) {
		String aid = generateID("ANSWER", "AID", "A");
		sql = "insert into answer (aid, asid, question_num, answer, is_correct) "
				+ "values(?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql, new Object[] { aid, a.getAsid(),
				a.getQuestionNum(), a.getAnswer(), a.getIsCorrect() });
	}

	@Override
	public List<Answer> findAllAnswers() {
		sql = "select aid,asid,question_num,answer,is_correct from answer";

		return jdbcTemplate.query(sql, new RowMapper<Answer>() {

			@Override
			public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Answer(rs.getString("aid"),
						rs.getInt("question_num"), rs.getString("answer"),
						rs.getBoolean("is_correct"), rs.getString("asid"));
			}
		});
	}

	@Override
	public List<Answer> findAllAnswers(String asid) {
		sql = "select aid,asid,question_num,answer,is_correct from answer "
				+ "where asid=?";

		return jdbcTemplate.query(sql, new RowMapper<Answer>() {
			@Override
			public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Answer(rs.getString("aid"),
						rs.getInt("question_num"), rs.getString("answer"),
						rs.getBoolean("is_correct"), asid);
			}
		}, asid);
	}

	@Override
	public Answer findAnswer(String aid) {
		sql = "select aid,asid,question_num,answer,is_correct from answer "
				+ "where aid=?";

		return jdbcTemplate.queryForObject(sql, new RowMapper<Answer>() {

			@Override
			public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Answer(aid, rs.getInt("question_num"),
						rs.getString("answer"), rs.getBoolean("is_correct"),
						rs.getString("asid"));
			}
		}, aid);
	}

	@Override
	public void updateAnswer(Answer a) {
		sql = "update answer set asid = ?, question_num = ?, answer = ?, is_correct = ? "
				+ "where aid=?";
		jdbcTemplate.update(sql, new Object[] { a.getAsid(), a.getQuestionNum(),
				a.getAnswer(), a.getIsCorrect(), a.getAid() });
	}

	@Override
	public void deleteAnswer(String aid) {
		sql = "delete from answer where aid=?";
		jdbcTemplate.update(sql, new Object[] { aid });
	}
}
