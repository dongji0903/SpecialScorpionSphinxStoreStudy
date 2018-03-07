package com.sphinx.korigin.study.board.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetMiniBoard {
	/*BoardDao bDao = BoardDaoImpl.getInstance();
	ItemDao id = ItemDaoImpl.getInstance();
	SaleManageDao smd = SaleManagementDaoImpl.getInstance();

	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		List<Board> miniBoard1 = bDao.makeMiniBoard("공지사항", 5);
		List<Board> miniBoard2 = bDao.makeMiniBoard("공연게시판", 5);
		List<Comment> miniComment1 = bDao.selectCommentByCategory("공지사항");
		List<Comment> miniComment2 = bDao.selectCommentByCategory("공연게시판");

		List<String> topSaleList = smd.selectTopSale();
		List<Item> topItemList = new ArrayList<Item>();
		if (topSaleList != null) {
			for (String s : topSaleList) {
				Item ivo = id.selectItem(s);
				topItemList.add(ivo);
			}
		}
		for (int i = 0; i < miniComment2.size(); i++) {
			miniComment1.add(miniComment2.get(i));
		}
		request.setAttribute("notice", miniBoard1);
		request.setAttribute("consert", miniBoard2);
		request.setAttribute("topItemList", topItemList);
		HttpSession session = request.getSession();
		session.setAttribute("comment", miniComment1);
		return getNextPage();
	}*/
}
