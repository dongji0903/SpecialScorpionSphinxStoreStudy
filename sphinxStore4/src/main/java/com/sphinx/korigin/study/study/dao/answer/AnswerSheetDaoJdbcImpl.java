package com.sphinx.korigin.study.study.dao.answer;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.study.study.domain.answer.AnswerSheet;
import com.sphinx.korigin.study.study.domain.answer.SheetTestRecord;
@Repository("AnswerSheetDao")
public class AnswerSheetDaoJdbcImpl extends AbstractDaoJdbc
		implements AnswerSheetDao {
	String sql;

	@Override
	public String createAnswerSheet(AnswerSheet as) {
		String asid = generateID("ANSWERSHEET", "ASID", "AS");
		sql = "insert into answersheet (asid, sid, id, total_score, test_date) "
				+ "values(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,
				new Object[] { asid, as.getSid(), as.getTester(),
						as.getTotalScore(),
						new java.sql.Date(as.getTestDate().getTime()) });
		return asid;
	}

	@Override
	public List<AnswerSheet> findAllAnswerSheets() {
		sql = "select asid, sid, total_score, test_date from answersheet";
		return jdbcTemplate.query(sql, new RowMapper<AnswerSheet>() {

			@Override
			public AnswerSheet mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				String asid = rs.getString(1);
				String sid = rs.getString(2);
				double totalScore = rs.getDouble(3);
				Date testDate = rs.getDate(4);
				return new AnswerSheet(asid, sid, totalScore, testDate);
			}
		});
	}

	@Override
	public AnswerSheet findAnswerSheet(String asid) {
		sql = "select sid,id, total_score, test_date from answersheet"
				+ " where asid = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<AnswerSheet>() {

			@Override
			public AnswerSheet mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				String sid = rs.getString(1);
				String id = rs.getString(2);
				double totalScore = rs.getDouble(3);
				Date testDate = rs.getDate(4);

				AnswerSheet findAnswerSheet = new AnswerSheet(sid, id, totalScore,
						testDate);
				findAnswerSheet.setAsid(asid);
				return findAnswerSheet;
			}
		}, asid);
	}

	@Override
	public void updateAnswerSheet(AnswerSheet as) {
		sql = "update AnswerSheet set sid = ?, total_score = ?, test_date = ? "
				+ "where asid = ?";
		jdbcTemplate.update(sql, new Object[] {
				as.getSid(),as.getTotalScore(),as.getTestDate(),as.getAsid()
		});
	}

	@Override
	public void deleteAnswerSheet(String asid) {
		sql = "delete from AnswerSheet where asid = ?";
		jdbcTemplate.update(sql, asid);
		
	}

	@Override
	public List<AnswerSheet> findAnswerSheetsForListOfMember(String id,
			int skip, int count) {
		sql = "select asid,sid,total_score,test_date from answersheet where id=? order by asid desc offset "
				+ String.valueOf(skip) + " rows fetch next "
				+ String.valueOf(count) + " rows only";
		return jdbcTemplate.query(sql, new Object[] {
				id,skip,count
		}, new RowMapper<AnswerSheet>() {

			@Override
			public AnswerSheet mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				String asid = rs.getString(1);
				String sid = rs.getString(2);
				double totalScore = rs.getDouble(3);
				Date testDate = rs.getDate(4);
				return new AnswerSheet(asid, sid, id, totalScore,
						testDate, null);
			}
		});
	}

	@Override
	public int getNumberOfAnswerSheets(String id) {
		sql = "select count(asid) from answersheet where id=?";
		
		return jdbcTemplate.queryForObject(sql, Integer.class, id);
	}

	@Override
	public SheetTestRecord getSheetRecord(String sid) {
		sql = "select count(*),min(total_score),max(total_score),avg(total_score) from answersheet where sid=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<SheetTestRecord>() {

			@Override
			public SheetTestRecord mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				SheetTestRecord testRecord = new SheetTestRecord();
				testRecord.setSid(sid);
				testRecord.setCount(rs.getInt(1));
				testRecord.setMinScore(rs.getDouble(2));
				testRecord.setMaxScore(rs.getDouble(3));
				testRecord.setAvgScore(rs.getDouble(4));
				return testRecord;
			}
			
		},sid);
	}

	public static void main(String[] args) {
		AnswerSheetDao asd = new AnswerSheetDaoJdbcImpl();
		System.out.println(asd.getSheetRecord("S000001"));
	}

	@Override
	public Map<String, Object> getMyRecord(String id) {
		sql = "select min(total_score),max(total_score),avg(total_score) from answersheet where id=?";
		return jdbcTemplate.queryForMap(sql, new Object[] {id}, new int[]{java.sql.Types.FLOAT,java.sql.Types.FLOAT,java.sql.Types.FLOAT});
	}
}
