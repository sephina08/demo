package com.ntut.practice.demo.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntut.practice.demo.dao.member.JobDao;
import com.ntut.practice.demo.model.member.JobBean;

@Service
public class JobService {
	@Autowired
	private JobDao jobDao;

	public List<JobBean> getAllJob() {
		return jobDao.getAllJobs();

	}

}
