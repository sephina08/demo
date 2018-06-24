package com.ntut.practice.demo.controller;

import com.ntut.practice.demo.dao.MemberMapper;
import com.ntut.practice.demo.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 註冊首頁用, 請勿在此加任何控制頁面相關邏輯
 */
@Controller
public class CommonController {

    @Autowired
    private MemberMapper memberMapper;

    /**
     * 從 src/main/resources/application.yml 取值, ${} 為 SPEL 表達式。
     * 大部分情境下配合 @Value 比較多
     */
    @Value("${project.page.index}")
    private String INDEX_PAGE;

    /**
     * 導引至 WEB-INF/views 底下的 index .jsp
     * 請參考 src/main/resources/application.yml 設定
     */
    @GetMapping("/")
    public String indexPage() {
        return INDEX_PAGE;
    }

    @GetMapping("/selectAll")
    @ResponseBody
    public List<Member> selectAll(){
        return memberMapper.selectAll();
    }
}
