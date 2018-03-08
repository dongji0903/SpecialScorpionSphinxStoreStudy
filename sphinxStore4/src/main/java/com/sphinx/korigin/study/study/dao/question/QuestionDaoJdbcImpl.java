package com.sphinx.korigin.study.study.dao.question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.study.study.domain.question.*;
@Repository("QuestionDao")
public class QuestionDaoJdbcImpl extends AbstractDaoJdbc implements QuestionDao {

	private String sql;

	/**
	 * *같은 jyp...
	 * 
	 * @see com.sphinx.korigin.study.study.dao.question.QuestionDao#getAllJyp(java.lang.String)
	 */
	@Override
	public List<String> getAllJyp(String type) {
		String sql = "select title from " + type;
		return jdbcTemplate.queryForList(sql, String.class);
	}

	/**
	 * public String findJyp(String type, String text) { String sql = "select title
	 * from " + type + " where title = " + text;
	 */
	@Override
	public String findJyp(String type, String text) {
		String sql = "select title from " + type + " where title = ?";
		return jdbcTemplate.queryForObject(sql, String.class, text);
	}

	@Override
	public int createJyp(String type, String text) {
		String sql = "insert into ? (title) values (?)";
		if (findJyp(type, text) != null) { // 중복시 break
			return -1;
		} else {
			return jdbcTemplate.update(sql, new Object[] { type, text });
		}
	}

