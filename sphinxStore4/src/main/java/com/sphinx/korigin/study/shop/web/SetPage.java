package com.sphinx.korigin.study.shop.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dug.controller.command.Command;
import com.dug.dao.shop.ItemDao;
import com.dug.dao.shop.impl.ItemDaoImpl;
import com.dug.domain.shop.Item;
import com.dug.util.PageUtil;

public class SetPage extends Command {
	ItemDao iDao = ItemDaoImpl.getInstance();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();

		String name = (String) session.getAttribute("name");

		int nowPage = 0; // 현재 페이지
		int setListHight = 16; //페이지당 표시 갯수
		
		if (request.getParameter("pageNumber") != null) {
			nowPage = Integer.parseInt(request.getParameter("pageNumber"));
		}else {
			nowPage = 1;
		}
		
		int offset = (nowPage - 1) * setListHight;	
		int itemSize = 0;
		
		List<Item> itemList = new ArrayList<>();
	
		if (name == null) { // 검색 X
			itemSize = iDao.selectMaxItems(); // 상품전체목록수	
			itemList = iDao.adaptedItemListForPage(offset,setListHight);
		}else{	//검색 O
			itemSize = iDao.selectMaxSearchItems(name); // 검색상품목록수
			itemList = iDao.adaptedItemListForPage(offset,setListHight, name);
		}
		
		PageUtil p_Util = new PageUtil(setListHight, 10, itemSize);	

		request.setAttribute("itemList", itemList);
		request.setAttribute("nextBlock", p_Util.getNextBlock(nowPage));
		request.setAttribute("prevBlock", p_Util.getPrevBlock(nowPage));
		request.setAttribute("totalPageNum",p_Util.getTotalNumOfPage(itemSize));
		request.setAttribute("blockList", p_Util.getBlockList(nowPage));

		return getNextPage();

	}
}