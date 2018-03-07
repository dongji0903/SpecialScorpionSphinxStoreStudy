package com.sphinx.korigin.study.study.dao.question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.study.study.domain.question.Distractor;

@Repository("Distractor")
public class DistractorDaoJdbcImpl extends AbstractDaoJdbc implements DistractorDao {
	String sql;

	@Override
	public void createDistractor(Distractor d) {
		String id = generateID("DISTRACTOR", "DID", "D");
		sql = "insert into Distractor(did, text, qid) " + "values(?,  ?, ?)";
		jdbcTemplate.update(sql, new Object[] { id, d.getText(), d.getQid() });
	}

	@Override
	public List<Distractor> findAllDistractors() {
		String sql = "select did, text, qid from Distractor";
		return jdbcTemplate.query(sql, new RowMapper<Distractor>() {

			@Override
			public Distractor mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Distractor(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		});
	}

	@Override
	public List<Distractor> findAllDistractors(String qid) {
		String sql = "select did, text, qid from Distractor" + " where qid = ?";
		return jdbcTemplate.query(sql, new RowMapper<Distractor>() {

			@Override
			public Distractor mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Distractor(rs.getString(1), rs.getString(2), qid);
			}
		}, qid);
	}

	@Override
	public Distractor findDistractor(String did) {
		String sql = "select text, qid from Distractor" + " where did = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Distractor>() {

			@Override
			public Distractor mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Distractor(did, rs.getString(1), rs.getString(2));
			}
		}, did);
	}

	@Override
	public void updateDistractor(Distractor d) {
		sql = "update Distractor set qid = ?, text = ? where did = ?";
		jdbcTemplate.update(sql, new Object[] { d.getQid(), d.getText(), d.getDid() });
	}

	@Override
	public void deleteDistractor(String did) {
		sql = "delete from Distractor where did = ?";
		jdbcTemplate.update(sql, did);
	}
}
