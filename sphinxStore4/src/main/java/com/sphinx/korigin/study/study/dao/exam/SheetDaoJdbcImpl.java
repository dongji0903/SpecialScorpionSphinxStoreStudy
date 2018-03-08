package com.sphinx.korigin.study.study.dao.exam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.study.study.domain.exam.ExamSheet;
import com.sphinx.korigin.study.study.domain.exam.Sheet;
@Repository("SheetDao")
public class SheetDaoJdbcImpl extends AbstractDaoJdbc implements SheetDao {

	String sql;

	@Override
	public String createSheet(Sheet s) {
		String sid = generateID("sheet", "sid", "S");
		sql = "insert into sheet (sid, title, grade, num_of_question, examiner, create_sheet_date, limit_time, completed,formal) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?,?)";
		try {
			jdbcTemplate.update(sql,
					new Object[] { sid, s.getTitle(), s.getGrade(), s.getNumOfQuestion(), s.getExaminer(),
							s.getCreateSheetDate(), s.getLimitTime(), s.getCompleted(),
							(s instanceof ExamSheet) ? "Y" : "N" });
			return sid;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Sheet> findAllInformalSheets() {
		sql = "select sid, title, grade, num_of_question, examiner," + " create_sheet_date, limit_time, completed "
				+ "from sheet where formal='N'";
		return jdbcTemplate.query(sql, new RowMapper<Sheet>() {

			@Override
			public Sheet mapRow(ResultSet rs, int rowNum) throws SQLException {
				String sid = rs.getString(1);
				String title = rs.getString(2);
				String grade = rs.getString(3);
				int numOfQuestion = rs.getInt(4);
				String examiner = rs.getString(5);
				Date createSheetDate = rs.getDate(6);
				int limitTime = rs.getInt(7);
				String completed = rs.getString(8);
				return new Sheet(sid, title, grade, numOfQuestion, examiner, createSheetDate, limitTime, completed);
			}
		});
	}

	@Override
	public Sheet findSheet(String sid) {
		sql = "select title, grade, num_of_question, examiner, create_sheet_date, limit_time, completed, formal "
				+ "from sheet where sid=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Sheet>() {

			@Override
			public Sheet mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				String title = rs.getString(1);
				String grade = rs.getString(2);
				int numOfQuestion = rs.getInt(3);
				String examiner = rs.getString(4);
				Date createSheetDate = rs.getDate(5);
				int limitTime = rs.getInt(6);
				String completed = rs.getString(7);
				String formal = rs.getString(8);
				if (formal.equalsIgnoreCase("Y")) {
					ExamSheet fsheet = new ExamSheet();
					fsheet.setCompleted(completed);
					fsheet.setCreateSheetDate(createSheetDate);
					fsheet.setExaminer(examiner);
					fsheet.setGrade(grade);
					fsheet.setLimitTime(limitTime);
					fsheet.setNumOfQuestion(numOfQuestion);
					fsheet.setSid(sid);
					fsheet.setTitle(title);
					return fsheet;
				} else {
					return new Sheet(sid, title, grade, numOfQuestion, examiner, createSheetDate, limitTime, completed);
				}
			}
		}, sid);
	}

	@Override
	public void updateSheet(Sheet s) {
		sql = "update sheet set title = ?, grade = ?, num_of_question = ?, examiner = ?, "
				+ "create_sheet_date = ?, limit_time = ?, completed=? " + "where sid = ?";
		jdbcTemplate.update(sql, new Object[] { s.getTitle(), s.getGrade(), s.getNumOfQuestion(), s.getExaminer(),
				s.getCreateSheetDate(), s.getLimitTime(), s.getSid() });
	}

	@Override
	public int getNumberOfSheets() {
		sql = "select count(*) from sheet";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	@Override
	public List<Sheet> findSheets(String examiner) {
		sql = "select sid, title, grade, num_of_question, examiner, create_sheet_date, limit_time, completed, formal "
				+ "from sheet where examiner = ?";
		return jdbcTemplate.query(sql, new RowMapper<Sheet>() {

			@Override
			public Sheet mapRow(ResultSet rs, int rowNum) throws SQLException {
				String sid = rs.getString(1);
				String title = rs.getString(2);
				String grade = rs.getString(3);
				int numOfQuestion = rs.getInt(4);
				Date createSheetDate = rs.getDate(6);
				int limitTime = rs.getInt(7);
				String completed = rs.getString(8);
				String formal = rs.getString(9);
				if (formal.equalsIgnoreCase("Y")) {
					ExamSheet fsheet = new ExamSheet();
					fsheet.setCompleted(completed);
					fsheet.setCreateSheetDate(createSheetDate);
					fsheet.setExaminer(examiner);
					fsheet.setGrade(grade);
					fsheet.setLimitTime(limitTime);
					fsheet.setNumOfQuestion(numOfQuestion);
					fsheet.setSid(sid);
					fsheet.setTitle(title);
					return fsheet;
				} else {
					return new Sheet(sid, title, grade, numOfQuestion, examiner, createSheetDate, limitTime, completed);
				}
			}
		}, examiner);
	}

	@Override
	public List<Sheet> findAllFormalSheets() {
		sql = "select sid, title, grade, num_of_question, examiner, create_sheet_date, limit_time, completed "
				+ "from sheet " + "where formal='Y'";
		return jdbcTemplate.query(sql, new RowMapper<Sheet>() {

			@Override
			public Sheet mapRow(ResultSet rs, int rowNum) throws SQLException {
				String sid = rs.getString(1);
				String title = rs.getString(2);
				String grade = rs.getString(3);
				int numOfQuestion = rs.getInt(4);
				String examiner = rs.getString(5);
				Date createSheetDate = rs.getDate(6);
				int limitTime = rs.getInt(7);
				String completed = rs.getString(8);
				ExamSheet fsheet = new ExamSheet();
				fsheet.setCompleted(completed);
				fsheet.setCreateSheetDate(createSheetDate);
				fsheet.setExaminer(examiner);
				fsheet.setGrade(grade);
				fsheet.setLimitTime(limitTime);
				fsheet.setNumOfQuestion(numOfQuestion);
				fsheet.setSid(sid);
				fsheet.setTitle(title);
				return fsheet;
			}
		});
	}
}
