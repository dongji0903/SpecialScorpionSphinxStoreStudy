package com.sphinx.korigin.study.study.domain.question;

import java.io.Serializable;

public class Distractor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6304110039536545601L;
	private String did;
	private String text;
	private String qid;

	public Distractor(String did, String text, String qid) {
		super();
		this.did = did;
		this.text = text;
		this.qid = qid;
	}

	public Distractor(String text) {
		super();
		this.text = text;
	}

	public Distractor(String text, String qid) {
		super();
		this.text = text;
		this.qid = qid;
	}

	public String getDid() {
		return did;
	}

	public String getQid() {
		return qid;
	}

	public String getText() {
		return text;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distractor other = (Distractor) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Distractor [did=" + did + ", text=" + text + ", qid=" + qid + "]";
	}

}
