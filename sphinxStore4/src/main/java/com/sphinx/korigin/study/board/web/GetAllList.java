package com.sphinx.korigin.study.board.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetAllList {

	/*@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		BoardDao bDao = BoardDaoImpl.getInstance();
		List<Board> board = new ArrayList<>();
		
		session.removeAttribute("searchBoardList");
		
		String cate = null;

		if (request.getParameter("category") == null) {
			cate = (String) session.getAttribute("category");
		} else {
			cate = request.getParameter("category");
		}

		System.out.println(cate);

		board = bDao.selectBoardByCategory(cate);

		List<Comment> comment = new ArrayList<>();
		String cate1 = null;

		if (request.getParameter("category") == null) {
			cate1 = (String) session.getAttribute("category");
		} else {
			cate1 = request.getParameter("category");
		}

		System.out.println(cate1);

		comment = bDao.selectCommentByCategory(cate1);

		session.setAttribute("comment", comment);
		session.setAttribute("boardList", board);
		session.setAttribute("category", cate);

		return getNextPage();

	}*/

}