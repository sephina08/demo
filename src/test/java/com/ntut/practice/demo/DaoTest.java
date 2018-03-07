package com.ntut.practice.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ntut.practice.demo.dao.member.MemberDao;
import com.ntut.practice.demo.model.member.MemberBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class) // 掃整個Application
public class DaoTest {
	
	@Autowired
	private MemberDao memberDao;

	@Test
	public void insertInTo() {
		MemberBean bean = new MemberBean();
		bean.setUserName("dd@dd");
		bean.setUserEmail("dd@dd");
		bean.setuserLastName("晶晶");
		bean.setUserFirstName("吳");
		bean.setUserPasswd("d1d1d1d1");
		bean.setUserMobile("0987349263");
		bean.setUserTel("27948392");
		bean.setUserTelExt("111");
		memberDao.insertUser(bean);
	}

	@Test
	public void updateConsuner() {
		MemberBean bean = new MemberBean();
		bean.setUserName("dd@dd");
		bean.setUserEmail("dd@dd");
		bean.setuserLastName("詹");
		bean.setUserFirstName("仔子");
		bean.setUserPasswd("d1d1d1d1");
		bean.setUserMobile("0987349263");
		bean.setUserTel("27948392");
		bean.setUserTelExt("333");
		memberDao.updateUser(bean);

	}

	@Test
	public void getMemberByTest() {
		memberDao.getMemberByEmail("aa@aa");
	}
	
	@Test
	public void deleteMember(){
		memberDao.delete("dd@dd");
	}

}
