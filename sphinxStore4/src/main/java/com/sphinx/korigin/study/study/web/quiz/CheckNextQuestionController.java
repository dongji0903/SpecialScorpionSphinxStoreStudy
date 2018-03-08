package com.sphinx.korigin.study.study.web.quiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckNextQuestionController {
/*
	TestSheetService ts = new TestSheetServiceImpl();
	AnswerSheetService as = new AnswerSheetServiceImpl();
	StudyCategoryDao cd = new StudyCategoryDaojdbcImpl();
	CategoryService cs = new CategoryServiceImpl();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		int totalCount = (int) session.getAttribute("totalNumOfQuestion");
		int questionNum = (int) session.getAttribute("questionNum");
		

		int point = Integer.parseInt(request.getParameter("point"));
		int exp = Integer.parseInt(request.getParameter("exp"));
		int hp = Integer.parseInt(request.getParameter("hp"));
		request.setAttribute("point", point);
		request.setAttribute("exp", exp);
		request.setAttribute("hp", hp);
		
		System.out
				.println("CheckNextQuestion:" + questionNum + "/" + totalCount);
		if (questionNum >= totalCount) {
			return "call: /study/finishQuiz.do";
		}

		return getNextPage();
	}
*/
}
