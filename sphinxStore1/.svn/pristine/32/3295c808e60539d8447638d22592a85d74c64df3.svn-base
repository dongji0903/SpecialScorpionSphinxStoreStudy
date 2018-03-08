package com.sphinx.beautea.common.service;

import java.util.List;
import java.util.Map;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.common.domain.Board;

public interface BoardService {

	public void addBoard(Board board);
	
	public void updateBoard(Board board);
	
	public void deleteBoard(Board board);
	
	public Board getBoardById(String boardId);
	
	public List<Board> getBoardList(int page);
	
	public List<Board> getBoardListByCustomerId(String customerId, int page);
	
	public List<Board> getDeleteBoardList(int page);
	
	public int countBoards(boolean del);
	
	public int countBoardsByCustomerId(String customerId, boolean del);
	
	public Map<String, List<Board>> updateMainBoard(Category category, 
			Map<String, List<Board>> boardMap);
	
}
