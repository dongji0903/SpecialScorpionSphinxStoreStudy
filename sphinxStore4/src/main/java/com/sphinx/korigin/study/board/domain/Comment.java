package com.sphinx.korigin.study.board.domain;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8067548173066373622L;
	private int num;
	private int ref;
	private String nickname;
	private String content;
	private Date writedate;
	private String category;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
