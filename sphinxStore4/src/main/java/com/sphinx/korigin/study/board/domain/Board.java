package com.sphinx.korigin.study.board.domain;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = -839230812986293862L;
	private int num;
	private String nickName;
	private String email;
	private String board_title;
	private String board_url;
	private String board_content;
	private int readcount;
	private Date writedate;
	private String category;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return board_title;
	}

	public void setTitle(String board_title) {
		this.board_title = board_title;
	}

	public String getContent() {
		return board_content;
	}

	public void setContent(String board_content) {
		this.board_content = board_content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int board_readcount) {
		this.readcount = board_readcount;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public String getUrl() {
		return board_url;
	}

	public void setUrl(String board_url) {
		this.board_url = board_url;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
