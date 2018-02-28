package com.ntut.practice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntut.practice.demo.dao.MemberDao;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public void getMemberBy(String mail){
		memberDao.getMemberBy(mail);
	}

}
