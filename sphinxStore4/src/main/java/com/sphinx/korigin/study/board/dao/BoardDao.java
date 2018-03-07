package com.sphinx.korigin.study.board.dao;

import java.util.List;

import com.sphinx.korigin.study.board.domain.Board;

public interface BoardDao {

	List<Board> selectAllBoards();

	void insertBoard(Board board);

	void updateReadCount(String num);

	Board selectBoard(String num);

	List<Board> selectBoardByCategory(String category);

	List<Board> searchBoard(String category, String group, String text);

	List<Board> adaptedBoardForPage(int offset, int count, String category);

	Integer getMaxCount(String category);

	List<Board> makeMiniBoard(String category, int num);

	void updateBoard(Board board);

	void deleteBoard(String num);
}
