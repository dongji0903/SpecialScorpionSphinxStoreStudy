package com.sphinx.beautea.common.domain;

import java.util.Comparator;

public class DateComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		Long first_num = Long.parseLong(o1.substring(2, o1.length()));
		
		Long second_num = Long.parseLong(o2.substring(2, o2.length()));
		
		if (first_num > second_num) {
			return 1;
		} else if (first_num < second_num) {
			return -1;
		} else {
			return 0;
		}
	}

}
