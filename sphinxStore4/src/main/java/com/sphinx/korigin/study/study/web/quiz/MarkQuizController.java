package com.sphinx.korigin.study.study.web.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MarkQuizController {
	/*TestSheetService ts = new TestSheetServiceImpl();
	AnswerSheetService as = new AnswerSheetServiceImpl();
	StudyCategoryDao cd = new StudyCategoryDaojdbcImpl();
	CategoryService cs = new CategoryServiceImpl();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		int questionNum = (int) session.getAttribute("questionNum") - 1;
		// 이전문제번호로 셋팅
		int point = 0;
		if (request.getParameter("point") != null
				&& request.getParameter("point") != "") {
			point = Integer.parseInt(request.getParameter("point"));
		}
		int exp = 0;
		if (request.getParameter("exp") != null
				&& request.getParameter("exp") != "") {
			exp = Integer.parseInt(request.getParameter("exp"));
		}
		int hp = 0;
		if (request.getParameter("hp") != null
				&& request.getParameter("hp") != "") {
			hp = Integer.parseInt(request.getParameter("hp"));
		}

		List<Question> questionList = new ArrayList<Question>();
		List<Answer> answerList = new ArrayList<>();

		int trueCount = 0;
		if (session.getAttribute("trueCount") != null) {
			trueCount = (int) session.getAttribute("trueCount");
		}

		questionList = (List<Question>) session.getAttribute("questions");
		answerList = (List<Answer>) session.getAttribute("myAnswers");

		String qType = request.getParameter("qType");
		System.out.println("hp1: " + hp);
		String answer = "";

		Question q = questionList.get(questionNum);

		if (qType != null) {
			if (qType.equalsIgnoreCase("s")) { // 주관식이면 텍스트폼에서 답 가져오고
				answer = request.getParameter("typed");
			} else { // 객관식이면 체크박스에 선택된 번호들을 가져와서 한 문자열로 이어붙임
				String[] answers = request.getParameterValues("selects");
				if (answers != null) {
					for (int i = 0; i < answers.length; i++) {
						answer += answers[i];
						if (i != answers.length - 1) {
							answer += "/";
						}
					}
				}
			}
		}
		Answer answerClass = new Answer(questionNum, answer, false);

		Map<String, Object> result = as.compareSolution(q, answerClass);// 정답 비교

		answerList.add(answerClass); // 답안리스트에 추가

		if ((boolean) result.get("isRight")) {
			trueCount++;
			point += questionList.get(questionNum).getScore(); // 포인트를 점수만큼 추가하기
			exp += 10;
			session.setAttribute("trueCount", trueCount);
			 맞추면 피 10 채움 
			if (hp >= 90) {
				hp = 100;
				request.setAttribute("hp", hp);
			} else {
				hp += 10;
				request.setAttribute("hp", hp);
			}
			 틀리면 피 25 빠짐 
		} else {
			request.setAttribute("hp", hp - 25);
		}
		request.setAttribute("question", questionList.get(questionNum));
		request.setAttribute("point", point);
		request.setAttribute("exp", exp);
		session.setAttribute("questionNum",
				questionNum + 1);  문제가 제출된상태이기 때문에 다시 수정 
		request.setAttribute("isRight", result.get("isRight"));

		if (qType != null && qType.equalsIgnoreCase("o")) { // 객관식이면
			request.setAttribute("myAnswer", request
					.getParameterValues("selects"));  이전에 선택한 번호 그대로 가져옴 

		} else {
			request.setAttribute("myAnswer",
					answer);  주관식이면 작성했던 답안 그대로 가져옴 
		}
		request.setAttribute("correctAnswer",
				result.get("correctAnswers"));  정답 가져옴 
		request.setAttribute("explanation", result.get("explan"));  해설 가져옴 

		return getNextPage();
	}*/

}
