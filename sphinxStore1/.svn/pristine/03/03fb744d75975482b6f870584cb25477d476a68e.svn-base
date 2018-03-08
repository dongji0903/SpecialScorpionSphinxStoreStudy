package com.sphinx.beautea.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.domain.LinkBnC;
import com.sphinx.beautea.category.service.LinkBnCService;
import com.sphinx.beautea.common.dao.BoardDao;
import com.sphinx.beautea.common.domain.Board;
import com.sphinx.beautea.common.domain.PageUtil;
import com.sphinx.beautea.common.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private LinkBnCService linkBnCService;
	
	@Override
	public void addBoard(Board board) {

		boardDao.addBoard(board);
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(Board board) {
		// TODO Auto-generated method stub
		boardDao.deleteBoard(board);
	}

	@Override
	public Board getBoardById(String boardId) {
		// TODO Auto-generated method stub
		return boardDao.findBoardById(boardId);
	}

	@Override
	public List<Board> getBoardList(int page) {
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		int start = amount * (page - 1);
		return boardDao.findBoardList(start, amount);
	}

	@Override
	public List<Board> getDeleteBoardList(int page) {
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		int start = amount * (page - 1);
		return boardDao.findDeleteBoardList(start, amount);
	}

	@Override
	public int countBoards(boolean del) {
		// TODO Auto-generated method stub
		return boardDao.countBoards(del);
	}

	@Override
	public Map<String, List<Board>> updateMainBoard(Category category,
			Map<String, List<Board>> boardMap) {
		
		List<LinkBnC> link_list = linkBnCService.getLinkBnCListByCategoryId(category.getCategoryId());
		List<Board> posts = new ArrayList<>();
		
		for(LinkBnC link : link_list) {
			Board p = getBoardById(link.getBoardId());
			if (p != null) {
				posts.add(p);
			}
			
			if (posts.isEmpty() == false) {
				boardMap.put(category.getCategoryId(), posts);
			}
		}
		
		return boardMap;
	}

	@Override
	public List<Board> getBoardListByCustomerId(String customerId, int page) {
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		int start = amount * (page - 1);
		return boardDao.findBoardListByCustomerId(customerId, start, amount);
	}

	@Override
	public int countBoardsByCustomerId(String customerId, boolean del) {
		// TODO Auto-generated method stub
		return boardDao.countBoardsByCustomerId(customerId, del);
	}

}
