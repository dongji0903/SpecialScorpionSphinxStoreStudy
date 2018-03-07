package com.sphinx.korigin.study.study.domain.solution;

public class SubjectiveSolution extends Solution {

	private String subAnswer;

	public String getSubAnswer() {
		return subAnswer;
	}

	public void setSubAnswer(String subAnswer) {
		this.subAnswer = subAnswer;
	}

	public SubjectiveSolution(String solid, String qid, String subAnswer) {
		super(solid, qid);
		this.subAnswer = subAnswer;
	}

	public SubjectiveSolution(String subAnswer) {
		super();
		this.subAnswer = subAnswer;
	}

	public SubjectiveSolution() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + "SubjectiveSolution [subAnswer=" + subAnswer + "]";
	}

}
