package com.sphinx.korigin.study.study.domain.exam;

import java.io.Serializable;
import java.util.List;

import com.sphinx.korigin.study.study.domain.question.GroupQuestion;

public class ExamForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 317823168806430712L;
	private String eid;
	private String jongryu;
	private String coverUrl;
	private List<GroupQuestion> gList;

	public String getEid() {
		return eid;
	}

	public void setEid(String eid2) {
		this.eid = eid2;
	}

	public String getJongryu() {
		return jongryu;
	}

	public void setJongryu(String jongryu) {
		this.jongryu = jongryu;
	}

	public List<GroupQuestion> getgList() {
		return gList;
	}

	public void setgList(List<GroupQuestion> gList) {
		this.gList = gList;
	}

	public ExamForm() {
		super();
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	@Override
	public String toString() {
		return "ExamForm [eid=" + eid + ", jongryu=" + jongryu + ", coverUrl="
				+ coverUrl + ", gList=" + gList + "]";
	}

}
