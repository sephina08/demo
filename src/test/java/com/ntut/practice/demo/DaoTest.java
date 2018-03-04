package com.ntut.practice.demo;

import com.ntut.practice.demo.dao.member.MemberDao;
import com.ntut.practice.demo.model.member.MemberBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = NONE)
public class DaoTest {
    @Autowired
    private MemberDao memberDao;

    @Test
    public void getgetMemberByTest() {
        memberDao.getMemberBy("cc@cc");
    }

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

}
