package com.sphinx.korigin.study.study.dao.answer;

import java.util.List;

import com.sphinx.korigin.study.study.domain.answer.Answer;





public interface AnswerDao {
	
	void createAnswer(Answer a);
	
	List<Answer> findAllAnswers();
	
	List<Answer> findAllAnswers(String asid);
	
	Answer findAnswer(String aid);
	
	void updateAnswer(Answer a);
	
	void deleteAnswer(String aid);
	
}
