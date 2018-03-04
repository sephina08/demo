package com.ntut.practice.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ntut.practice.demo.model.member.MemberFormBean;
import com.ntut.practice.demo.service.ValidateService;
import com.ntut.practice.demo.service.member.MemberService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
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
