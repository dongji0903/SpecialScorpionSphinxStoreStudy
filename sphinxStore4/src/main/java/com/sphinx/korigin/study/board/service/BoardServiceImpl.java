package com.sphinx.korigin.study.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.korigin.study.board.dao.BoardDao;
import com.sphinx.korigin.study.board.domain.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public void createBoard(Board board) {
		boardDao.insertBoard(board);
	}

	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);

	}

	@Override
	public void removeBoard(String num) {
		boardDao.deleteBoard(num);

	}

	@Override
	public Board findBoard(String num) {
		return boardDao.selectBoard(num);
	}

	@Override
	public List<Board> findBoardsByCategory(String category) {
		return boardDao.selectBoardByCategory(category);
	}

	@Override
	public List<Board> findBoardsByText(String category, String group,
			String text) {
		return boardDao.searchBoard(category, group, text);
	}

	@Override
	public void addReadCount(String num) {
		boardDao.updateReadCount(num);
	}

	@Override
	public List<Board> offsetBoardByCategory(int offset, int count,
			String category) {
		return boardDao.adaptedBoardForPage(offset, count, category);
	}

	@Override
	public Integer findMaxBoardCountByCategory(String category) {
		return boardDao.getMaxCount(category);
	}

	@Override
	public List<Board> creatMiniBoard(String category, int num) {
		return boardDao.makeMiniBoard(category, num);
	}

}
