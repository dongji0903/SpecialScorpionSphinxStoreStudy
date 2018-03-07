package com.sphinx.korigin.study.study.web.exam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistExamController {
	/*TestSheetService ts = new TestSheetServiceImpl();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		List<Question> questionList = new ArrayList<Question>();
		String[] qIdArr = request.getParameterValues("questionId");
		String examiner = request.getParameter("examiner");
		String title = request.getParameter("examTitle");
		String grade = request.getParameter("examDifficulty");
		String jongryu=request.getParameter("jongryu");
		int limitTime=Integer.parseInt(request.getParameter("limitTime")); 
		for (String qId : qIdArr) {
			System.out.println(qId);
			if (!qId.equalsIgnoreCase("null")) {
				questionList.add(ts.getQuestion(qId));
			}
		}
		
		ExamSheet examSheet = new ExamSheet();
		examSheet.setCompleted("false");
		examSheet.setCreateSheetDate(new Date());
		examSheet.setExaminer(examiner);
		examSheet.setExamForm(ts.getExamFormByJongryu(jongryu));
		examSheet.setGrade(grade);
		examSheet.setNumOfQuestion(qIdArr.length);
		examSheet.setQuestionList(questionList);
		examSheet.setTitle(title);
		examSheet.setLimitTime(limitTime);

		ts.createSheet(examSheet);

		return getNextPage();
	}*/

}
