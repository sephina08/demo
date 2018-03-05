package com.ntut.practice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ntut.practice.demo.service.MemberService;

@Controller 
@RequestMapping(value = "example")
public class ExampleController {

	@Autowired
	private MemberService memberService;

	@ResponseBody // 自動以 contentType=application/json 傳值 (非導頁)
	@RequestMapping(value = "check", method = RequestMethod.GET)
	public String demoApi1() {
		return "Hi,this is a test for spring mvc";
	}
	
	@GetMapping("printMemberData") // 等同於 @RequestMapping(value = "printMemberData", method = RequestMethod.GET)
	public String printMemberData(@RequestParam("email") String mail) {
		memberService.getMemberBy(mail);
		return "member/memberProfile"; // 導引至 WEB-INF/views member/memberProfile .jsp
	}
	
	@PostMapping("errorTest")
	public String errorTest(){
		if(true){
			throw new RuntimeException("Hi, there");
		}
		return null;
	}
	
	@GetMapping("testForPutAttribute") 
	public ModelAndView printMemberData() {
		ModelAndView rs = new ModelAndView("test/attributes");
		rs.addObject("myName", "KB");
		rs.addObject("myAge", 27);
		return rs; 
	}
}
