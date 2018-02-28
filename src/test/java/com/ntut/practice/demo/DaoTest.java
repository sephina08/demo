package com.ntut.practice.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ntut.practice.demo.dao.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class DaoTest {
	@Autowired
	private MemberDao memberDao;

	@Test
	public void getgetMemberByTest() {
		memberDao.getMemberBy("cc@cc");
	}
}
