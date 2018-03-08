package com.sphinx.beautea.category.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.beautea.category.dao.LinkInCDao;
import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.domain.LinkInC;
import com.sphinx.beautea.category.service.LinkInCService;
import com.sphinx.beautea.common.domain.PageUtil;
import com.sphinx.beautea.product.domain.Product;
import com.sphinx.beautea.product.service.ProductService;

@Service
public class LinkInCServiceImpl implements LinkInCService {
	@Autowired
	private LinkInCDao linkDao;
	@Autowired
	ProductService productService;
	
	@Override
	public void addLinkInC(LinkInC linkInC) {
		// TODO Auto-generated method stub
		linkDao.addLinkInC(linkInC);
	}

	@Override
	public void updateLinkInC(LinkInC linkInC) {
		// TODO Auto-generated method stub
		linkDao.updateLinkInC(linkInC);
	}

	@Override
	public void deleteLinkInC(LinkInC linkInC) {
		// TODO Auto-generated method stub
		linkDao.deleteLinkInC(linkInC);
	}

	@Override
	public LinkInC getLinkInCById(String linkId) {
		// TODO Auto-generated method stub
		return linkDao.findLinkInCById(linkId);
	}

	@Override
	public List<LinkInC> getLinkInCListByCategoryId(String categoryId) {
		// TODO Auto-generated method stub
		return linkDao.findLinkInCListByCategoryId(categoryId);
	}

	@Override
	public List<LinkInC> getLinkInCListByCategoryId(int page, String categoryId) {
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		int start = amount * (page - 1);
		return linkDao.findLinkInCListByCategoryId(start, amount, categoryId);
	}

	@Override
	public List<LinkInC> getLinkInCListByProductId(String productId) {
		// TODO Auto-generated method stub
		return linkDao.findLinkInCListByProductId(productId);
	}

	@Override
	public List<Product> getProductListByCategoryId(String categoryId) {
		List<LinkInC> inc = getLinkInCListByCategoryId(categoryId);
		List<Product> plist = new ArrayList<>();
		for(LinkInC l : inc) {
			plist.add(productService.getProductById(l.getProductId()));
		}
		return plist;
	}

	@Override
	public List<Category> getCategoryListByProductId(String productId,
			Map<String, Category> categoryMap) {
		List<LinkInC> inc = getLinkInCListByProductId(productId);
		List<Category> clist = new ArrayList<>();
		for(LinkInC l : inc) {
			clist.add(categoryMap.get(l.getCategoryId()));
		}
		return clist;
	}

	@Override
	public int countProductByCategoryId(String categoryId, boolean del) {
		// TODO Auto-generated method stub
		return linkDao.countProductByCategoryId(categoryId, del);
	}

}
