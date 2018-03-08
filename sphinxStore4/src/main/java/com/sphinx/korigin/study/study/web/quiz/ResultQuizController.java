package com.sphinx.korigin.study.study.web.quiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResultQuizController {

	/*@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int trueCount = 0;
		
		int totalPoint = 0;
		int totalExp = 0;
		if (request.getParameter("point") != null
				&& request.getParameter("point") != "") {
			totalPoint = Integer.parseInt(request.getParameter("point"));
		}
		if (request.getParameter("exp") != null
				&& request.getParameter("exp") != "") {
			totalExp = Integer.parseInt(request.getParameter("exp"));
		}
		if (session.getAttribute("trueCount") != null) {
			trueCount = (int) session.getAttribute("trueCount");
		}

		session.removeAttribute("myAnswers");
		session.removeAttribute("stotalCount");
		session.removeAttribute("questionNum");
		session.removeAttribute("trueCount");
		session.removeAttribute("questions");

		request.setAttribute("userId", session.getAttribute("userId"));
		request.setAttribute("point", totalPoint);
		request.setAttribute("exp", totalExp);
		request.setAttribute("trueCount", trueCount);

		setNextCommand(new AddPointExp());
		setNextPage("include:study/quiz/lastPage");

		return getNextPage();
	}*/

}
