package com.sphinx.beautea.common.domain;

import java.util.Date;

public class Board {

	private String boardId;
	private String title; //글 제목
	private int type; // 일반게시글인지, 스트린샷인지, 리뷰인지 구분
	private Date writeDate;
	private boolean del;
	private String fileName; // 첨부된 파일명
	private String content; // 글 내용
	private String customerId; //작성자
	
	public Board() {
		this.writeDate = new Date();
	}
	
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public boolean isDel() {
		return del;
	}
	public void setDel(boolean del) {
		this.del = del;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
