package com.sphinx.korigin.study.shop.dao;

import java.util.List;

import com.dug.domain.shop.Item;

public interface ItemDao {
	
	int selectMaxItems();
	
	int selectMaxSearchItems(String name);
	
	List<Item> selectAllItems();
	
	String insertItem(Item ivo);
	
	List<Item> adaptedItemListForPage(int offset, int count, String name);
	
	List<Item> adaptedItemListForPage(int offset, int count);
	
	Item selectItem(String num);
	
	List<Item> selectItems(String name);
	
	void updateItem(Item ivo);
	
	List<Item> bestSellers(int num);
}
