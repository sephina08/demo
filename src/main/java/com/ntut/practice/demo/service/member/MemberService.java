package com.ntut.practice.demo.service.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntut.practice.demo.Application;
import com.ntut.practice.demo.dao.member.MemberDao;
import com.ntut.practice.demo.model.member.MemberBean;
import com.ntut.practice.demo.model.member.MemberFormBean;
import com.ntut.practice.demo.service.utils.ValidateService;

@Service
public class MemberService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private ValidateService validateService;

	/**
	 * 查詢會員 TODO: A to B
	 * 
	 * @param mail
	 */
	public MemberFormBean getMemberByEmail(String mail) {
		MemberBean bean = memberDao.getMemberByEmail(mail);
		MemberFormBean memberFormBean = new MemberFormBean();
		memberFormBean.setEmail(bean.getUserEmail());
		memberFormBean.setFirstName(bean.getUserFirstName());
		memberFormBean.setLastName(bean.getuserLastName());
		memberFormBean.setMobile(bean.getUserMobile());
		memberFormBean.setTel(bean.getUserTel());
		memberFormBean.setTelExt(bean.getUserTelExt());
		return memberFormBean;
	}

	/**
	 * 查詢所有的會員資料 從dao拿到所有的會員資料包在list裡面 TODO:用for迴圈把值全部帶出來 A to B
	 */

	public List<MemberFormBean> getAllMember() {
		List<MemberFormBean> result = new ArrayList<>();
		List<MemberBean> allMember = memberDao.getAllMember();
		for (MemberBean mb : allMember) {
			MemberFormBean mfb = new MemberFormBean();
			// AtoB
			mfb.setEmail(mb.getUserEmail());
			mfb.setFirstName(mb.getUserFirstName());
			mfb.setLastName(mb.getuserLastName());
			mfb.setMobile(mb.getUserMobile());
			mfb.setTel(mb.getUserTel());
			mfb.setTelExt(mb.getUserTelExt());
			result.add(mfb);
//			Map<String, String> errorMessage = new HashMap<>();
//			String email = mfb.getEmail();
//			if (email == null || email.trim().length() == 0) {
//				errorMessage.put("email", "電子信箱不存在");
//			}

		}
		return result;

	}

	//
	// //查詢使用者資料,檢查電子信箱是否存在
	// public Map<String, String> checkEmail(MemberFormBean bean){
	// Map<String, String> errorMessage = new HashMap<>();
	// String email = bean.getEmail();
	// if (email == null || email.trim().length() == 0) {
	// errorMessage.put("email", "電子信箱不存在");
	// }
	// return errorMessage;
	//
	// }

	// 修改會員
	public int updateConsumer(MemberFormBean memberFormBean) {
		MemberBean bean = new MemberBean();
		bean.setUserEmail(memberFormBean.getEmail());
		bean.setuserLastName(memberFormBean.getLastName());
		bean.setUserFirstName(memberFormBean.getFirstName());
		// bean.setUserAddress(memberFormBean.getAddress());
		bean.setUserMobile(memberFormBean.getMobile());
		bean.setUserTel(memberFormBean.getTel());
		bean.setUserTelExt(memberFormBean.getTelExt());
		int updateCount = memberDao.updateUser(bean);
		LOGGER.debug("update count:{}", updateCount);
		return updateCount;
	}

	// 使用者輸入正確傳值到dao
	// TODO想一個都沒有錯誤訊息,成功的方法把INSERTDAO寫進去
	// controller不能直接呼叫dao不然會資料結構外洩,Service也不能資料結構外洩,所以用controller的MemberFormBean去setMemberBean
	public void insertMember(MemberFormBean memberFormBean) {
		MemberBean bean = new MemberBean();
		bean.setUserEmail(memberFormBean.getEmail());
		bean.setUserPasswd(memberFormBean.getPassword());
		bean.setUserPasswd(memberFormBean.getCheckPassword());
		bean.setuserLastName(memberFormBean.getLastName());
		bean.setUserFirstName(memberFormBean.getFirstName());
		// bean.setUserAddress(memberFormBean.getAddress());
		bean.setUserMobile(memberFormBean.getMobile());
		bean.setUserTel(memberFormBean.getTel());
		bean.setUserTelExt(memberFormBean.getTelExt());

		memberDao.insertUser(bean);
	}

	/**
	 * 刪除會員
	 */
	public void delectMember(String mail) {
		memberDao.delete(mail);

	}

	// 檢查使用者表單的錯誤訊息,如果有錯誤用 Map格式回傳
	public Map<String, String> check(MemberFormBean bean) {
		Map<String, String> errorMessage = new HashMap<>();

		String email = bean.getEmail();
		if (email == null || email.trim().length() == 0) {
			errorMessage.put("email", "必須輸入電子信箱");
		} else if (!validateService.validateMail(email)) {
			errorMessage.put("email", "信箱格式不正確");
		}

		String password = bean.getPassword();
		if (password == null || password.trim().length() == 0) {
			errorMessage.put("password", "必須輸入密碼");
		} else if ((password.length() > 20) || (password.length() < 8)) {
			errorMessage.put("password", "密碼長度需8-20個字元");
		} else if (!password.matches("^(?=.*\\d)(?=.*[a-zA-Z]).{8,20}$")) {
			errorMessage.put("password", "密碼須包含英文、數字");
		}

		String checkPassword = bean.getCheckPassword();
		if (checkPassword == null || checkPassword.trim().length() == 0) {
			errorMessage.put("checkPassword", "必須輸入確認密碼");
		} else if (password == null || !password.equals(checkPassword)) {
			errorMessage.put("checkPassword", "兩次密碼不一致");
		}
		String userLastName = bean.getLastName();
		if (userLastName == null || userLastName.trim().length() == 0) {
			errorMessage.put("userLastName", "姓氏欄位不可空白");
		}
		String userFirstName = bean.getFirstName();
		if (userFirstName == null || userFirstName.trim().length() == 0) {
			errorMessage.put("userFirstName", "名字欄位不可空白");
		}
		String userMobile = bean.getMobile();
		if (userMobile == null || userMobile.trim().length() == 0) {
			errorMessage.put("userMobile", "手機欄位不可空白");
		}
		String userTel = bean.getTel();
		if (userTel == null || userTel.trim().length() == 0) {
			errorMessage.put("userTel", "電話欄位不可空白");
		}

		/**
		 * 找到email判斷資料庫裡面是否有值 如果已經有值就回傳錯誤訊息
		 */
		MemberBean memberEmail = memberDao.getMemberByEmail(email);
		if (memberEmail != null) {
			errorMessage.put("email", "電子信箱重複,請重新輸入");

		}

		return errorMessage;
	}

	/**
	 * 從資料庫拿到password進行加密
	 */

}
