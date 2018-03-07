package com.sphinx.korigin.study.study.web.quiz;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckNumOfQuestionController {

	/*TestSheetService ts = new TestSheetServiceImpl();
	AnswerSheetService as = new AnswerSheetServiceImpl();
	StudyCategoryDao cd = new StudyCategoryDaojdbcImpl();
	CategoryService cs = new CategoryServiceImpl();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		String catgoryId = request.getParameter("hiddenCategory");
		 String totalCount = request.getParameter("numOfQuestion"); 
		List<Question> questionList = new ArrayList<Question>();

		questionList = ts.findQuestionsOfCategory(
				new ShoppingCategory(catgoryId, null, null), 20);
		 지정된 카테고리로 문제를 불러옴.개수 초과시 null 

		if (questionList == null || questionList.isEmpty()) {
			 개수가 초과일 경우 선택화면으로 이동 
			int maxQuestions = ts.findQuestionsOfCategory(
					new ShoppingCategory(catgoryId, null, null)).size();

			request.setAttribute("maxTotalCount", maxQuestions);

			return "call: /study/getFirstCategory.do";
		}
		return getNextPage();
	}*/

}
