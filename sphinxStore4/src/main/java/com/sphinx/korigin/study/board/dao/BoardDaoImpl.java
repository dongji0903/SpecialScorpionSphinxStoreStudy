package com.sphinx.korigin.study.board.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.sphinx.korigin.common.dao.AbstractDaoJdbc;
import com.sphinx.korigin.study.board.domain.Board;

@Repository("BoardDao")
public class BoardDaoImpl extends AbstractDaoJdbc implements BoardDao {

	public List<Board> selectAllBoards() {
		String sql = "SELECT * FROM board Order by num desc";

		return jdbcTemplate.query(sql, new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setNickName(rs.getString("nickname"));
				board.setEmail(rs.getString("board_email"));
				board.setTitle(rs.getString("board_title"));
				board.setUrl(rs.getString("board_url"));
				board.setContent(rs.getString("board_content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getTimestamp("writedate"));
				board.setCategory(rs.getString("category"));
				return board;
			}
		});
	}

	public void insertBoard(Board board) {
		String sql = "INSERT INTO board(nickname, board_email, board_title, "
				+ "board_url, board_content, writedate, category)"
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,
				new Object[] { board.getNickName(), board.getEmail(),
						board.getTitle(), board.getUrl(), board.getContent(),
						new Date(board.getWritedate().getTime()),
						board.getCategory() });
	}

	public void updateReadCount(String num) {
		String sql = "update board set readcount = readcount + 1 where num = ?";

		jdbcTemplate.update(sql, new Object[] { num });
	}

	public Board selectBoard(String num) {
		String sql = "SELECT * FROM board WHERE num = ?";

		return jdbcTemplate.queryForObject(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setNickName(rs.getString("nickname"));
				board.setEmail(rs.getString("board_email"));
				board.setUrl(rs.getString("board_url"));
				board.setTitle(rs.getString("board_title"));
				board.setContent(rs.getString("board_content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getTimestamp("writedate"));
				board.setCategory(rs.getString("category"));
				return board;
			}
		}, num);
	}

	public List<Board> selectBoardByCategory(String category) {
		String sql = "SELECT * FROM board WHERE category = ? Order by num desc";

		return jdbcTemplate.query(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setNickName(rs.getString("nickname"));
				board.setEmail(rs.getString("board_email"));
				board.setUrl(rs.getString("board_url"));
				board.setTitle(rs.getString("board_title"));
				board.setContent(rs.getString("board_content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getTimestamp("writedate"));
				board.setCategory(rs.getString("category"));
				return board;
			}
		}, category);
	}

	public List<Board> searchBoard(String category, String group, String text) {
		String sql = "SELECT * FROM board WHERE category = ? and " + group
				+ " like ?";
		String text_1 = "%" + text + "%";

		return jdbcTemplate.query(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setNickName(rs.getString("nickname"));
				board.setEmail(rs.getString("board_email"));
				board.setUrl(rs.getString("board_url"));
				board.setTitle(rs.getString("board_title"));
				board.setContent(rs.getString("board_content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getTimestamp("writedate"));
				board.setCategory(rs.getString("category"));
				return board;
			}
		}, category, text_1);
	}

	public List<Board> adaptedBoardForPage(int offset, int count,
			String category) {
		String sql = "select * from board where category = ? order by num desc offset "
				+ String.valueOf(offset) + " rows fetch next "
				+ String.valueOf(count) + " rows only";

		return jdbcTemplate.query(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setNickName(rs.getString("nickname"));
				board.setEmail(rs.getString("board_email"));
				board.setUrl(rs.getString("board_url"));
				board.setTitle(rs.getString("board_title"));
				board.setContent(rs.getString("board_content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getTimestamp("writedate"));
				board.setCategory(rs.getString("category"));
				return board;
			}
		}, category);

	}

	public Integer getMaxCount(String category) {
		String sql = "Select count(*) From Board where category = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				int count = rs.getInt(1);
				return count;
			}
		}, category);
	}

	public List<Board> makeMiniBoard(String category, int num) {
		String sql = "SELECT * FROM board WHERE category = ? Order by num desc "
				+ "offset 0 rows fetch next" + String.valueOf(num)
				+ " rows only";

		return jdbcTemplate.query(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setNum(rs.getInt("num"));
				board.setNickName(rs.getString("nickname"));
				board.setEmail(rs.getString("board_email"));
				board.setUrl(rs.getString("board_url"));
				board.setTitle(rs.getString("board_title"));
				board.setContent(rs.getString("board_content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getTimestamp("writedate"));
				board.setCategory(rs.getString("category"));
				return board;
			}
		}, category);
	}

	public void updateBoard(Board board) {
		String sql = "update board set nickname = ?, board_email = ?"
				+ ", board_title = ?, board_url = ?, board_content = ?"
				+ " where num = ?";

		jdbcTemplate.update(sql,
				new Object[] { board.getNickName(), board.getEmail(),
						board.getTitle(), board.getUrl(), board.getContent() },
				board.getNum());
	}

	public void deleteBoard(String num) {
		String sql = "delete from board where num = ?";
		jdbcTemplate.update(sql, new Object[] { num });
	}
}
