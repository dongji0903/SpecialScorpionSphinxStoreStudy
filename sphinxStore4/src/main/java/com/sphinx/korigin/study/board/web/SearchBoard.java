package com.sphinx.korigin.study.board.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchBoard {

	/*@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		if (request.getParameter("search") != null) {

			String text = request.getParameter("search");
			String titt = request.getParameter("searchSelect");
			String category = (String) request.getSession().getAttribute("category");

			List<Board> searchBoardList = new ArrayList<Board>();

			BoardDao bDao = BoardDaoImpl.getInstance();

			if (titt.equals("제목")) {
				searchBoardList = bDao.searchBoard(category, "board_title", text);

			} else if (titt.equals("작성자")) {
				searchBoardList = bDao.searchBoard(category, "nickname", text);

			} else if (titt.equals("내용")) {
				searchBoardList = bDao.searchBoard(category, "board_content", text);
			}
			request.getSession().setAttribute("searchBoardList", searchBoardList);
		}
		
		return getNextPage();
	}*/

}