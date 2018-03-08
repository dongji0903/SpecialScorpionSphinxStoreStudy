package com.sphinx.korigin.study.board.service;

import java.util.List;

import com.sphinx.korigin.study.board.domain.Board;

public interface BoardService {
	public void createBoard(Board board);

	public void updateBoard(Board board);

	public void removeBoard(String num);

	public Board findBoard(String num);

	public List<Board> findBoardsByCategory(String category);

	public List<Board> findBoardsByText(String category, String group, String text);

	public void addReadCount(String num);

	public List<Board> offsetBoardByCategory(int offset, int count, String category);

	public Integer findMaxBoardCountByCategory(String category);

	public List<Board> creatMiniBoard(String category, int num);

}
