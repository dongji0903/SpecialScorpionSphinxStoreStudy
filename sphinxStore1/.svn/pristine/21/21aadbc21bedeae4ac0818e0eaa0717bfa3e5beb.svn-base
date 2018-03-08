package com.sphinx.beautea.common.domain;

import java.util.Comparator;

import com.sphinx.beautea.order.domain.Order;

public class OrderComparator implements Comparator<Order> {

	@Override
	public int compare(Order first, Order second) {
		// TODO Auto-generated method stub
				String f = first.getOrderId();
				Long first_num = Long.parseLong(f.substring(2, f.length()));
				
				String s = second.getOrderId();
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