	@Override
	public String createQuestion(Question q) {
		String qid = generateID("question", "qid", "Q");
		String sql = "insert into Question (qid, text, score, file_Url, file_Type, Q_type,"
				+ " num_Of_Dis, source, jongryu, yeongyoeck, yoohyong,completed)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			jdbcTemplate.update(sql,
					new Object[] { qid, q.getText(), q.getScore(), q.getFileUrl(), q.getFileType(),
							(q instanceof ObjectiveQuestion) ? "o" : "s",
							(q instanceof ObjectiveQuestion) ? ((ObjectiveQuestion) q).getNumOfAnswer() : 0,
							q.getSource(), q.getJongryu(), q.getYeongyoeck(), q.getYoohyong(), q.getCompleted() });
			return qid;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Question> findAllQuestions() {
		String sql = "select qid, text, score, file_Url,file_Type, Q_type,"
				+ " num_Of_Dis, source, jongryu, yeongyoeck, yoohyong, completed" + " from Question";
		return jdbcTemplate.query(sql, new RowMapper<Question>() {

			@Override
			public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
				String qid = rs.getString("qid");
				String text = rs.getString("text");
				double score = rs.getDouble("score");
				String fileUrl = rs.getString("file_Url");
				String fileType = rs.getString("file_Type");
				String Qtype = rs.getString("Q_type");
				int numOfDis = rs.getInt("num_Of_Dis");
				String source = rs.getString("source");
				String jongryu = rs.getString("jongryu");
				String yeongyoeck = rs.getString("yeongyoeck");
				String yoohyong = rs.getString("yoohyong");
				String completed = rs.getString("completed");
				if (Qtype.equalsIgnoreCase("o")) {
					ObjectiveQuestion oq = new ObjectiveQuestion(qid, text, score, fileUrl, fileType, "o", source, null,
							numOfDis, null);
					oq.setJongryu(jongryu);
					oq.setYeongyoeck(yeongyoeck);
					oq.setYoohyong(yoohyong);
					oq.setCompleted(completed);
					return oq;
				} else {
					SubjectiveQuestion sq = new SubjectiveQuestion(qid, text, score, fileUrl, fileType, "s", source,
							null);
					sq.setJongryu(jongryu);
					sq.setYeongyoeck(yeongyoeck);
					sq.setYoohyong(yoohyong);
					sq.setCompleted(completed);
					return sq;
				}
			}
		});
	}

	@Override
	public Question findQuestion(String qid) {
		sql = "select text, score, file_Url,file_Type, Q_type, num_Of_Dis, source, jongryu, yeongyoeck, yoohyong, completed"
				+ " from Question where qid=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Question>() {

			@Override
			public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
				String text = rs.getString("text");
				double score = rs.getDouble("score");
				String fileUrl = rs.getString("file_Url");
				String fileType = rs.getString("file_Type");
				String Qtype = rs.getString("Q_type");
				int numOfDis = rs.getInt("num_Of_Dis");
				String source = rs.getString("source");
				String jongryu = rs.getString("jongryu");
				String yeongyoeck = rs.getString("yeongyoeck");
				String yoohyong = rs.getString("yoohyong");
				String completed = rs.getString("completed");

				if (Qtype.equalsIgnoreCase("o")) {
					ObjectiveQuestion oq = new ObjectiveQuestion(qid, text, score, fileUrl, fileType, "o", source, null,
							numOfDis, null);
					oq.setJongryu(jongryu);
					oq.setYeongyoeck(yeongyoeck);
					oq.setYoohyong(yoohyong);
					oq.setCompleted(completed);
					return oq;
				} else {
					SubjectiveQuestion sq = new SubjectiveQuestion(qid, text, score, fileUrl, fileType, "s", source,
							null);
					sq.setJongryu(jongryu);
					sq.setYeongyoeck(yeongyoeck);
					sq.setYoohyong(yoohyong);
					sq.setCompleted(completed);
					return sq;
				}
			}
		}, qid);
	}

	@Override
	public List<Question> findQuestions(String jongryu, String yeongyoeck, String yoohyong) {

		sql = "select qid, text, score, file_Url,file_type, Q_type, num_Of_Dis, source, yoohyong, completed"
				+ " from Question where jongryu = ? and yeongyoeck = ? and yoohyong=?";
		return jdbcTemplate.query(sql, new Object[] { jongryu, yeongyoeck, yoohyong }, new RowMapper<Question>() {

			@Override
			public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
				String qid = rs.getString("qid");
				String text = rs.getString("text");
				double score = rs.getDouble("score");
				String fileUrl = rs.getString("file_Url");
				String fileType = rs.getString("file_Type");
				String Qtype = rs.getString("Q_type");
				int numOfDis = rs.getInt("num_Of_Dis");
				String source = rs.getString("source");
				String completed = rs.getString("completed");

				if (Qtype.equalsIgnoreCase("o")) {
					ObjectiveQuestion oq = new ObjectiveQuestion(qid, text, score, fileUrl, fileType, "o", source, null,
							numOfDis, null);
					oq.setJongryu(jongryu);
					oq.setYeongyoeck(yeongyoeck);
					oq.setYoohyong(yoohyong);
					oq.setCompleted(completed);
					return oq;
				} else {
					SubjectiveQuestion sq = new SubjectiveQuestion(qid, text, score, fileUrl, fileType, "s", source,
							null);
					sq.setJongryu(jongryu);
					sq.setYeongyoeck(yeongyoeck);
					sq.setYoohyong(yoohyong);
					sq.setCompleted(completed);
					return sq;
				}
			}
		});
	}

	@Override
	public void updateQuestion(Question q) {
		sql = "update Question set text=?, score=?, file_Url=?, file_Type=?,Q_type=?, num_Of_Dis=?, jongryu = ?"
				+ ", yeongyoeck = ?, yoohyong = ?, source=?, completed=?" + " where qid=?";
		jdbcTemplate.update(sql,
				new Object[] { q.getText(), q.getScore(), q.getFileUrl(), q.getFileType(),
						(q instanceof ObjectiveQuestion) ? "o" : "s",
						(q instanceof ObjectiveQuestion) ? ((ObjectiveQuestion) q).getNumOfAnswer() : 0, q.getJongryu(),
						q.getYeongyoeck(), q.getYoohyong(), q.getSource(), q.getCompleted(), q.getQid() });
	}
}