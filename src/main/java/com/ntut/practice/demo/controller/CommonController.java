package com.ntut.practice.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 註冊首頁用, 請勿在此加任何控制頁面相關邏輯
 */
@Controller
public class CommonController {

	/**
	 * 從 src/main/resources/application.yml 取值, ${} 為 SPEL 表達式。 大部分情境下配合 @Value
	 * 比較多
	 */
	@Value("${project.page.index}")
	private String INDEX_PAGE;

	/**
	 * 導引至 WEB-INF/views 底下的 index .jsp 請參考 src/main/resources/application.yml
	 * 設定
	 */
	@GetMapping("/")
	public String indexPage() {
		return INDEX_PAGE;
	}
	
	/**
	 * 導到首頁
	 */
	@GetMapping("homeMember")
	public String homeMember(){
		return "member/homeMember";
		
	}

}
