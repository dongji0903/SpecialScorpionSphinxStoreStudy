package com.sphinx.beautea.category.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.beautea.category.dao.LinkBnCDao;
import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.domain.LinkBnC;
import com.sphinx.beautea.category.service.LinkBnCService;
import com.sphinx.beautea.common.domain.Board;
import com.sphinx.beautea.common.domain.PageUtil;
import com.sphinx.beautea.common.service.BoardService;

@Service
public class LinkBnCServiceImpl implements LinkBnCService {
	@Autowired
	private LinkBnCDao linkDao;
	@Autowired
	BoardService boardService;
	
	@Override
	public void addLinkBnC(LinkBnC linkBnC) {
		// TODO Auto-generated method stub
		linkDao.addLinkBnC(linkBnC);
	}

	@Override
	public void updateLinkBnC(LinkBnC linkBnC) {
		// TODO Auto-generated method stub
		linkDao.updateLinkBnC(linkBnC);
	}

	@Override
	public void deleteLinkBnC(LinkBnC linkBnC) {
		// TODO Auto-generated method stub
		linkDao.deleteLinkBnC(linkBnC);
	}

	@Override
	public LinkBnC getLinkBnCById(String linkId) {
		// TODO Auto-generated method stub
		return linkDao.findLinkBnCById(linkId);
	}

	@Override
	public List<LinkBnC> getLinkBnCListByCategoryId(String categoryId) {
		// TODO Auto-generated method stub
		return linkDao.findLinkBnCListByCategoryId(categoryId);
	}

	@Override
	public List<LinkBnC> getLinkBnCListByCategoryId(int page, String categoryId) {
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		int start = amount * (page - 1);
		return linkDao.findLinkBnCListByCategoryId(start, amount, categoryId);
	}

	@Override
	public List<LinkBnC> getLinkBnCListByBoardId(String boardId) {
		// TODO Auto-generated method stub
		return linkDao.findLinkBnCListByBoardId(boardId);
	}

	@Override
	public int countBoardByCategoryId(String categoryId, boolean del) {
		// TODO Auto-generated method stub
		return linkDao.countBoardByCategoryId(categoryId, del);
	}

	@Override
	public List<Board> getProductListByCategoryId(String categoryId) {
		List<LinkBnC> link = getLinkBnCListByCategoryId(categoryId);
		List<Board> blist = new ArrayList<>();
		for(LinkBnC l : link) {
			blist.add(boardService.getBoardById(l.getBoardId()));
		}
		return blist;
	}

	@Override
	public List<Category> getCategoryListByProductId(String boardId,
			Map<String, Category> categoryMap) {
		List<LinkBnC> link = getLinkBnCListByBoardId(boardId);
		List<Category> clist = new ArrayList<>();
		for(LinkBnC l : link) {
			clist.add(categoryMap.get(l.getCategoryId()));
		}
		return clist;
	}
}
