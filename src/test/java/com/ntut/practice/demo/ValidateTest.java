package com.ntut.practice.demo;

import com.ntut.practice.demo.model.member.MemberFormBean;
import com.ntut.practice.demo.service.ValidateService;
import com.ntut.practice.demo.service.member.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

/**
 * @SpringBootTest 1.4.0 之後使用的註解。
 * classes 指定測試啟動設定檔，webEnvironment 指定測試環境。
 * https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html#boot-features-testing-spring-boot-applications
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = NONE)
public class ValidateTest {

    @Autowired
    private ValidateService validateService;

    @Autowired
    private MemberService memberService;

    @Test
    public void validateMailTest() {
        boolean validateMail = validateService.validateMail("123");
        assertThat(validateMail).isEqualTo(false);//assertThat斷言,isEqualTo是等於
    }

    @Test
    public void validateMemberTest() {
        MemberFormBean mfb = new MemberFormBean();
        mfb.setEmail("dd@dd");
        mfb.setPassword("d1d1d1d1");
        mfb.setCheckPassword("d1d1d1d1");
        mfb.setFirstName("吳");
        mfb.setLastName("晶晶");
        mfb.setMobile("0987349263");
        mfb.setTel("27948392");
        mfb.setTelExt("111");
        Map<String, String> checkResult = memberService.check(mfb);
        assertThat(checkResult.size()).isEqualTo(0);
    }

}
