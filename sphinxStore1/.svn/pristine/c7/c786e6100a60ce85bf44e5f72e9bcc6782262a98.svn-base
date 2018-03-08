package com.sphinx.beautea.category.dao;

import java.util.List;

import com.sphinx.beautea.category.domain.LinkBnC;

public interface LinkBnCDao {

	public void addLinkBnC(LinkBnC linkBnC);
	
	public void updateLinkBnC(LinkBnC linkBnC);
	
	public void deleteLinkBnC(LinkBnC linkBnC);
	
	public LinkBnC findLinkBnCById(String linkId);
	
	public List<LinkBnC> findLinkBnCListByCategoryId(String categoryId);
	
	public List<LinkBnC> findLinkBnCListByCategoryId(int start, int amount, 
			String categoryId);
	
	public List<LinkBnC> findLinkBnCListByBoardId(String boardId);
	
	public int countBoardByCategoryId(String categoryId, boolean del);
}
