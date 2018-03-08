package com.sphinx.beautea.common.dao;

import java.util.List;

import com.sphinx.beautea.common.domain.Board;

public interface BoardDao {

	public void addBoard(Board board);
	
	public void updateBoard(Board board);
	
	public void deleteBoard(Board board);
	
	public Board findBoardById(String boardId);
	
	public List<Board> findBoardList(int start, int amount);
	
	public List<Board> findBoardListByCustomerId(String customerId, int start, int amount);
	
	public List<Board> findDeleteBoardList(int start, int amount);
	
	public int countBoards(boolean del);
	
	public int countBoardsByCustomerId(String customerId, boolean del);
	
}
