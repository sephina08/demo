package com.ntut.practice.demo.service.member;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ntut.practice.demo.dao.member.InterestDao;
import com.ntut.practice.demo.model.member.InterestBean;

@Service
public class InterestService {

	@Autowired
	private InterestDao interestDao;

	// 取得所有資料庫的興趣欄位
	public List<InterestBean> getAllInterest() {
		return interestDao.getAllInterest();
	}

}
