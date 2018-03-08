package com.sphinx.korigin.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.member.domain.Member;
import com.sphinx.korigin.member.domain.pointLog;

@Repository("MemberDao")
public class MemberDaoImpl extends AbstractDaoJdbc implements MemberDao {
	/*
	 * @Autowired private JdbcTemplate jdbcTemplate;
	 */

	@Override
	public String insertMember(Member member) {
		String mid = generateID("MEMBER", "MID", "M");
		String sql = "INSERT INTO Member(mid,name, nickname, pass, id ,birth, email, addr," + "phone, member_type)"
				+ "VALUES(?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,
				new Object[] { mid, member.getName(), member.getNickName(), member.getPassword(), member.getSphixId(),
						member.getBirth(), member.getEmail(), member.getAddr(), member.getPhoneNum(),
						member.getMemberType() });
		return mid;
	}

	@Override
	public Member selectMember(String id, String pwd) {
		String sql = "select mid, id, pass,name,nickname,email, member_type, point " + "from member where id = ?";

		try {
			return jdbcTemplate.queryForObject(sql, new RowMapper<Member>() {
				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Member member = new Member();
					member.setMemberId(rs.getString("mid"));
					member.setSphixId(rs.getString("id"));
					member.setName(rs.getString("name"));
					member.setNickName(rs.getString("nickname"));
					member.setPassword(rs.getString("pass"));
					member.setMemberType(rs.getString("member_type"));
					member.setPoint(rs.getInt("point"));
					member.setEmail(rs.getString("email"));
					return member;
				}
			}, id);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int countByMemberId(String id) {
		String sql = "select count(*) from member where id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {
				@Override
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
					int count = rs.getInt(1);
					return count;
				}
			}, id);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int findPoint(String id) {
		String sql = "SELECT point FROM member WHERE Id = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int point = rs.getInt(1);
				return point;
			}
		}, id);
	}

	@Override
	public Integer getMaxCount(String id) {
		String sql = "Select count(*) From pointLog where member_Id = ?";

		return jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int count = rs.getInt(1);
				return count;
			}
		}, id);
	}

	@Override
	public List<pointLog> getPageLogList(int offset, int count, String id) {
		String sql = "select point_Id, add_point, reduce_point, total_Point,"
				+ " changed_Date from pointLog where member_Id = ?" + " order by point_Id desc offset "
				+ String.valueOf(offset) + " rows fetch next " + String.valueOf(count) + " rows only";

		return jdbcTemplate.query(sql, new RowMapper<pointLog>() {

			@Override
			public pointLog mapRow(ResultSet rs, int rowNum) throws SQLException {
				pointLog log = new pointLog();
				log.setNum(rs.getInt(1));
				log.setAddPoint(rs.getInt(2));
				log.setReducePoint(rs.getInt(3));
				log.setTotalPoint(rs.getInt(4));
				log.setDate(rs.getTimestamp(5));
				return log;
			}
		}, id);
	}

	@Override
	public List<pointLog> getPointLog(String id) {
		String sql = "SELECT point_Id, add_point, reduce_point, total_Point,"
				+ " changed_Date FROM PointLog WHERE member_Id = ?";

		return jdbcTemplate.query(sql, new RowMapper<pointLog>() {

			@Override
			public pointLog mapRow(ResultSet rs, int rowNum) throws SQLException {
				pointLog log = new pointLog();
				log.setNum(rs.getInt(1));
				log.setAddPoint(rs.getInt(2));
				log.setReducePoint(rs.getInt(3));
				log.setTotalPoint(rs.getInt(4));
				log.setDate(rs.getTimestamp(5));
				return log;
			}
		}, id);
	}

	@Override
	public String findLevel(String id) {
		String sql = "SELECT level FROM member WHERE Id = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String level = rs.getString(1);
				return level;
			}
		}, id);
	}

	@Override
	public int findExp(String id) {
		String sql = "SELECT exp FROM member WHERE Id = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int exp = rs.getInt(1);
				return exp;
			}
		}, id);
	}

	@Override
	public boolean isExistingNickName(String nickName) {
		String sql = "select id from member where nick_name = ?";
		try {
			jdbcTemplate.queryForObject(sql, new RowMapper<String>() {
				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					String id = rs.getString(1);
					return id;
				}
			}, nickName);
		} catch (NullPointerException e) {
			return true;
		}
		return false;
	}

	@Override
	public List<Member> findAllMembers() {
		String sql = "select id, name, nick_name, password, email, addr, phone_num," + " point from member";

		return jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setSphixId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setNickName(rs.getString("nick_name"));
				member.setPassword(rs.getString("password"));
				member.setEmail(rs.getString("email"));
				member.setAddr(rs.getString("addr"));
				member.setPhoneNum(rs.getString("phone_num"));
				member.setPoint(rs.getInt("point"));
				return member;
			}
		});
	}

	@Override
	public List<Member> findAllAdministrators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyMember(Member member) {
		String sql = "update member set name =? , nick_name =?, password = ?,"
				+ " email = ?, addr = ?, phone_num = ?, where id = ?";
		jdbcTemplate.update(sql, new Object[] { member.getName(), member.getNickName(), member.getPassword(),
				member.getEmail(), member.getAddr(), member.getPhoneNum(), member.getSphixId() });
	}

	@Override
	public void deleteMember(String id) {
		String sql = "delete from member where id = ?";
		jdbcTemplate.update(sql, new Object[] { id });
	}

	@Override
	public void updatePoint(String id, int point) {
		String sql = "update member set point = ? where id = ?";
		jdbcTemplate.update(sql, new Object[] { point, id });
	}

	@Override
	public void updateLevel(String id, String level) {
		String sql = "update member set level = ? where id = ?";
		jdbcTemplate.update(sql, new Object[] { level, id });
	}

	@Override
	public void updateExp(String id, int exp) {
		String sql = "update member set exp = ? where id = ?";
		jdbcTemplate.update(sql, new Object[] { id, exp });
	}

	@Override
	public void addPointLog(String id, String point, String totalPoint, Timestamp date) {
		String sql = "INSERT INTO PointLog(member_Id, add_point, total_Point," + " changed_Date) VALUES(?, ?, ?, ?)";

		jdbcTemplate.update(sql, new Object[] { id, point, totalPoint, date });
	}

	@Override
	public void reducePointLog(String id, String point, String totalPoint, Timestamp date) {
		String sql = "INSERT INTO PointLog(member_Id, reduce_point, total_Point" + ", changed_Date) VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { id, point, totalPoint, date });
	}
}
