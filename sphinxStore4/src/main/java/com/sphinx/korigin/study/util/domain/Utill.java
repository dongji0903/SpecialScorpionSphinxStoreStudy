package com.sphinx.korigin.study.util.domain;

import java.util.ArrayList;
import java.util.List;

public class Utill {
	private String str;
	private List<String> list;


	public List<String> stringToList(String str) {
		list = new ArrayList<String>();
		String[] splitedList = str.split("/");
		for(String s : splitedList) {
			list.add(s);
		}
		return list;
	}
	
	public String listToString(List<String> list) {
		str= "";
		for (String string : list) {
			str += string + "/";
		}
		return str;
	}
	public String arrayToString(String[] array) {
		str = "";
		for (String string : array) {
			str += string + "/";
		}
		return str;
	}
	
}


