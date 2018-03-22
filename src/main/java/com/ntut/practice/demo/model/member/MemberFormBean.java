package com.ntut.practice.demo.model.member;


import java.util.List;


public class MemberFormBean {
	private String email;
	private String password;
	private String checkPassword;
	private String lastName;
	private String firstName;
	private String address;
	private String mobile;
	private String tel;
	private String telExt;
	private List<String> interests;
	private String interestsThroughComma;
	private String jobs;
	private String city;
	private String zone;
	
	
	/**
	 * 使用者填選完興趣後用List集合包裝起來,
	 * 但因為資料庫欄位是字串,多筆資料要逗號隔開,所以要手動轉換
	 * TODO:
	 */
//	public static void main(String[] args) {
//		MemberFormBean mfb = new MemberFormBean();
//		/** 模擬 checkbox 塞值 **/
//		mfb.setInterests(Arrays.asList("diving","reading","basketball","baseball","movie"));//asList是回傳一個List
//
//		MemberBean mb = new MemberBean();
//		String interests = null;
//		List<String> interestsCheckbox = mfb.getInterests();
//
//		if(interestsCheckbox!=null && interestsCheckbox.size()>0){//如果不寫!=null會有nutponException
//			for(int i=0;i<interestsCheckbox.size();i++){//把興趣的值全部拿出來
//				if(i!=0){//如果i不是0(就代表不是一個)
//					interests += ","+interestsCheckbox.get(i);//前面就要加一個逗號
//				}else{
//					interests = interestsCheckbox.get(i);//不然就直接拿出來
//				}
//			}
//		}
//		
////		System.out.println(interests);
//		
//		mb.setUserInterests(interests);
//		
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTelExt() {
		return telExt;
	}

	public void setTelExt(String telExt) {
		this.telExt = telExt;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public String getJobs() {
		return jobs;
	}

	public void setJobs(String jobs) {
		this.jobs = jobs;
	}

	public String getInterestsThroughComma() {
		return interestsThroughComma;
	}

	public void setInterestsThroughComma(String interestsThroughComma) {
		this.interestsThroughComma = interestsThroughComma;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}