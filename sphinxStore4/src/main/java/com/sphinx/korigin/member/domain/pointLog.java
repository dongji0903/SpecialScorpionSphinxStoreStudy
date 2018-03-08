package com.sphinx.korigin.member.domain;

import java.sql.Timestamp;

public class pointLog {
	private int num;
	private int addPoint;
	private int reducePoint;
	private int totalPoint;
	private Timestamp date;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAddPoint() {
		return addPoint;
	}

	public void setAddPoint(int addPoint) {
		this.addPoint = addPoint;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public int getReducePoint() {
		return reducePoint;
	}

	public void setReducePoint(int reducePoint) {
		this.reducePoint = reducePoint;
	}
}
