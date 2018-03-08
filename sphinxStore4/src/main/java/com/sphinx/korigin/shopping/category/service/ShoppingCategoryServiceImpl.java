package com.sphinx.korigin.shopping.category.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sphinx.korigin.shopping.category.dao.ShoppingCategoryDao;
import com.sphinx.korigin.shopping.category.dao.ShoppingCategoryDaoImpl;
import com.sphinx.korigin.shopping.category.domain.ShoppingCategory;

@Service
public class ShoppingCategoryServiceImpl implements ShoppingCategoryService {

	@Autowired
	private ShoppingCategoryDao shoppingCategoryDao;

	public void setCategoryDaoImpl(
			ShoppingCategoryDaoImpl shoppingCategoryDaoImpl) {
		this.shoppingCategoryDao = shoppingCategoryDaoImpl;
	}

	@Override
	public void addCategory(ShoppingCategory category) {
		shoppingCategoryDao.insertCategoy(category);
	}

	@Override
	public void updateCategory(ShoppingCategory category) {
		shoppingCategoryDao.updateCategoy(category);
	}

	@Override
	public void deleteCategory(ShoppingCategory category) {
		shoppingCategoryDao.removeCategoy(category);
	}

	@Override
	public Map<String, ShoppingCategory> getAllCategory() {
		Map<String, ShoppingCategory> categoryMap = new HashMap<String, ShoppingCategory>();
		List<ShoppingCategory> categories = shoppingCategoryDao
				.selectAllCategoryList();
		for (ShoppingCategory category : categories) {
			categoryMap.put(category.getCategoryId(), category);
		}
		for (String key : categoryMap.keySet()) {
			ShoppingCategory category = categoryMap.get(key);
			String superId = category.getSuperId();
			if (superId != null && !superId.isEmpty()) {
				List<ShoppingCategory> subCategories = categoryMap.get(superId)
						.getSubCategory();
				if (subCategories != null) {
					if (!subCategories.contains(category)) {
						subCategories.add(category);
						categoryMap.get(superId).setSubCategory(subCategories);

					}
				} else {
					subCategories = new ArrayList<ShoppingCategory>();
					subCategories.add(category);
					categoryMap.get(superId).setSubCategory(subCategories);
				}
			}
		}
		return categoryMap;
	}

	@Override
	public ShoppingCategory getCategoryById(String categoryId) {
		return shoppingCategoryDao.selectCategoryById(categoryId);
	}

	@Override
	public ShoppingCategory getCategoryByName(String categoryName) {
		return shoppingCategoryDao.selectCategoryByName(categoryName);
	}

	@Override
	public List<ShoppingCategory> getSubCategoryListByparentId(
			String categoryId) {
		return shoppingCategoryDao.selectCategoryListByParentId(categoryId);
	}

	@Override
	public List<ShoppingCategory> getRootCategoryList() {
		Map<String, ShoppingCategory> categoryMap = getAllCategory();
		List<ShoppingCategory> categoryList = shoppingCategoryDao
				.selectRootCategoryList();
		System.out.println(categoryList);
		for (ShoppingCategory c : categoryList) {
			int idx = categoryList.indexOf(c);
			c = categoryMap.get(c.getCategoryId());
			categoryList.set(idx, c);
		}
		return categoryList;
	}

}
