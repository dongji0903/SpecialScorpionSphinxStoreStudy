package com.sphinx.korigin.study.study.dao.solution;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.study.study.dao.question.DistractorDao;
import com.sphinx.korigin.study.study.dao.question.DistractorDaoJdbcImpl;
import com.sphinx.korigin.study.study.domain.question.Distractor;
import com.sphinx.korigin.study.study.domain.solution.*;

/**
 * @author USER
 *
 */
@Repository("SolutionDao")
public class SolutionDaoJdbcImpl extends AbstractDaoJdbc implements SolutionDao {
	String sql;
	DistractorDao dd = new DistractorDaoJdbcImpl();

	public static void main(String[] args) {
		SolutionDao sd = new SolutionDaoJdbcImpl();
		System.out.println(sd.findSolutionOfQuestion("Q000013"));
	}

	@Override
	public void createSolution(Solution sol) {
		String id = generateID("SOLUTION", "SOLID", "SOL");
		String sql = "insert into Solution(solid, qid, sub_Answer, S_type, num_Of_Answer, did_list)"
				+ " values (?,?, ?, ?, ?, ?)";
		Object[] objects;
		if (sol instanceof ObjectiveSolution) {
			ObjectiveSolution obsol = (ObjectiveSolution) sol;
			String didList = "";
			List<Distractor> findD = obsol.getDList();
			for (Distractor d : findD) {
				int index = findD.indexOf(d);
				didList += d.getDid();
				if (index != (findD.size() - 1)) {
					didList += "/";
				}
			}
			objects = new Object[] { id, sol.getQid(), null, "o", obsol.getNumOfAnswer(), didList };
		} else {
			SubjectiveSolution subsol = (SubjectiveSolution) sol;
			objects = new Object[] { id, sol.getQid(), subsol.getSubAnswer(), "s", 0, null };
		}

		jdbcTemplate.update(sql, objects);
	}

	/**
	 * Distractor 부분은 서비스에서 채우자
	 */
	@Override
	public List<Solution> findAllSolutions() {
		String sql = "select solid, qid, sub_Answer, S_type, num_Of_Answer, did_list" + " from Solution";
		return jdbcTemplate.query(sql, new RowMapper<Solution>() {

			@Override
			public Solution mapRow(ResultSet rs, int rowNum) throws SQLException {
				String solid = rs.getString(1);
				String qid = rs.getString(2);
				String subAnswer = rs.getString(3);
				String Stype = rs.getString(4);
				int numOfAnswer = rs.getInt(5);
				String didlist = rs.getString(6);

				if (Stype.equalsIgnoreCase("s")) {
					return new SubjectiveSolution(solid, qid, subAnswer);
				} else {
					String[] did = didlist.split("/");
					List<Distractor> distractorList = new ArrayList<Distractor>();
					for (String d : did) {
						distractorList.add(new Distractor(d, null, qid));
					}
					return new ObjectiveSolution(solid, qid, numOfAnswer, distractorList);
				}
			}
		});
	}

	/**
	 * Distractor 부분은 서비스에서 채우자
	 */
	@Override
	public Solution findSolution(String solid) {
		String sql = "select solid, qid, sub_Answer, S_type, num_Of_Answer, did_list" + " from Solution "
				+ "where solid=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Solution>() {

			@Override
			public Solution mapRow(ResultSet rs, int rowNum) throws SQLException {
				String qid = rs.getString(2);
				String subAnswer = rs.getString(3);
				String Stype = rs.getString(4);
				int numOfAnswer = rs.getInt(5);
				String didlist = rs.getString(6);

				if (Stype.equalsIgnoreCase("s")) {
					return new SubjectiveSolution(solid, qid, subAnswer);
				} else {
					String[] did = didlist.split("/");
					List<Distractor> distractorList = new ArrayList<Distractor>();
					for (String d : did) {
						distractorList.add(new Distractor(d, null, qid));
					}
					return new ObjectiveSolution(solid, qid, numOfAnswer, distractorList);
				}
			}
		}, solid);
	}

	@Override
	public void updateSolution(Solution sol) {
		String sql = "update solution set  qid=?, sub_Answer=?, S_type=?, num_Of_Answer=?, did_list=?"
				+ "where solid=?";
		Object[] objects;
		if (sol instanceof ObjectiveSolution) {
			ObjectiveSolution osol = (ObjectiveSolution) sol;
			String aidList = "";
			for (Distractor d : osol.getDList()) {
				aidList += (d.getDid() + "/");
			}
			objects = new Object[] { sol.getQid(), null, "o", osol.getNumOfAnswer(), aidList };
		} else {
			SubjectiveSolution ssol = (SubjectiveSolution) sol;
			objects = new Object[] { sol.getQid(), ssol.getSubAnswer(), "s", 0, null };
		}
		jdbcTemplate.update(sql, objects);
	}

	/**
	 * Distractor는 서비스에서 채우자
	 */
	@Override
	public Solution findSolutionOfQuestion(String qid) {
		String sql = "select solid, qid, sub_Answer, S_type, num_Of_Answer, did_list, text, file_url"
				+ " from Solution " + "where qid=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Solution>() {

			@Override
			public Solution mapRow(ResultSet rs, int rowNum) throws SQLException {
				String solid = rs.getString(1);
				String subAnswer = rs.getString(3);
				String Stype = rs.getString(4);
				int numOfAnswer = rs.getInt(5);
				String didlist = rs.getString(6);
				String text = rs.getString(7);
				String fileUrl = rs.getString(8);
				if (Stype.equalsIgnoreCase("s")) {
					SubjectiveSolution ssolution = new SubjectiveSolution(solid, qid, subAnswer);
					ssolution.setText(text);
					ssolution.setFileUrl(fileUrl);
					return ssolution;
				} else {
					String[] dids = didlist.split("/");
					List<Distractor> distractorList = new ArrayList<Distractor>();
					for (String s : dids) {
						System.out.println(s);
						if (s != null) {
							distractorList.add(new Distractor(s, null, qid));
						}
					}
					ObjectiveSolution osolution = new ObjectiveSolution(solid, qid, numOfAnswer, distractorList);
					osolution.setText(text);
					osolution.setFileUrl(fileUrl);
					return osolution;
				}
			}
		}, qid);
	}
}
