package com.ntut.practice.demo.dao.member;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.ntut.practice.demo.dao.BaseDao;
import com.ntut.practice.demo.model.member.InterestBean;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class InterestDao extends BaseDao {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private String ALLINTERESTSQL = "SELECT * FROM INTERESTS";

	public List<InterestBean> getAllInterest() {
		List<InterestBean> list = new ArrayList<>();
		try (Connection conn = getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(ALLINTERESTSQL);
			ResultSet rs = stmt.executeQuery();) {
			while(rs.next()){
				InterestBean interestBean = new InterestBean();
				interestBean.setInterestOid(rs.getInt("interest_OID"));
				interestBean.setInterestValue(rs.getString("interest_value"));
				interestBean.setInterestDesc(rs.getString("interest_desc"));
				list.add(interestBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}
	
//	private String INSERTINTOSQL="INSERT INTO INTERESTS(INTEREST_OID,INTEREST_VALUE,INTEREST_DESC) VALUES(?,?,?)";
//	public void insertInterest(InterestBean bean){
//		try(Connection conn = getConnection();
//			PreparedStatement stmt = conn.prepareStatement(INSERTINTOSQL);){
//			stmt.setInt(1, bean.getInterestOid());
//			stmt.setString(2, bean.getInterestValue());
//			stmt.setString(3, bean.getInterestDesc());
//			stmt.executeUpdate();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//	
	

}
