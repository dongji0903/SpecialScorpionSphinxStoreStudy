package com.sphinx.korigin.study.study.domain.answer;

import java.io.Serializable;

public class Answer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6890422597470884024L;
	private String aid;
	private int questionNum; //어느문제의 답안인지 설정
	private String answer; //답
	private boolean isCorrect; //정답유무
	private String asid; //해당 답안지 설정

	public Answer(int questionNum, String answer) {
		super();
		this.questionNum = questionNum;
		this.answer = answer;
	}

	public Answer(String aid, int questionNum, String answer, boolean isCorrect, String asid) {
		super();
		this.aid = aid;
		this.questionNum = questionNum;
		this.answer = answer;
		this.isCorrect = isCorrect;
		this.asid = asid;
	}

	public Answer(int questionNum, String answer, boolean isCorrect) {
		super();
		this.questionNum = questionNum;
		this.answer = answer;
		this.isCorrect = isCorrect;
	}


	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public int getQuestionNum() {
		return questionNum;
	}

	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public String getAsid() {
		return asid;
	}

	public void setAsid(String asid) {
		this.asid = asid;
	}

	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", qid=" + questionNum + ", answer=" + answer + ", isCorrect=" + isCorrect
				+ ", asid=" + asid + "]";
	}
	
	

}
