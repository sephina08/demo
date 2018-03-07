package com.ntut.practice.demo.controller.member;

import java.util.Map;

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
@RequestMapping(value = "member")//網址列的一開始
public class MemberController {

	@Autowired//注入 MemberService這個類別
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
	 * 此方法去修改會員
	 * 
	 * @return
	 */
	@RequestMapping(value = "goToUpdate", method = RequestMethod.GET)
	public String updatePage() {
		return "member/updateConsumer";
	}
	/**
	 * 此方法去首頁
	 * 
	 * @return
	 */
	@RequestMapping(value = "goToHome", method = RequestMethod.GET)
	public String homePage() {
		return "member/home";
	}
	/**
	 * 此方法去查詢會員資料
	 * 
	 * @return
	 */
	@RequestMapping(value = "showMember", method = RequestMethod.GET)
	public String showPage() {
		return "member/showMember";
	}
	
	
	
	
	

	/**
	 * 檢核使用者資訊後回傳一個map的錯誤格式. 如果有錯誤將該錯誤返回給使用者查看 
	 * 如果沒有錯誤就在新增成功後,導向使用者新增成功頁
	 * 
	 * @param bean
	 * @return
	 * ModelAndView可以同時傳值和導頁
	 */
	@PostMapping("apply")//只有一個value可以不用加value直接""帶值就好
	public ModelAndView apply(MemberFormBean bean) {
		Map<String, String> checkResult = memberService.check(bean);
		if (checkResult.size() != 0) {//如果錯誤訊息不等於0(代表有錯誤訊息)
			ModelAndView mav = new ModelAndView("member/signin");//就在導回同一個signin.jsp
			mav.addObject("errorMsg", checkResult);//把錯誤訊息放在errorMsg裡面,addObject方法類似setAttribute方法
			return mav;
		}
		
		memberService.insertMember(bean);		
		ModelAndView mav = new ModelAndView("member/signinSuccess");
		mav.addObject("email",bean.getEmail());
		return mav;
		
	}
	/**
	 * 
	 * 如果使用者輸入正確就噵向修改資料成功頁面
	 * 把值拿出來
	 * 
	 * @param bean
	 * @return
	 *
	 */
	@PostMapping("edit")
	public ModelAndView edit(MemberFormBean bean){
		memberService.updateConsumer(bean);
		ModelAndView mav = new ModelAndView("member/updateConsumerSuccess");
		mav.addObject("firstName",bean.getFirstName());
		mav.addObject("lastName",bean.getLastName());
		mav.addObject("mobile",bean.getMobile());
		mav.addObject("name",bean.getName());
		mav.addObject("tel",bean.getTel());
		mav.addObject("telExt",bean.getTelExt());
		return mav;
		
	}
	/**
	 * 
	 * 把使用者輸入email用字串帶參數email傳值給contorller
	 * 在呼叫service的方法
	 * service在呼叫dao拿到使用者所有的資料
	 * 
	 * @param bean
	 * @return
	 *
	 *
	 *
	 * TODO:
	 * @RequestParam("email") 放到參數上(如果前端有改變只要改這裡就好了)
	 * MemberBean 接露資料庫結構
	 * MemberBean > 小寫
	 * ModelAndView 空虛寂寞
	 * 
	 */
	@GetMapping("selectMember")
	public ModelAndView select(@RequestParam("email")String email){
		MemberFormBean bean = memberService.getMemberByEmail(email);
		ModelAndView mv = new ModelAndView("member/deleteMember");
		mv.addObject("memberFormBean", bean);
		return mv;
		
	}
	
	@GetMapping("deleteMember")
	public ModelAndView deleteMember(@RequestParam("email")String email){
		memberService.delectMember(email);
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
//	@GetMapping("deleteMember")
//	public void deleteMember(@RequestParam("mail")String email){
//		memberService.delectMember(email);
//		ModelAndView mv = new ModelAndView("member/deleteMember");
//		
//	}
	
	
}
