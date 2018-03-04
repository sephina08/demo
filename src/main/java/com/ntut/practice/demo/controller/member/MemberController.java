package com.ntut.practice.demo.controller.member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ntut.practice.demo.dao.member.MemberDao;
import com.ntut.practice.demo.model.member.MemberFormBean;
import com.ntut.practice.demo.service.member.MemberService;

@Controller
@RequestMapping(value = "member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	/**
	 * 此方法去註冊
	 * 
	 * @return
	 */
	@RequestMapping(value = "goToSignin", method = RequestMethod.GET)
	public String signinPage() {
		return "member/signin";
	}

	/**
	 * 檢核使用者資訊後回傳一個map的錯誤格式. 如果有錯誤將該錯誤返回給使用者查看 
	 * 如果沒有錯誤就在新增成功後,導向使用者新增成功頁
	 * 
	 * @param bean
	 * @return
	 */
	@PostMapping("apply")//只有一個value可以不用加value直接""帶值就好
	public ModelAndView apply(MemberFormBean bean) {
		Map<String, String> checkResult = memberService.check(bean);
		if (checkResult.size() != 0) {
			ModelAndView mav = new ModelAndView("member/signin");
			mav.addObject("errorMsg", checkResult);
			return mav;
		}
		
		memberService.insertMember(bean);		
		ModelAndView mav = new ModelAndView("member/signinSuccess");
		mav.addObject("email",bean.getEmail());
		return mav;
		
	}
}
