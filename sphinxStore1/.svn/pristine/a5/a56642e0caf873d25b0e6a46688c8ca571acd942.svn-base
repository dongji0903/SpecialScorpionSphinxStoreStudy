package com.sphinx.beautea.category.service;

import java.util.List;
import java.util.Map;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.domain.LinkBnC;
import com.sphinx.beautea.common.domain.Board;

public interface LinkBnCService {

	public void addLinkBnC(LinkBnC linkBnC);
	
	public void updateLinkBnC(LinkBnC linkBnC);
	
	public void deleteLinkBnC(LinkBnC linkBnC);
	
	public LinkBnC getLinkBnCById(String linkId);
	
	public List<LinkBnC> getLinkBnCListByCategoryId(String categoryId);
	
	public List<LinkBnC> getLinkBnCListByCategoryId(int page, String categoryId);
	
	public List<LinkBnC> getLinkBnCListByBoardId(String boardId);
	
	public List<Board> getProductListByCategoryId(String categoryId);
	
	public List<Category> getCategoryListByProductId(String boardId, 
			Map<String, Category> categoryMap);
	
	public int countBoardByCategoryId(String categoryId, boolean del);
}
