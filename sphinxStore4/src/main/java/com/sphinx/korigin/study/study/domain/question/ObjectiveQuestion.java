package com.sphinx.korigin.study.study.domain.question;

import java.util.List;

import com.sphinx.korigin.study.category.domain.Category;

public class ObjectiveQuestion extends Question {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4585197330023511734L;
	private int numOfAnswer;
	private List<Distractor> distractorList;

	public ObjectiveQuestion(String qid, String text, double score,
			String fileUrl, String fileType, String qtype, String source,
			List<Category> categories, int numOfAnswer,
			List<Distractor> distractorList) {
		super(qid, text, score, fileUrl, fileType, qtype, source, categories);
		this.numOfAnswer = numOfAnswer;
		this.distractorList = distractorList;
	}

	public ObjectiveQuestion(String text, double score, String fileUrl,
			String fileType, String qtype, String source,
			List<Category> categories, int numOfAnswer,
			List<Distractor> distractorList) {
		super(text, score, fileUrl, fileType, qtype, source, categories);
		this.numOfAnswer = numOfAnswer;
		this.distractorList = distractorList;
	}

	public ObjectiveQuestion(String text, double score, String fileUrl,
			String fileType) {
		super(text, score, fileUrl, fileType);
	}

	public List<Distractor> getDistractorList() {
		return distractorList;
	}

	public int getNumOfAnswer() {
		return numOfAnswer;
	}

	public void setDistractorList(List<Distractor> distractorList) {
		this.distractorList = distractorList;
	}

	public void setNumOfAnswer(int numOfAnswer) {
		this.numOfAnswer = numOfAnswer;
	}

	@Override
	public String toString() {
		return "ObjectiveQuestion [numOfAnswer=" + numOfAnswer
				+ ", distractorList=" + distractorList + "]";
	}

}
