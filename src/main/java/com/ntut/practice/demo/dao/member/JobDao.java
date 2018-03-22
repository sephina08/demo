package com.ntut.practice.demo.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ntut.practice.demo.dao.BaseDao;
import com.ntut.practice.demo.model.member.JobBean;

@Repository
public class JobDao extends BaseDao {
	private String GETALLJOBS = "select * from jobs";
	public List<JobBean> getAllJobs() {
		List<JobBean> list = new ArrayList<>();
		try (Connection conn = getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(GETALLJOBS);) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				JobBean jb = new JobBean();
				jb.setJobOid(rs.getInt("JOB_OID"));
				jb.setJobValue(rs.getString("JOB_VALUE"));
				jb.setJobDesc(rs.getString("JOB_DESC"));
				list.add(jb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}