package com.sphinx.korigin.study.study.domain.exam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.sphinx.korigin.study.study.domain.question.Question;

public class Sheet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1598894356856769L;
	private String sid;
	private String title;
	private String grade; // 난이도, 등급
	private int numOfQuestion; // 문제수
	private String examiner; // 출제자. 세션
	private Date createSheetDate; // 출제일
	private int limitTime; // 제한시간
	private List<Question> questionList;
	private String completed = "false";

	public Sheet(String sid, String title, String grade, int numOfQuestion,
			String examiner, Date createSheetDate, int limitTime,
			List<Question> questionList) {
		super();
		this.sid = sid;
		this.title = title;
		this.grade = grade;
		this.numOfQuestion = numOfQuestion;
		this.examiner = examiner;
		this.createSheetDate = createSheetDate;
		this.limitTime = limitTime;
		this.questionList = questionList;
	}

	public Sheet(String title, String grade, int numOfQuestion, String examiner,
			Date createSheetDate, int limitTime, List<Question> questionList) {
		super();
		this.title = title;
		this.grade = grade;
		this.numOfQuestion = numOfQuestion;
		this.examiner = examiner;
		this.createSheetDate = createSheetDate;
		this.limitTime = limitTime;
		this.questionList = questionList;
	}

	public Sheet(String title, String grade, int numOfQuestion, String examiner,
			Date createSheetDate, int limitTime) {
		super();
		this.title = title;
		this.grade = grade;
		this.numOfQuestion = numOfQuestion;
		this.examiner = examiner;
		this.createSheetDate = createSheetDate;
		this.limitTime = limitTime;
	}

	public Sheet(String sid, String examiner, Date createSheetDate,
			int limitTime, String title, String grade, int numOfQuestion) {
		this.sid = sid;
		this.examiner = examiner;
		this.createSheetDate = createSheetDate;
		this.limitTime = limitTime;
		this.title = title;
		this.grade = grade;
		this.numOfQuestion = numOfQuestion;
	}

	public Sheet() {
		// TODO Auto-generated constructor stub
	}

	public Sheet(String sid, String title, String grade, int numOfQuestion,
			String examiner, Date createSheetDate, int limitTime,
			String completed) {
		super();
		this.sid = sid;
		this.title = title;
		this.grade = grade;
		this.numOfQuestion = numOfQuestion;
		this.examiner = examiner;
		this.createSheetDate = createSheetDate;
		this.limitTime = limitTime;
		this.completed = completed;
	}

	public Date getCreateSheetDate() {
		return createSheetDate;
	}

	public String getExaminer() {
		return examiner;
	}

	public String getGrade() {
		return grade;
	}

	public int getLimitTime() {
		return limitTime;
	}

	public int getNumOfQuestion() {
		return numOfQuestion;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public String getSid() {
		return sid;
	}

	public void setCreateSheetDate(Date createSheetDate) {
		this.createSheetDate = createSheetDate;
	}

	public void setExaminer(String examiner) {
		this.examiner = examiner;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setLimitTime(int limitTime) {
		this.limitTime = limitTime;
	}

	public void setNumOfQuestion(int numOfQuestion) {
		this.numOfQuestion = numOfQuestion;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Sheet [sid=" + sid + ", title=" + title + ", grade=" + grade
				+ ", numOfQuestion=" + numOfQuestion + ", examiner=" + examiner
				+ ", createSheetDate=" + createSheetDate + ", limitTime="
				+ limitTime + ", questionList=" + questionList + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

}
