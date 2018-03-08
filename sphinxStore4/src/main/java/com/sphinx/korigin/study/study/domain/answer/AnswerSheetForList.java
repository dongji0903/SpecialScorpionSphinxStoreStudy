package com.sphinx.korigin.study.study.domain.answer;

import java.io.Serializable;
import java.util.Date;

public class AnswerSheetForList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8203990222249146851L;
	private String asid;
	private String title;
	private Date testDate;
	private double totalScore;
	
	public AnswerSheetForList(String asid, String title, Date testDate, double totalScore) {
		super();
		this.asid = asid;
		this.title = title;
		this.testDate = testDate;
		this.totalScore = totalScore;
	}

	public AnswerSheetForList() {
		// TODO Auto-generated constructor stub
	}

	public String getAsid() {
		return asid;
	}

	public void setBoardNum(String asid) {
		this.asid = asid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}
	
	
}
