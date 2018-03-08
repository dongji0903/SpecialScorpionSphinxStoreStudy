package com.sphinx.beautea.customer.web.controller.login;

import java.util.HashMap;
import java.util.Map;


public class OverlapLoginCheck {
	private static Map<String, Object> HashTable = new HashMap<>();
	private static OverlapLoginCheck value = new OverlapLoginCheck();
	private OverlapLoginCheck () {
	}
	public static OverlapLoginCheck getInstance() {
		return value;
	}
	
	public boolean CheckCustomer(String customerid) {
		if (HashTable.get(customerid) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void removeCusotmer(String customerid) {
		HashTable.remove(customerid);
	}
	
	public Map<String, Object> getHashTable() {
		return HashTable;
	}
	

}
