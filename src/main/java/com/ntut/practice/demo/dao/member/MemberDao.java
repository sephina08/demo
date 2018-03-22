package com.ntut.practice.demo.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ntut.practice.demo.dao.BaseDao;
import com.ntut.practice.demo.model.member.MemberBean;

@Repository
public class MemberDao extends BaseDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberDao.class);

	public MemberBean getMemberByEmail(String mail) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		MemberBean result = null;
		try {
			/***** *****/
			conn = getConnection(); // 透過父類別取得連線
			/***** *****/
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT USER_LAST_NAME,USER_FIRST_NAME,USER_EMAIL,USER_PASSWD,");
			sb.append("USER_MOBILE,USER_TEL_EXT,USER_TEL,USER_INTERESTS,USER_JOBS,USER_CITY,USER_ZONE,USER_ADDRESS ");
			sb.append("FROM SUSER WHERE USER_EMAIL=?");
			String sqlQueryString = sb.toString();
			stmt = conn.prepareStatement(sqlQueryString);
			stmt.setString(1, mail);
			rset = stmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			int columnLength = rsmd.getColumnCount();

			while (rset.next()) {
				for (int i = 1; i <= columnLength; i++) {
					result = new MemberBean();
					result.setuserLastName(rset.getString("USER_LAST_NAME"));
					result.setUserFirstName(rset.getString("USER_FIRST_NAME"));
					result.setUserEmail(rset.getString("USER_EMAIL"));
					result.setUserPasswd(rset.getString("USER_PASSWD"));
					result.setUserMobile(rset.getString("USER_MOBILE"));
					result.setUserTelExt(rset.getString("USER_TEL_EXT"));
					result.setUserTel(rset.getString("USER_TEL"));
					result.setUserInterests(rset.getString("USER_INTERESTS"));
					result.setUserJobs(rset.getString("USER_JOBS"));
					result.setUserCity(rset.getString("USER_CITY"));
					result.setUserZone(rset.getString("USER_ZONE"));
					result.setUserAddress(rset.getString("USER_ADDRESS"));
				}
			}

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private String ALLMEMBERSQL = "SELECT * FROM SUSER";

	public List<MemberBean> getAllMember() {
		List<MemberBean> list = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(ALLMEMBERSQL)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				MemberBean mb = new MemberBean();
				mb.setuserLastName(rs.getString("USER_LAST_NAME"));
				mb.setUserFirstName(rs.getString("USER_FIRST_NAME"));
				mb.setUserEmail(rs.getString("USER_EMAIL"));
				mb.setUserPasswd(rs.getString("USER_PASSWD"));
				mb.setUserMobile(rs.getString("USER_MOBILE"));
				mb.setUserTelExt(rs.getString("USER_TEL_EXT"));
				mb.setUserTel(rs.getString("USER_TEL"));
				mb.setUserCity(rs.getString("USER_CITY"));
				mb.setUserZone(rs.getString("USER_ZONE"));
				mb.setUserAddress(rs.getString("USER_ADDRESS"));
				mb.setUserInterests(rs.getString("USER_INTERESTS"));
				mb.setUserJobs(rs.getString("USER_JOBS"));
				

				list.add(mb);
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return list;
	}

	private String INSERTSQL = "INSERT INTO SUSER(USER_EMAIL,USER_LAST_NAME,USER_FIRST_NAME,USER_PASSWD,"
			+ "USER_MOBILE,USER_TEL,USER_TEL_EXT,USER_INTERESTS,USER_JOBS,USER_CITY,USER_ZONE,USER_ADDRESS )"
			+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public void insertUser(MemberBean bean) {
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERTSQL)) {
			stmt.setString(1, bean.getUserEmail());
			stmt.setString(2, bean.getuserLastName());
			stmt.setString(3, bean.getUserFirstName());
			stmt.setString(4, bean.getUserPasswd());
			stmt.setString(5, bean.getUserMobile());
			stmt.setString(6, bean.getUserTel());
			stmt.setString(7, bean.getUserTelExt());
			stmt.setString(8, bean.getUserInterests());
			stmt.setString(9, bean.getUserJobs());
			stmt.setString(10, bean.getUserCity());
			stmt.setString(11, bean.getUserZone());
			stmt.setString(12, bean.getUserAddress());
			stmt.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
	}

	private String UPDATESQL = "UPDATE SUSER SET USER_LAST_NAME=?,USER_FIRST_NAME=?,"
			+ " USER_MOBILE=?,USER_TEL=?,USER_TEL_EXT=?,USER_INTERESTS=?,USER_JOBS=?,"
			+ " USER_CITY=?,USER_ZONE=?,USER_ADDRESS=? "
			+ " WHERE USER_EMAIL=?";

	public int updateUser(MemberBean bean) {

		int updateCount = 0;
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(UPDATESQL);) {
			stmt.setString(1, bean.getuserLastName());
			stmt.setString(2, bean.getUserFirstName());
			stmt.setString(3, bean.getUserMobile());
			stmt.setString(4, bean.getUserTel());
			stmt.setString(5, bean.getUserTelExt());
			stmt.setString(6, bean.getUserInterests());
			stmt.setString(7, bean.getUserJobs());
			stmt.setString(8, bean.getUserCity());
			stmt.setString(9, bean.getUserZone());
			stmt.setString(10, bean.getUserAddress());
			stmt.setString(11, bean.getUserEmail());
			updateCount = stmt.executeUpdate();
		
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return updateCount;
	}

	private String DELETESQL = "DELETE FROM SUSER WHERE USER_EMAIL = ?";

	public void delete(String mail) {
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(DELETESQL)) {
			stmt.setString(1, mail);
			stmt.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}

	}

}
