package com.sphinx.beautea.category.common;

import java.util.Comparator;

import com.sphinx.beautea.category.domain.Category;

public class MiniComparator implements Comparator<Category> {

	@Override
	public int compare(Category first, Category second) {
		// TODO Auto-generated method stub
		String f = first.getCategoryId();
		Long first_num = Long.parseLong(f.substring(2, f.length()));
		
		String s = second.getCategoryId();
		Long second_num = Long.parseLong(s.substring(2, s.length()));
		
		if (first_num > second_num) {
			return 1;
		} else if (first_num < second_num) {
			return -1;
		} else {
			return 0;
		}
	}

}
