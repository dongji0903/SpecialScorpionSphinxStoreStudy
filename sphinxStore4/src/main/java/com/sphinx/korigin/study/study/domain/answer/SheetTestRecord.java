package com.sphinx.korigin.study.study.domain.answer;

import java.io.Serializable;

public class SheetTestRecord implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4041528020790134056L;
	private String sid;			//어느 시험
	private int count;
	private double minScore;	//최저점
	private double maxScore;	//최고점
	private double avgScore;	//평균점수

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getMinScore() {
		return minScore;
	}

	public void setMinScore(double minScore) {
		this.minScore = minScore;
	}

	public double getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(double maxScore) {
		this.maxScore = maxScore;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public SheetTestRecord() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SheetTestRecord [sid=" + sid + ", count=" + count + ", minScore=" + minScore
				+ ", maxScore=" + maxScore + ", avgScore=" + avgScore + "]";
	}

}
