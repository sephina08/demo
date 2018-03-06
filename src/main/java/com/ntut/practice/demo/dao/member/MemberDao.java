package com.ntut.practice.demo.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Repository;

import com.ntut.practice.demo.dao.BaseDao;
import com.ntut.practice.demo.model.member.MemberBean;

@Repository
public class MemberDao extends BaseDao {

	public String getMemberBy(String mail) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			/***** *****/
			conn = getConnection(); // 透過父類別取得連線
			/***** *****/
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT USER_OID,USER_LAST_NAME,USER_FIRST_NAME,USER_EMAIL,USER_PASSWD,USER_STATUS,");
			sb.append("USER_ZIP_CODE,USER_ADDRESS,USER_MOBILE,USER_TEL_EXT,USER_TEL,");
			sb.append("FARMER_ZIP_CODE,FARMER_ADDRESS,FARMER_MOBILE,FARMER_TEL,");
			sb.append("FARMER_TEL_EXT,FARMER_PROFILE,USER_LAST_LOGIN_TIME,");
			sb.append("USER_APPLY_DATE,USER_EMAIL_VAL_CODE ");
			sb.append("FROM SUSER WHERE USER_EMAIL=? ");
			stmt = conn.prepareStatement(sb.toString());
			stmt.setString(1, mail);
			rset = stmt.executeQuery();

			ResultSetMetaData rsmd = rset.getMetaData();
			int columnLength = rsmd.getColumnCount();

			while (rset.next()) {
				System.out.println("***begin " + rset.getRow() + "***");
				for (int i = 1; i <= columnLength; i++) {
					System.out.println(rset.getString(i));
				}
				System.out.println("***end***\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
		return null;
	}

	private String INSERTSQL = "INSERT INTO SUSER(USER_NAME,USER_EMAIL,USER_LAST_NAME,USER_FIRST_NAME,USER_PASSWD,"
			+ "USER_MOBILE,USER_TEL,USER_TEL_EXT)" + " values (?, ?, ?, ?, ?, ?, ?, ?)";

	public void insertUser(MemberBean bean) {
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(INSERTSQL)) {
			stmt.setString(1, bean.getUserEmail());
			stmt.setString(2, bean.getUserEmail());
			stmt.setString(3, bean.getuserLastName());
			stmt.setString(4, bean.getUserFirstName());
			stmt.setString(5, bean.getUserPasswd());
			stmt.setString(6, bean.getUserMobile());
			stmt.setString(7, bean.getUserTel());
			stmt.setString(8, bean.getUserTelExt());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}