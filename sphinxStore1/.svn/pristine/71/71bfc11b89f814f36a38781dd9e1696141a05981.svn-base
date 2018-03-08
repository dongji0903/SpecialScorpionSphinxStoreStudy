package com.sphinx.beautea.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.beautea.common.domain.PageUtil;
import com.sphinx.beautea.product.dao.ProductDao;
import com.sphinx.beautea.product.domain.Product;
import com.sphinx.beautea.product.service.OptionService;
import com.sphinx.beautea.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	@Autowired
	OptionService optionService;
	
	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.addProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.updateProduct(product);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(product);
	}

	@Override
	public Product getProductById(String productId) {
		// TODO Auto-generated method stub
		Product product = productDao.findProductById(productId);
		product.setOptionList(optionService.getOptionListByProductId(productId));
		return product;
	}

	@Override
	public List<Product> getProductList(int page) {
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		int start = amount * (page - 1);
		return productDao.findProductList(start, amount);
	}

	@Override
	public List<Product> searchProductListByKeyword(int page, String keyword) {
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		int start = amount * (page - 1);
		return productDao.searchProductListByKeyword(start, amount, keyword);
	}

	@Override
	public List<Product> getDeleteProduct(int page) {
		PageUtil pageUtil = new PageUtil();
		int amount = pageUtil.getAmount();
		int start = amount * (page - 1);
		return productDao.findDeleteProduct(start, amount);
	}

	@Override
	public int countProduct(boolean del) {
		// TODO Auto-generated method stub
		return productDao.countProduct(del);
	}

	@Override
	public List<Product> searchProductListByName(int start, int amount,
			String name) {
		// TODO Auto-generated method stub
		return productDao.searchProductListByName(start, amount, name);
	}


}
