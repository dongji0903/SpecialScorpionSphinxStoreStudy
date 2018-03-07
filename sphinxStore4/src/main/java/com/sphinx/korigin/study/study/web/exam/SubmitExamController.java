package com.sphinx.korigin.study.study.web.exam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SubmitExamController {
	/*AnswerSheetService as = new AnswerSheetServiceImpl();
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Sheet sheet = (Sheet) session.getAttribute("sheet");
		AnswerSheet asheet = new AnswerSheet(sheet.getSid(),
				(String) session.getAttribute("userId"), 0.0, new Date());
		List<Question> questionList = sheet.getQuestionList();
		List<Answer> answerList = new ArrayList<>();
		String[] qTypeList = request.getParameterValues("qType");
		double score = 0.0;
		for (int i = 0; i < qTypeList.length; i++) {
			String answer = "";
			if (qTypeList[i].equalsIgnoreCase("o")) {
				String[] selectsSList = request
						.getParameterValues("selects_" + (i + 1));
				if (selectsSList != null) {
					for (int j = 0; j < selectsSList.length; j++) {
						answer += selectsSList[j];
						if (j != selectsSList.length - 1) {
							answer += "/";
						}
					}
				}

			} else {
				answer = request.getParameter("typed_" + (i + 1));
			}
			Answer answerClass = new Answer(i + 1, answer, false);
			Map<String, Object> result = as.compareSolution(questionList.get(i),
					answerClass);
			answerClass.setIsCorrect((boolean) result.get("isRight"));
			if ((boolean) result.get("isRight")) {
				score += questionList.get(i).getScore();
			}
			answerList.add(answerClass);
		}
		asheet.setOMRCard(answerList);
		asheet.setTotalScore(score);
		as.createAnswerSheet(asheet);
		System.out.println("답안지:" + asheet);
		// session.removeAttribute("sheet");
		return getNextPage();
	}*/

}
