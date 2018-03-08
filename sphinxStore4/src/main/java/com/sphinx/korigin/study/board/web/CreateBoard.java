package com.sphinx.korigin.study.board.web;


import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateBoard {

	/*@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response){

		Board bvo = new Board();
		bvo.setNickName((String) request.getAttribute("name"));
		bvo.setEmail((String) request.getAttribute("email"));
		bvo.setTitle((String) request.getAttribute("title"));
		bvo.setUrl((String) request.getAttribute("url"));
		bvo.setContent((String) request.getAttribute("content"));
		bvo.setCategory((String) request.getAttribute("category"));
		Date d = new Date();
		bvo.setWritedate(d);

		BoardDao bDao = BoardDaoImpl.getInstance();
		bDao.insertBoards(bvo);
		System.out.println("등록");
		request.setAttribute("category", bvo.getCategory());
		
		return getNextPage();

	}*/

}
