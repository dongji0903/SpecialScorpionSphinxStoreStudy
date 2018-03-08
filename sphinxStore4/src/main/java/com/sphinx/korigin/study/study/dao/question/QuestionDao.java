package com.sphinx.korigin.study.study.dao.question;

import java.util.List;

import com.sphinx.korigin.study.study.domain.question.Question;

public interface QuestionDao {

	public List<String> getAllJyp(String type);

	public String findJyp(String type, String text);

	public int createJyp(String type, String text);

	public String createQuestion(Question q);

	public List<Question> findAllQuestions();

	public Question findQuestion(String qid);

	public List<Question> findQuestions(String jongryu, String yeongyoeck, String yoohyong);

	public void updateQuestion(Question q);

}
