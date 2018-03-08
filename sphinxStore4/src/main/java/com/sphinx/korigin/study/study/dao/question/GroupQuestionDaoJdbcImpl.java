package com.sphinx.korigin.study.study.dao.question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.study.study.domain.question.GroupQuestion;
@Repository("GroupQuestionDao")
public class GroupQuestionDaoJdbcImpl extends AbstractDaoJdbc implements GroupQuestionDao {

	@Override
	public void createTestForm(GroupQuestion form) {
		String gid = generateID("GROUP_QUESTION", "GID", "G");
		String sql = "insert into Group_Question(gid,jongryu, yeongyoeck, yoohyong, file_url, num_of_question, text) values(?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { gid, form.getJongryu(), form.getYeongyoeck(), form.getYoohyong(),
				form.getFileUrl(), form.getNumOfQuestions(), form.getText() });
	}

	@Override
	public List<GroupQuestion> findGroupQuestionByJYY(String jongryu, String yeongyoeck, String yoohyong) {
		String sql = "select file_url, num_of_question, text"
				+ " from Group_Question where jongryu = ? and yeongyoeck = ?";
		return jdbcTemplate.query(sql, new Object[] { jongryu, yeongyoeck }, new RowMapper<GroupQuestion>() {

			@Override
			public GroupQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
				String fileUrl = rs.getString("file_url");
				int numOfQuestions = rs.getInt("num_of_question");
				String text = rs.getString("text");

				GroupQuestion newform = new GroupQuestion();
				newform.setJongryu(jongryu);
				newform.setYeongyoeck(yeongyoeck);
				newform.setFileUrl(fileUrl);
				newform.setNumOfQuestions(numOfQuestions);
				newform.setYoohyong(yoohyong);
				newform.setText(text);
				return newform;
			}
		});
	}

	@Override
	public GroupQuestion findGroupQuestion(String gid) {
		String sql = "select jongryu, yeongyoeck, yoohyong, file_url, num_of_question, text"
				+ " from Group_Question where gid = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<GroupQuestion>() {

			@Override
			public GroupQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
				GroupQuestion newform = new GroupQuestion();
				newform.setGid(gid);
				newform.setJongryu(rs.getString("jongryu"));
				newform.setYeongyoeck(rs.getString("yeongyoeck"));
				newform.setYoohyong(rs.getString("yoohyong"));
				newform.setFileUrl(rs.getString("file_url"));
				newform.setNumOfQuestions(rs.getInt("num_of_question"));
				newform.setText(rs.getString("text"));
				return newform;
			}
		}, gid);
	}

	@Override
	public List<GroupQuestion> findGroupQuestionsByYY(String yeongyoeck, String yoohyong) {
		String sql = "select gid, file_url, num_of_question, text"
				+ " from Group_Question where yeongyoeck = ? and yoohyong = ?";
		return jdbcTemplate.query(sql, new Object[] {
				yeongyoeck,yoohyong
		},new RowMapper<GroupQuestion>() {

			@Override
			public GroupQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
				GroupQuestion newform = new GroupQuestion();
				newform.setGid(rs.getString("gid"));
				newform.setYeongyoeck(yeongyoeck);
				newform.setYoohyong(yoohyong);
				newform.setFileUrl(rs.getString("file_url"));
				newform.setNumOfQuestions(rs.getInt("num_of_question"));
				newform.setText(rs.getString("text"));
				return newform;
			}
		});
	}

}
