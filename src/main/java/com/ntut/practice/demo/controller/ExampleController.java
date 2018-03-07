package com.ntut.practice.demo.controller;

import com.ntut.practice.demo.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        memberService.getMemberByEmail(mail);
        return "member/memberProfile"; // 導引至 WEB-INF/views member/memberProfile .jsp
    }

    @GetMapping("errorTest")
    public String errorTest() {
        if (true) {
            throw new RuntimeException("Hi, there");
        }
        return null;
    }
}
