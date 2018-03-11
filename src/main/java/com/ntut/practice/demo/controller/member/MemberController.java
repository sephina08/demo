package com.ntut.practice.demo.controller.member;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ntut.practice.demo.model.member.MemberBean;
import com.ntut.practice.demo.model.member.MemberFormBean;
import com.ntut.practice.demo.service.member.MemberService;

@Controller
@RequestMapping(value = "member") // 網址列的一開始
public class MemberController {

	@Autowired // 注入 MemberService這個類別
	private MemberService memberService;

	// forward:網址不會變,傳資料(把request裡面的資料一起傳到下個mvc元件)
	// redirect:網址會改變(不會保留request,就不會洩漏資料)
	@GetMapping("toIndex")
	public String toIndex() {
		return "forward:/memberIndex";
	}

	/**
	 * 此方法去註冊
	 */
	@RequestMapping(value = "goToSignin", method = RequestMethod.GET)
	public String signinPage() {
		return "member/signin";
	}

	/**
	 * 此方法去修改會員
	 */
	@RequestMapping(value = "goToUpdate", method = RequestMethod.GET)
	public String updatePage() {
		return "member/updateConsumer";
	}

	/**
	 * 此方法去會員首頁
	 */
	@RequestMapping(value = "memberIndex", method = RequestMethod.GET)
	public String memberHomePage() {
		return "member/memberIndex";
	}

	/**
	 * 此方法去查詢會員資料(讓使用者輸入email)
	 */
	@RequestMapping(value = "selectMember", method = RequestMethod.GET)
	public String showPage() {

		return "member/showMember";
	}

	/**
	 * 檢核使用者資訊後回傳一個map的錯誤格式. 如果有錯誤將該錯誤返回給使用者查看
	 * 如果沒有錯誤就在新增成功後,導向使用者新增成功頁
	 * @param bean
	 * @return ModelAndView可以同時傳值和導頁
	 */
	@PostMapping("apply") // 只有一個value可以不用加value直接""帶值就好
	public ModelAndView apply(MemberFormBean bean) {
		Map<String, String> checkResult = memberService.check(bean);
		if (checkResult.size() != 0) {// 如果錯誤訊息不等於0(代表有錯誤訊息)
			ModelAndView mav = new ModelAndView("member/signin");// 就在導回同一個signin.jsp
			mav.addObject("errorMsg", checkResult);// 把錯誤訊息放在errorMsg裡面,addObject方法類似setAttribute方法
			return mav;
		}
		memberService.insertMember(bean);
		ModelAndView mav = new ModelAndView("member/signinSuccess");
		mav.addObject("email", bean.getEmail());
		return mav;
	}

	/**
	 * 把使用者輸入的email用字串帶到參數email傳值給contorller 在呼叫service的方法
	 * service在呼叫dao用email拿到所有使用者資料 
	 * 判斷使用者輸入的email是否存在
	 * 1.使用者在畫面輸入email傳到controller的參數
	 * 2.去getMemberByEmail方法查詢使用者資訊,如果使用者輸入資料錯誤會拋nullPointException拋出例外
	 * 3.就會跳回catch區塊去做判斷
	 * 4.StringUtils.isBlank(email):去掉頭尾空白,長度等於0(表示使用者沒有輸入任何資料)
	 * 5.輸入資料正確可以跳到使用者編輯頁面
	 * @param bean
	 * @return TODO: @RequestParam("email") 放到參數上(如果前端有改變只要改這裡就好了)
	 */
	@GetMapping("showMember")
	public ModelAndView select(@RequestParam("email") String email) {
		ModelAndView mav = null;
		try {
			MemberFormBean bean = memberService.getMemberByEmail(email);
			mav = new ModelAndView("member/updateConsumer");
			mav.addObject("memberFormBean", bean);
		} catch (Exception e) {
			mav = new ModelAndView("member/showMember");
			if (StringUtils.isBlank(email)) {
				mav.addObject("errorMessage", "請輸入電子信箱");
			} else {
				mav.addObject("errorMessage", "找不此電子信箱");
			}

		}
		return mav;
	}

	/**
	 * 此方法去後端管理頁面查詢所有使用者 用list包裝所有的會員資料 給addObject傳值帶到前端
	 * 
	 * @return
	 */
	@GetMapping("selectAllMember")
	public ModelAndView selectAllMember() {
		List<MemberFormBean> allMember = memberService.getAllMember();
		ModelAndView mav = new ModelAndView("member/showAllMember");
		mav.addObject("memberFormBeanList", allMember);
		return mav;

	}

	// 修改會員
	@GetMapping("edit")
	public ModelAndView edit(MemberFormBean bean) {
		memberService.updateConsumer(bean);
		ModelAndView mav = new ModelAndView("member/updateConsumerSuccess");
		mav.addObject("email", bean.getEmail());
		mav.addObject("firstName", bean.getFirstName());
		mav.addObject("lastName", bean.getLastName());
		mav.addObject("mobile", bean.getMobile());
		mav.addObject("tel", bean.getTel());
		mav.addObject("telExt", bean.getTelExt());
		return mav;
	}

	// 刪除會員
	@GetMapping("deleteMember")
	public ModelAndView deleteMember(@RequestParam("email") String email) {
		memberService.delectMember(email);
		ModelAndView mv = new ModelAndView("member/home");
		return mv;
	}

}
