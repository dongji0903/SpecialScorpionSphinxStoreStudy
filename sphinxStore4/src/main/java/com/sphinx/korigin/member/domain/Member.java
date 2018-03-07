package com.sphinx.korigin.member.domain;

import java.util.Date;

public class Member {
	private String memberId; // pk
	private String sphixId;
	private String password;
	private String name;
	private String nickName;
	private String email;
	private String addr;
	private String nationalCode;
	private String phoneNum;
	private Date joinDate;
	private Date birth;
	private String memberType;
	private int point;
	private boolean del;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getSphixId() {
		return sphixId;
	}

	public void setSphixId(String sphixId) {
		this.sphixId = sphixId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getNationalCode() {
		return nationalCode;
	}

	public void setNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public boolean getDel() {
		return del;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", sphixId=" + sphixId
				+ ", password=" + password + ", name=" + name + ", nickName="
				+ nickName + ", email=" + email + ", addr=" + addr
				+ ", nationalCode=" + nationalCode + ", phoneNum=" + phoneNum
				+ ", joinDate=" + joinDate + ", birth=" + birth
				+ ", memberType=" + memberType + ", point=" + point + ", del="
				+ del + "]";
	}

	public void setDel(boolean del) {
		this.del = del;
	}

}
