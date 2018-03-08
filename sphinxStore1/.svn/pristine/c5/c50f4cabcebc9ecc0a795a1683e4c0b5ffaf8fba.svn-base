package com.sphinx.beautea.category.dao;

import java.util.List;

import com.sphinx.beautea.category.domain.LinkInC;

public interface LinkInCDao {

	public void addLinkInC(LinkInC linkInC);
	
	public void updateLinkInC(LinkInC linkInC);
	
	public void deleteLinkInC(LinkInC linkInC);
	
	public LinkInC findLinkInCById(String linkId);
	
	public List<LinkInC> findLinkInCListByCategoryId(String categoryId);
	
	public List<LinkInC> findLinkInCListByCategoryId(int start, int amount, 
			String categoryId);
	
	public List<LinkInC> findLinkInCListByProductId(String productId);
	
	public int countProductByCategoryId(String categoryId, boolean del);
}
