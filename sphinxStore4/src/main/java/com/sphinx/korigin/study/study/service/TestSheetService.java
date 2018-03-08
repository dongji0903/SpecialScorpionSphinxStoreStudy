package com.sphinx.korigin.study.study.service;

import java.util.List;
import java.util.Map;
import com.sphinx.korigin.study.category.domain.Category;
import com.sphinx.korigin.study.study.domain.exam.ExamForm;
import com.sphinx.korigin.study.study.domain.exam.Sheet;
import com.sphinx.korigin.study.study.domain.question.GroupQuestion;
import com.sphinx.korigin.study.study.domain.question.Question;
import com.sphinx.korigin.study.study.domain.solution.Solution;

public interface TestSheetService {

	public List<Question> findQuestionsOfCategory(Category c); // 랜덤으로 해당카테고리 문제
																// 모두 가져오기

	public List<Question> findQuestionsOfJYP(String jongryu, String yeongyoeck,
			String yoohyong); // 해당 문제 종류와 유형에 맞는 모든문제 가져오기

	public List<Question> findQuestionsOfCategory(Category c, int count); // 랜덤으로
																			// 해당
																			// 카테고리에서
																			// count만큼
																			// 문제
																			// 가져오기

	public List<Question> findQuestionsOfCategory(Category c,
			List<String> selectQid);
	// 기존의 선택된 문제를 제외한 문제를 가져오기, qid를 이용하여 처리

	public List<Question> checkGetQuestions(List<Question> findQ,
			Map<String, List<Question>> sheetQ, String yoohyong);
	// sheet에 있는 문제와 선택창으로 가는 문제를 검사하여 선택된 문제를 삭제

	public String createQuestion(Question question, Solution solution); // 객체를
																		// DB에
																		// 저장,
																		// 만들어진
																		// 문제의
																		// id 반환

	public List<Sheet> findAllSheets(String formal);

	public Sheet findSheet(String sid);

	public List<Question> findQuestionsForSolution(String sid);

	public void modifySheet(Sheet s);

	public void modifyQuestion(Question q);

	public Question getQuestion(String qid);

	public List<Category> getAllChildren(Category c);

	public void createSheet(Sheet s);

	public void createGroupQuestion(GroupQuestion groupQuestion);

	public GroupQuestion getGroupQuestion(String gid);

	public List<GroupQuestion> getGroupQuestionsByYY(String yeongyoeck,
			String yoohyong);

	public void createExamForm(ExamForm examForm);

	public ExamForm getExamFormByJongryu(String jongryu);

	public List<String> getAllYeongyoeck();

	public void addYeongyoeck(String s);

	public List<String> getAllYoohyong();

	public void addYoohyong(String s);

	public List<String> getAllJongryu();

	public void addJongryu(String s);

	public void createExamForm(String jongryu, String coverUrl,
			String[] gidArr);

}
