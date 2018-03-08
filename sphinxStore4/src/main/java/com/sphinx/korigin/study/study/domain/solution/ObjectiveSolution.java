package com.sphinx.korigin.study.study.domain.solution;

import java.util.List;

import com.sphinx.korigin.study.study.domain.question.Distractor;

public class ObjectiveSolution extends Solution {

	private int numOfAnswer;
	private List<Distractor> dList;

	public ObjectiveSolution() {
		// TODO Auto-generated constructor stub
	}

	public ObjectiveSolution(List<Distractor> dList) {
		super();
		this.dList = dList;
	}

	public ObjectiveSolution(String solid, String qid, int numOfAnswer,
			List<Distractor> dList) {
		super(solid, qid);
		this.numOfAnswer = numOfAnswer;
		this.dList = dList;
	}

	public ObjectiveSolution(String qid, int numOfAnswer,
			List<Distractor> dList) {
		super(qid);
		this.numOfAnswer = numOfAnswer;
		this.dList = dList;
	}

	public ObjectiveSolution(int numOfAnswer, List<Distractor> dList) {
		super();
		this.numOfAnswer = numOfAnswer;
		this.dList = dList;
	}

	public List<Distractor> getDList() {
		return dList;
	}

	public void setDList(List<Distractor> dList) {
		this.dList = dList;
	}

	public int getNumOfAnswer() {
		return numOfAnswer;
	}

	public void setNumOfAnswer(int numOfAnswer) {
		this.numOfAnswer = numOfAnswer;
	}

	@Override
	public String toString() {
		return super.toString() + "ObjectiveSolution [numOfAnswer="
				+ numOfAnswer + ", dList=" + dList + "]";
	}

}
