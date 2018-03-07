package com.sphinx.korigin.study.study.service;

import java.util.List;
import java.util.Map;

import com.sphinx.korigin.study.study.domain.answer.Answer;
import com.sphinx.korigin.study.study.domain.answer.AnswerSheet;
import com.sphinx.korigin.study.study.domain.answer.AnswerSheetForList;
import com.sphinx.korigin.study.study.domain.answer.SheetTestRecord;
import com.sphinx.korigin.study.study.domain.question.Question;
import com.sphinx.korigin.study.study.domain.solution.Solution;

public interface AnswerSheetService {
	public Map<String, Object> compareSolution(Question q, Answer a); // 1.맞춤or틀림 2.정답 3.해설(TBD)

	public String createAnswerSheet(AnswerSheet answerSheet); // 답안지 작성

	public AnswerSheet findAsheet(String asid); // 답안지 id로 답안지 가져옴

	public List<AnswerSheetForList> findBriefSheetsOfMember(String id, int skip, int count); // 해당유저의 답안지간략정보를 임의의 갯수만큼
																								// 가져옴

	public int getNumberOfAnswerSheets(String id); // 해당유저의 답안지 수를 반환

	SheetTestRecord getSheetRecord(String sid);
	
	public Solution findSolutionOfQuestion(String qid);
	
	public List<Solution> findSolutionsOfSheet(String sid);
	
	Map<String,Object> getMyRecord(String id);

}
