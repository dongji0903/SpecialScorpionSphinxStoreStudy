package com.sphinx.korigin.study.study.dao.exam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.study.study.domain.exam.ExamForm;
import com.sphinx.korigin.study.study.domain.question.GroupQuestion;
@Repository("ExamFormDao")
public class ExamFormDaojdbcImpl extends AbstractDaoJdbc implements ExamFormDao {
	String sql;

	/**
	 * ExamForm의 정보를 등록하며, groupQuestion List를 참조하여 관계테이블에 등록.
	 * 
	 * @author 이광민
	 * 
	 */
	@Override
	public void createExamForm(ExamForm examForm) {
		System.out.println("ExamFormDao: 아래 항목을 추가\n" + examForm);
		String eid = generateID("EXAM_FORM", "EID", "EF");
		sql = "insert into exam_form (eid,jongryu,cover_url) values(?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { eid, examForm.getJongryu(), examForm.getCoverUrl() });
		for (GroupQuestion g : examForm.getgList()) {
			addLink(eid, g.getGid());
		}
	}

	private void addLink(String eid, String gid) {
		sql = "insert into examform_groupQ(eid,gid) values(?,?)";
		jdbcTemplate.update(sql, new Object[] { eid, gid });
	}

	@Override
	public ExamForm findExamForm(String eid) { // GroupQuestion에 관한 정보 없음
		sql = "select jongryu,cover_url from exam_form where eid=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<ExamForm>() {

			@Override
			public ExamForm mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ExamForm examForm = new ExamForm();
				examForm.setEid(eid);
				examForm.setJongryu(rs.getString(1));
				examForm.setCoverUrl(rs.getString(2));
				return examForm;
			}
		}, eid);
	}

	@Override
	public List<String> findGidList(String eid) {
		sql = "select gid from examform_groupQ where eid=?";
		return jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		}, eid);
	}

	@Override
	public ExamForm findExamFormByJ(String jongryu) {
		sql = "select eid,cover_url from exam_form where jongryu=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<ExamForm>() {

			@Override
			public ExamForm mapRow(ResultSet rs, int rowNum) throws SQLException {
				ExamForm examForm = new ExamForm();
				examForm.setEid(rs.getString(1));
				examForm.setJongryu(jongryu);
				examForm.setCoverUrl(rs.getString(2));
				return examForm;
			}
		}, jongryu);
	}
}
