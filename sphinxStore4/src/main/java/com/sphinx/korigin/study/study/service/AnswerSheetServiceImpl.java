package com.sphinx.korigin.study.study.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.korigin.study.study.dao.answer.*;
import com.sphinx.korigin.study.study.dao.exam.*;
import com.sphinx.korigin.study.study.dao.question.*;
import com.sphinx.korigin.study.study.dao.solution.*;
import com.sphinx.korigin.study.study.domain.answer.*;
import com.sphinx.korigin.study.study.domain.question.*;
import com.sphinx.korigin.study.study.domain.solution.*;

@Service("AnswerSheetService")
public class AnswerSheetServiceImpl implements AnswerSheetService {
	
	@Autowired
	private AnswerSheetDao answerSheetDao;
	@Autowired
	private SolutionDao solutionDao;
	@Autowired
	private AnswerDao answerDao;
	@Autowired
	private SheetDao sheetDao;
	@Autowired
	private SheetQuestionDao sheetQuestionDao;
	
	@Override
	public Map<String, Object> compareSolution(Question q, Answer a) { // 인자로 받은 문제와 답안은 보기순서가 같음.
		Map<String, Object> compareResult = new HashMap<String, Object>();
		Solution solution = solutionDao.findSolutionOfQuestion(q.getQid()); // 해당 qid로 solution 탐색
		if (solution instanceof ObjectiveSolution) { // 객관식일 때
			ObjectiveSolution osolution = (ObjectiveSolution) solution;
			if (a.getAnswer() != null && !a.getAnswer().isEmpty()) { // 답을 입력했을 경우
				List<Distractor> distractorList = ((ObjectiveQuestion) q).getDistractorList();
				List<String> didList = new ArrayList<>();
				for (Distractor d : distractorList) {
					didList.add(d.getDid());
				}
				String[] mySelectNumArray = a.getAnswer().split("/");
				List<String> myAnswerList = new ArrayList<String>();
				for (String s : mySelectNumArray) {
					myAnswerList.add(didList.get(Integer.parseInt(s) - 1));
				}
				List<Distractor> correctDistractorList = osolution.getDList();
				for (Distractor dd : correctDistractorList) {
					System.out.println(dd);
				}
				List<String> solutionList = new ArrayList<>();
				for (Distractor d : correctDistractorList) {
					solutionList.add(d.getDid());
				}
				Collections.sort(myAnswerList);
				List<Integer> solNumList = new ArrayList<>();
				for (String i : solutionList) {
					solNumList.add(didList.indexOf(i) + 1);
				}
				Collections.sort(solNumList);
				if (myAnswerList.containsAll(solutionList) && solutionList.containsAll(myAnswerList)) {
					compareResult.put("isRight", true);
				} else {
					compareResult.put("isRight", false);
				}
				compareResult.put("myAnswers", myAnswerList);
				compareResult.put("correctAnswers", solNumList);
				compareResult.put("explan", "해설스");
			} else { // 답을 입력하지 않았을 경우
				compareResult.put("isRight", false);
				List<Distractor> distractorList = ((ObjectiveQuestion) q).getDistractorList();
				List<String> didList = new ArrayList<>();
				for (Distractor d : distractorList) {
					didList.add(d.getDid());
				}
				List<Distractor> correctDistractorList = osolution.getDList();
				List<String> solutionList = new ArrayList<>();
				for (Distractor d : correctDistractorList) {
					System.out.println(d);
					solutionList.add(d.getDid());
				}
				List<Integer> solNumList = new ArrayList<>();
				for (String i : solutionList) {
					solNumList.add(didList.indexOf(i) + 1);
				}
				Collections.sort(solNumList);
				compareResult.put("correctAnswers", solNumList);
				compareResult.put("explan", "해설스");
			}
		} else { // 주관식일 때
			SubjectiveSolution ssolution = (SubjectiveSolution) solution;
			if (a.getAnswer() != null && !a.getAnswer().isEmpty()) { // 답을 입력했을 경우
				String myAnswer = a.getAnswer();
				String correctAnswer = ssolution.getSubAnswer();
				if (myAnswer.equals(correctAnswer)) {
					compareResult.put("isRight", true);
				} else {
					compareResult.put("isRight", false);
				}
				compareResult.put("myAnswers", myAnswer);
				compareResult.put("correctAnswers", correctAnswer);
				compareResult.put("explan", "해설스");
			} else { // 답을 입력하지 않았을 경우
				compareResult.put("isRight", false);
				String correctAnswer = ssolution.getSubAnswer();
				compareResult.put("correctAnswers", correctAnswer);
				compareResult.put("explan", "해설스");
			}
		}

		return compareResult;
	}

	@Override
	public String createAnswerSheet(AnswerSheet answerSheet) {
		String asid = answerSheetDao.createAnswerSheet(answerSheet);
		List<Answer> answerList = answerSheet.getOMRCard();
		for (Answer answer : answerList) {
			answer.setAsid(asid);
			answerDao.createAnswer(answer);
		}
		return asid;
	}

	@Override
	public List<AnswerSheetForList> findBriefSheetsOfMember(String id, int skip, int count) {
		List<AnswerSheet> asheetList = answerSheetDao.findAnswerSheetsForListOfMember(id, skip, count);		//답안지지만 게시용 정보만 있음.(답안이 없음)
		List<AnswerSheetForList> asLList = new ArrayList<>();
		for (AnswerSheet asheet : asheetList) {
			String asid = asheet.getAsid();
			String title = sheetDao.findSheet(asheet.getSid()).getTitle();
			Date testDate = asheet.getTestDate();
			double totalScore = asheet.getTotalScore();
			asLList.add(new AnswerSheetForList(asid, title, testDate, totalScore));
		}
		return asLList;
	}

	@Override
	public AnswerSheet findAsheet(String asid) {
		AnswerSheet asheet = answerSheetDao.findAnswerSheet(asid);
		List<Answer> answerList = answerDao.findAllAnswers(asid);
		asheet.setOMRCard(answerList);
		return asheet;
	}

	@Override
	public int getNumberOfAnswerSheets(String id) {
		return answerSheetDao.getNumberOfAnswerSheets(id);
	}
	@Override
	public SheetTestRecord getSheetRecord(String sid) {
		return answerSheetDao.getSheetRecord(sid);
	}

	@Override
	public Solution findSolutionOfQuestion(String qid) {
		return solutionDao.findSolutionOfQuestion(qid);
	}

	@Override
	public List<Solution> findSolutionsOfSheet(String sid) {
		List<String> qidList=sheetQuestionDao.findQidsOfSheet(sid);
		List<Solution> solutionList=new ArrayList<>();
		for(String qid:qidList) {
			solutionList.add(findSolutionOfQuestion(qid));
		}
		return solutionList;
	}

	@Override
	public Map<String, Object> getMyRecord(String id) {
		return answerSheetDao.getMyRecord(id);
	}

}
