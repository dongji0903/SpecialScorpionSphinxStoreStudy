package com.sphinx.korigin.shopping.product.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.korigin.shopping.category.domain.ShoppingCategory;
import com.sphinx.korigin.shopping.category.service.ShoppingCategoryService;
import com.sphinx.korigin.shopping.product.dao.ProductCategoryLinkDao;
import com.sphinx.korigin.shopping.product.dao.ProductDao;
import com.sphinx.korigin.shopping.product.dao.impl.ProductCategoryLinkDaoImpl;
import com.sphinx.korigin.shopping.product.domain.Product;
import com.sphinx.korigin.shopping.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductCategoryLinkDao productCategoryLinkDao;
	@Autowired
	private ShoppingCategoryService categoryService;

	@Override
	public String addProduct(Product product) {
		product.setRegDate(new Date());
		return productDao.insertProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productDao.removeProduct(product);
	}

	@Override
	public int countProductByCategoryId(String categoryId) {
		return 0;
	}

	@Override
	public Product getProductById(String productId) {
		return productDao.selectProductById(productId);
	}

	@Override
	public Product getProductByName(String productName) {
		return productDao.selectProductByName(productName);
	}

	@Override
	public List<Product> searchProductByKeyword(int start, int amount,
			String keyword) {
		return productDao.selectProductListByKeyword(start, amount, keyword);
	}

	@Override
	public List<Product> getProductListByCategoryId(int start, int amount,
			ShoppingCategory category) {
		List<ShoppingCategory> allCategory = getSubCategories(category);
		String[] allCids = new String[allCategory.size()];
		for (int i = 0; i < allCategory.size(); i++) {
			allCids[i] = allCategory.get(i).getCategoryId();
		}
		List<String> productIds = productCategoryLinkDao
				.selectProductIdsByCategoryId(allCids);
		String[] pidArr = new String[productIds.size()];
		for (int i = 0; i < productIds.size(); i++) {
			pidArr[i] = productIds.get(i);
		}
		if (pidArr == null || pidArr.length == 0) {
			return null;
		} else {
			return productDao.selectProductListByCategoryId(start, amount,
					pidArr);
		}
	}

	@Override
	public List<Product> getProductList(int start, int amount) {
		return productDao.selectProductList(start, amount);
	}

	private List<ShoppingCategory> getSubCategories(ShoppingCategory c) { // c를 포함하여 자식카테고리 중
															// 자식없는 카테고리 전부
		List<ShoppingCategory> subList = c.getSubCategory();
		List<ShoppingCategory> leafList = new ArrayList<>();
		System.out.println(c);
		if (subList != null && !subList.isEmpty()) {
			System.out.println("ProductServiceImpl: subList:" + subList);
			for (ShoppingCategory cc : subList) {
				leafList.addAll(getSubCategories(cc));
			}
		} else {
			leafList.add(c);
		}
		return leafList;
	}

	@Override
	public void addLink(String categoryId, String productId) {
		productCategoryLinkDao.insertLink(productId, categoryId);
	}
}
