package com.sphinx.korigin.study.study.web.quiz;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.sphinx.korigin.study.category.domain.Category;

@Controller
public class SetQuizController {

	@RequestMapping(value = "/quiz/", method = RequestMethod.GET)
	public String setCategoryView(WebApplicationContext context, Model m) {
		List<Category> studyRootCategoryList = (List<Category>) context.getServletContext()
				.getAttribute("studyRootCategoryList");
		m.addAttribute("categories", studyRootCategoryList);
		return null;
	}
	/*TestSheetService ts = new TestSheetServiceImpl();
	AnswerSheetService as = new AnswerSheetServiceImpl();
	StudyCategoryDao cd = new StudyCategoryDaojdbcImpl();
	CategoryService cs = new CategoryServiceImpl();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		String catgoryId = request.getParameter("hiddenCategory");
		
		 * int totalCount = Integer
		 * .parseInt(request.getParameter("numOfQuestion"));
		 

		List<Question> questionList = new ArrayList<Question>();
		List<Answer> answerList = new ArrayList<>();

		session.setAttribute("myAnswers", answerList); // 세션에 내 답안 리스트 등록
		 지정된 카테고리로 문제를 불러옴. 개수 초과시 null 
		questionList = ts.findQuestionsOfCategory(
				new ShoppingCategory(catgoryId, null, null), 20);
		System.out.println(catgoryId);
		session.setAttribute("questions", questionList); // 문제 리스트 저장
		request.setAttribute("question", questionList.get(0));
		session.setAttribute("totalNumOfQuestion", 20);
		session.setAttribute("questionNum", 0); // 현재 문제번호:0(미출제 상태)
		request.setAttribute("hp", 100);
		request.setAttribute("bossHP", 5);

		return getNextPage();
	}*/
}
