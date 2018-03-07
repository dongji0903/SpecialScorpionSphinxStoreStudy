package com.sphinx.korigin.study.study.web.exam;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 종류,영역,유형이 일치하는 문제들 가져오기
 * @author 이광민
 *
 */
public class GetQuestionByTypeController {

	/*TestSheetService ts= new TestSheetServiceImpl();
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String Jongryu=request.getParameter("Jongryu");
		String Yeongyoeck=request.getParameter("Yeongyoeck");
		String Yoohyong=request.getParameter("Yoohyong");
		System.out.println("Jongryu:"+Jongryu);
		System.out.println("Yeongyoeck:"+Yeongyoeck);
		System.out.println("Yoohyong:"+Yoohyong);
		List<Question> questionList=ts.findQuestionsOfJYP(Jongryu, Yeongyoeck,Yoohyong);
		String[] alreadyAddedQuestionIds = request.getParameterValues("questionId");
		System.out.println(alreadyAddedQuestionIds);
		request.setAttribute("qList", questionList);
		return getNextPage();
	}*/

}
