package com.sphinx.korigin.study.study.domain.question;

import java.io.Serializable;

public class GroupQuestion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3331308285585821702L;
	private String gid;
	private String jongryu; // 종류
	private String yeongyoeck; // 영역
	private String yoohyong; // 유형
	private String fileUrl;		//묶음보기
	private int numOfQuestions = 0;
	private String text; // 내용
	private String OwnQuestions="N";

	public GroupQuestion() {
		// TODO Auto-generated constructor stub
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getNumOfQuestions() {
		return numOfQuestions;
	}

	public void setNumOfQuestions(int numOfQuestions) {
		this.numOfQuestions = numOfQuestions;
	}

	public String getOwnQuestions() {
		return OwnQuestions;
	}

	public void setOwnQuestions(String ownQuestions) {
		OwnQuestions = ownQuestions;
	}

	@Override
	public String toString() {
		return "GroupQuestion [gid=" + gid + ", jongryu=" + jongryu
				+ ", yeongyoeck=" + yeongyoeck + ", yoohyong=" + yoohyong
				+ ", numOfQuestions=" + numOfQuestions + ", text=" + text
				+ ", OwnQuestions=" + OwnQuestions + "]";
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	
}
