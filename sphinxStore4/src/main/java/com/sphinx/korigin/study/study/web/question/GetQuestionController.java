package com.sphinx.korigin.study.study.web.question;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class GetQuestionController {
	
	/*@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
	TestSheetService tss = new TestSheetServiceImpl();
	HttpSession session = request.getSession();

	@SuppressWarnings("unchecked")
	List<String> qidList = (List<String>) session.getAttribute("qidList");
	String cid = request.getParameter("selectCategory");
	@SuppressWarnings("unchecked")
	Map<String, ShoppingCategory> categoryMap = (Map<String, ShoppingCategory>) request
			.getServletContext().getAttribute("categoryMap");
	ShoppingCategory selectCategory = categoryMap.get(cid); // 해당 cid의 Category를 찾아옴

	// 해당Category에 속한 Questions을 찾아옴
	List<Question> selectQuestions = tss
			.findQuestionsOfCategory(selectCategory);
	if (qidList == null) {
		for (Question q : selectQuestions) {
			System.out.println("전부가져오기: " + q.getQid());
		}
		request.setAttribute("selectQuestions", selectQuestions);
	} else {
		selectQuestions = tss.findQuestionsOfCategory(selectCategory,
				qidList);
		for (Question q : selectQuestions) {
			System.out.println("전부가져오기: " + q.getQid());
		}
		request.setAttribute("selectQuestions", selectQuestions);
	}

		return getNextPage();
	}*/

}
