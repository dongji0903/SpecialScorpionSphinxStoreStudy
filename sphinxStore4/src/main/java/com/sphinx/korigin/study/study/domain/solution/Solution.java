package com.sphinx.korigin.study.study.domain.solution;

public class Solution {
	private String solid;
	private String qid;
	private String Stype;
	private String text;
	private String fileUrl;
	
	public Solution() {
		// TODO Auto-generated constructor stub
	}

	public Solution(String qid) {
		super();
		this.qid = qid;
	}

	public Solution(String solid, String qid) {
		super();
		this.solid = solid;
		this.qid = qid;
	}

	public String getQid() {
		return qid;
	}

	public String getSolid() {
		return solid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public void setSolid(String solid) {
		this.solid = solid;
	}

	public String getStype() {
		return Stype;
	}

	public void setStype(String stype) {
		Stype = stype;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	@Override
	public String toString() {
		return "Solution [solid=" + solid + ", qid=" + qid + ", Stype=" + Stype
				+ ", text=" + text + ", fileUrl=" + fileUrl + "]";
	}

	
	
}
