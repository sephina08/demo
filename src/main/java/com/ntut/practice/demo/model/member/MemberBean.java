package com.ntut.practice.demo.model.member;

import java.sql.Timestamp;

public class MemberBean {
	int userOid;
	String userLastName;
	String userFirstName;
	String userEmail;
	String userPasswd;
	String userStatus;
	String userZipCode;
	String userAddress;
	String userMobile;
	String userTel;
	String userTelExt;
	

	public MemberBean() {
		super();
	}

	public MemberBean(String userEmail) {
		super();
		this.userEmail = userEmail;
	}

	


	public int getUserOid() {
		return userOid;
	}

	public void setUserOid(int userOid) {
		this.userOid = userOid;
	}

	

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserZipCode() {
		return userZipCode;
	}

	public void setUserZipCode(String userZipCode) {
		this.userZipCode = userZipCode;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserTelExt() {
		return userTelExt;
	}

	public void setUserTelExt(String userTelExt) {
		this.userTelExt = userTelExt;
	}

	
	public String getuserLastName() {
		return userLastName;
	}

	public void setuserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

}
