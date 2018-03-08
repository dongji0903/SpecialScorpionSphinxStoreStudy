package com.sphinx.beautea.common.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sphinx.beautea.common.dao.BoardDao;
import com.sphinx.beautea.common.domain.Board;
import com.sphinx.beautea.common.primary.CreatePrimary;

@Repository("BoardDao")
public class BoardDaojdbcImpl implements BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplete;
	
	@Override
	public void addBoard(Board board) {
		String sql = "insert into Board (id, title, types, writeDate, del, "
				+ "fileName, content, customerId) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		CreatePrimary primary = CreatePrimary.getInstance();
		String id = "bo" + primary.createPrimaryKey();
		Date date = new java.sql.Date(board.getWriteDate().getTime());
		
		jdbcTemplete.update(sql, new Object[] {id, board.getTitle(), 
				board.getType(), date, false, board.getFileName(), 
				board.getContent(), board.getCustomerId()});
	}

	
	
	
	@Override
	public void updateBoard(Board board) {
		String sql = "update board set title = ?, types = ?, "
				+ "del = ?, fileName = ?, content = ?, "
				+ "where id = ?";
		
		jdbcTemplete.update(sql, new Object[] {board.getTitle(), board.getType(), 
				board.isDel(), board.getFileName(), board.getContent(), 
				board.getBoardId()});
	}

	
	
	
	@Override
	public void deleteBoard(Board board) {
		String sql = "delete from board where id = ?";
		
		jdbcTemplete.update(sql, new Object[] {board.getBoardId()});
	}

	
	
	
	@Override
	public Board findBoardById(String boardId) {
		String sql = "selete id, title, types, writeDate, del, fileName, "
				+ "content, customerId from Board where id = ?";
		
		return jdbcTemplete.queryForObject(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int arg1) throws SQLException {
				Board board = new Board();
				board.setBoardId(boardId);
				board.setTitle(rs.getString(2));
				board.setType(rs.getInt(3));
				board.setWriteDate(rs.getDate(4));
				board.setDel(rs.getBoolean(5));
				board.setFileName(rs.getString(6));
				board.setContent(rs.getString(7));
				board.setCustomerId(rs.getString(8));
				return board;
			}
			
		}, boardId);
	}

	
	
	
	@Override
	public List<Board> findBoardList(int start, int amount) {
		String sql = "selete id, title, types, writeDate, del, fileName, "
				+ "content, customerId from Board where del = ? "
				+ "ORDER BY writeDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		
		return jdbcTemplete.query(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int arg1) throws SQLException {
				Board board = new Board();
				board.setBoardId(rs.getString(1));
				board.setTitle(rs.getString(2));
				board.setType(rs.getInt(3));
				board.setWriteDate(rs.getDate(4));
				board.setDel(rs.getBoolean(5));
				board.setFileName(rs.getString(6));
				board.setContent(rs.getString(7));
				board.setCustomerId(rs.getString(8));
				return board;
			}
			
		}, new Object[] {true, start, amount});
	}

	
	
	
	@Override
	public List<Board> findDeleteBoardList(int start, int amount) {
		String sql = "selete id, title, types, writeDate, del, fileName, "
				+ "content, customerId from Board where del = ? "
				+ "ORDER BY writeDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		
		return jdbcTemplete.query(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int arg1) throws SQLException {
				Board board = new Board();
				board.setBoardId(rs.getString(1));
				board.setTitle(rs.getString(2));
				board.setType(rs.getInt(3));
				board.setWriteDate(rs.getDate(4));
				board.setDel(rs.getBoolean(5));
				board.setFileName(rs.getString(6));
				board.setContent(rs.getString(7));
				board.setCustomerId(rs.getString(8));
				return board;
			}
			
		}, new Object[] {false, start, amount});
	}

	
	
	
	@Override
	public int countBoards(boolean del) {
		String sql = "select count(id) from Board where del = ?";
		
		return jdbcTemplete.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				int amount = rs.getInt(1);
				return amount;
			}
			
		}, del);
	}




	@Override
	public List<Board> findBoardListByCustomerId(String customerId, int start, 
			int amount) {
		String sql = "selete id, title, types, writeDate, del, fileName, "
				+ "content, customerId from Board where del = ? and customerId = ? "
				+ "ORDER BY writeDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		
		return jdbcTemplete.query(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int arg1) throws SQLException {
				Board board = new Board();
				board.setBoardId(rs.getString(1));
				board.setTitle(rs.getString(2));
				board.setType(rs.getInt(3));
				board.setWriteDate(rs.getDate(4));
				board.setDel(rs.getBoolean(5));
				board.setFileName(rs.getString(6));
				board.setContent(rs.getString(7));
				board.setCustomerId(customerId);
				return board;
			}
			
		}, new Object[] {false, customerId, start, amount});
	}




	@Override
	public int countBoardsByCustomerId(String customerId, boolean del) {
		String sql = "select count(id) from Board where customerId = ? and del = ?";
		
		return jdbcTemplete.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				int amount = rs.getInt(1);
				return amount;
			}
			
		}, customerId, del);
	}

	
	
}
