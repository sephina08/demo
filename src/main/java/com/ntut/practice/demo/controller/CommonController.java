package com.ntut.practice.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 註冊首頁用, 請勿在此加任何控制頁面相關邏輯
public class CommonController {

	// 導引至 WEB-INF/views 底下的 index
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage() {
		return "index";
	}
	
}
