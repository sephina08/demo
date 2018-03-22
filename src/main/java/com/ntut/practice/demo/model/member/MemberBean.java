package com.ntut.practice.demo.model.member;


public class MemberBean {
	int userOid;
	private String userLastName;
	private String userFirstName;
	private String userEmail;
	private String userPasswd;
	private String userAddress;
	private String userMobile;
	private String userTel;
	private String userTelExt;
	private String userInterests;
	private String userJobs;
	private String userCity;
	private String userZone;
	
	
	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserInterests() {
		return userInterests;
	}

	public void setUserInterests(String userInterests) {
		this.userInterests = userInterests;
	}

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

	public String getUserJobs() {
		return userJobs;
	}

	public void setUserJobs(String userJobs) {
		this.userJobs = userJobs;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserZone() {
		return userZone;
	}

	public void setUserZone(String userZone) {
		this.userZone = userZone;
	}



}
