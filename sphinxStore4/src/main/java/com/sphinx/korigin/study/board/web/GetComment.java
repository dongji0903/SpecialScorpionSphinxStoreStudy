package com.sphinx.korigin.study.board.web;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetComment {

	/*@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response){

		String num = request.getParameter("num");
		BoardDao bDao = BoardDaoImpl.getInstance();
		bDao.updateReadCount(num);

		List<Comment> commentList = bDao.selectCommentByCategory(
				(String) request.getSession().getAttribute("category"));
		List<Comment> comment = new ArrayList<>();
		for (Comment cvo : commentList) {
			if (cvo.getRef() == Integer.parseInt(num)) {
				comment.add(cvo);
			}
		}
		request.setAttribute("com", comment);

		return getNextPage();

	}*/

}
