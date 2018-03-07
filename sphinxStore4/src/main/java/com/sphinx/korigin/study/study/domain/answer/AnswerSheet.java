package com.sphinx.korigin.study.study.domain.answer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AnswerSheet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3117836408527400629L;
	private String asid;
	private String sid;
	private String testerId;// TBD
	private double totalScore;
	private Date testDate;
	private List<Answer> AnswerList;

	public AnswerSheet(String sid, String testerId, double totalScore, Date testDate) {
		super();
		this.sid = sid;
		this.testerId = testerId;
		this.totalScore = totalScore;
		this.testDate = testDate;
	}

	public AnswerSheet() {
		// TODO Auto-generated constructor stub
	}

	public AnswerSheet(String asid, String sid, String testerId, double totalScore, Date testDate, List<Answer> oMRCard) {
		super();
		this.asid = asid;
		this.sid = sid;
		this.testerId = testerId;
		this.totalScore = totalScore;
		this.testDate = testDate;
		AnswerList = oMRCard;
	}

	public AnswerSheet(String sid, String testerId, double totalScore, Date testDate, List<Answer> oMRCard) {
		super();
		this.sid = sid;
		this.testerId = testerId;
		this.totalScore = totalScore;
		this.testDate = testDate;
		AnswerList = oMRCard;
	}

	public String getAsid() {
		return asid;
	}

	public List<Answer> getOMRCard() {
		return AnswerList;
	}

	public String getSid() {
		return sid;
	}

	public Date getTestDate() {
		return testDate;
	}

	public String getTester() {
		return testerId;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setAsid(String asid) {
		this.asid = asid;
	}

	public void setOMRCard(List<Answer> oMRCard) {
		AnswerList = oMRCard;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public void setTester(String testerId) {
		this.testerId = testerId;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return "AnswerSheet [asid=" + asid + ", sid=" + sid + ", testerId="
				+ testerId + ", totalScore=" + totalScore + ", testDate="
				+ testDate + ", OMRCard=" + AnswerList + "]";
	}

	
	
	

}
