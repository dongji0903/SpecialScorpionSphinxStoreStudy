package com.sphinx.korigin.study.study.web.quiz;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class GetRandomQuestionController {
	/*TestSheetService ts = new TestSheetServiceImpl();
	AnswerSheetService as = new AnswerSheetServiceImpl();
	StudyCategoryDao cd = new StudyCategoryDaojdbcImpl();
	CategoryService cs = new CategoryServiceImpl();
	// 카테고리 Id받아서 문제 랜덤 1개 가져오기
	// getSolution 헤당하는 해답과 문제가져오기
	// quiz에 다음문제 있는지? getQuestion 없으면 result

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		

		int	questionNum = (int)session.getAttribute("questionNum"); //문제번호가져오기
		
			List<Question> questionList = new ArrayList<Question>();
			questionList = (List<Question>) session.getAttribute("questions"); 

			request.setAttribute("question", questionList.get(questionNum)); //문제꺼내기
			session.setAttribute("questionNum", questionNum + 1); // 다음 문제 번호 셋팅

		return getNextPage();
	}
*/
}
