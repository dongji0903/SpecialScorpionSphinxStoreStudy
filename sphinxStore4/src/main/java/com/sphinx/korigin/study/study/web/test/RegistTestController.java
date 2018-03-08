package com.sphinx.korigin.study.study.web.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistTestController {
	/*TestSheetService ts = new TestSheetServiceImpl();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String title = request.getParameter("title");
		String grade = request.getParameter("grade");
		String examinor = request.getParameter("examinor");
		int limitTime = Integer.parseInt(request.getParameter("limitTime"));
		String[] qidList = request.getParameterValues("question");
		List<Question> qList = new ArrayList<>();
		for (String s : qidList) {
			Question q = new Question();
			q.setQid(s);
			qList.add(q);
		}
		Sheet sheet = new Sheet(title, grade, qList.size(), examinor,
				new Date(), limitTime, qList);
		ts.createSheet(sheet);
		return getNextPage();
	}*/
}
