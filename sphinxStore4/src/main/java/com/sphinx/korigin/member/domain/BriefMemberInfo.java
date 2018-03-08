package com.sphinx.korigin.member.domain;

import java.io.Serializable;

public class BriefMemberInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3893009015751265637L;
	private String id;
	private String name;
	private String memberType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		return "BriefMemberInfo [id=" + id + ", name=" + name + ", memberType="
				+ memberType + "]";
	}

	public BriefMemberInfo() {
		// TODO Auto-generated constructor stub
	}

}
