package com.sphinx.korigin.study.study.domain.question;

import java.io.Serializable;
import java.util.List;

import com.sphinx.korigin.study.category.domain.Category;

public class Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6355604868117925891L;
	private String qid;
	private String text;
	private double score;
	private String fileUrl; // url따오는방식
	private String fileType;
	private String qtype;
	private String source;
	/* private String categoryTitle; */
	private List<Category> categories; // 이 문제에 지정된 카테고리(들)
	private String jongryu; // 문제종류 - 일상, topik....
	private String yeongyoeck; // 문제영역 - 읽기, 쓰기
	private String yoohyong; // 문제유형 - 빈칸, 순서....
	private String completed = "false";
	private int gid;

	public Question(String text, double score, String fileUrl,
			String fileType) {
		this.text = text;
		this.score = score;
		this.fileUrl = fileUrl;
		this.fileType = fileType;
	}

	public Question() {
		super();
	}

	public Question(String text, double score, String fileUrl, String fileType,
			String qtype, String source, List<Category> categories) {
		this.text = text;
		this.score = score;
		this.fileUrl = fileUrl;
		this.fileType = fileType;
		this.qtype = qtype;
		this.source = source;
		this.categories = categories;
	}

	public Question(String qid, String text, double score, String fileUrl,
			String fileType, String qtype, String source,
			List<Category> categories) {
		this.qid = qid;
		this.text = text;
		this.score = score;
		this.fileUrl = fileUrl;
		this.fileType = fileType;
		this.qtype = qtype;
		this.source = source;
		this.categories = categories;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public String getQid() {
		return qid;
	}

	public double getScore() {
		return score;
	}

	public String getText() {
		return text;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", text=" + text + ", score=" + score
				+ ", fileUrl=" + fileUrl + ", qtype=" + qtype + ", source="
				+ source + ", categories=" + categories + "]";
	}

	public String getJongryu() {
		return jongryu;
	}

	public void setJongryu(String jongryu) {
		this.jongryu = jongryu;
	}

	public String getYeongyoeck() {
		return yeongyoeck;
	}

	public void setYeongyoeck(String yeongyoeck) {
		this.yeongyoeck = yeongyoeck;
	}

	public String getYoohyong() {
		return yoohyong;
	}

	public void setYoohyong(String yoohyong) {
		this.yoohyong = yoohyong;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}
