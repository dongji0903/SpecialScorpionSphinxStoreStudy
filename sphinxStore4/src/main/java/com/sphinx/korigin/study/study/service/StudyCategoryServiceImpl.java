package com.sphinx.korigin.study.study.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sphinx.korigin.study.category.dao.*;
import com.sphinx.korigin.study.category.domain.Category;

@Service("StudyCategoryService")
public class StudyCategoryServiceImpl implements StudyCategoryService {

	@Autowired
	private StudyCategoryDao studyCategoryDao;

	@Override
	public String createCategory(Category c) {
		if (c.getCid() != null
				&& studyCategoryDao.findCategory(c.getCid()) != null) {
			return null;
		}
		return studyCategoryDao.createCategory(c);
	}

	@Override
	public void deleteCategory(String cid) {
		if (studyCategoryDao.findCategory(cid) == null) {
			return;
		}
		studyCategoryDao.deleteCategory(cid);
	}

	@Override
	public void modifyCategory(Category newCat) {
		studyCategoryDao.modifyCategory(newCat);
	}

	@Override
	public Map<String, Category> findAllCategories() {
		Map<String, Category> map = studyCategoryDao.findAllCategory();
		return map;
	}

	@Override
	public List<Category> findFirstCategories() {
		List<Category> list = studyCategoryDao.findFirstCategories();
		return list;
	}
}
