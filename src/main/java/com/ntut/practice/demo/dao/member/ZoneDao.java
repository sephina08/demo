package com.ntut.practice.demo.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ntut.practice.demo.dao.BaseDao;
import com.ntut.practice.demo.model.member.ZoneBean;

@Repository
public class ZoneDao extends BaseDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberDao.class);
	private static String GET_ZONE_GROUPS_BY_PARENT_ID = "SELECT * FROM zone WHERE zone_parent = ?";// 列出所有使用者輸入的zone_parent地區
	private static String GET_ZONE_GROUPS_BY_ZONE_ID = "SELECT * FROM zone WHERE zone_parent = (SELECT zone_parent FROM zone WHERE  zone_oid=? )";
//	private static String GET_ZONE_GROUPS_BY_ZONE_ID = "SELECT * FROM ZONE WHERE ZONE_PARENT(SELECT ZONE_PARENT WHERE ZONE_OID=?)";
	
	private static String GET_ZONE = "SELECT * FROM ZONE;";

	public List<ZoneBean> getZoneByParentId(String parentId) {
		List<ZoneBean> result = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(GET_ZONE_GROUPS_BY_PARENT_ID)) {
			stmt.setString(1, parentId);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					ZoneBean zoneBean = new ZoneBean();
					zoneBean.setZoneOid(rs.getInt("zone_oid"));
					zoneBean.setZoneParent(rs.getInt("zone_parent"));
					zoneBean.setZoneName(rs.getString("zone_name"));
					result.add(zoneBean);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return result;
	}

	public List<ZoneBean> getZone() {
		List<ZoneBean> list = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(GET_ZONE);) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ZoneBean zoneBean = new ZoneBean();
				zoneBean.setZoneOid(rs.getInt("zone_oid"));
				zoneBean.setZoneParent(rs.getInt("zone_parent"));
				zoneBean.setZoneName(rs.getString("zone_name"));
				list.add(zoneBean);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return list;
	}

	public List<ZoneBean> getZoneParentByZoneOid(String zone) {
		List<ZoneBean> list = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(GET_ZONE_GROUPS_BY_ZONE_ID)) {
			stmt.setString(1, zone);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					ZoneBean zoneBean = new ZoneBean();
					zoneBean.setZoneOid(rs.getInt("zone_oid"));
					zoneBean.setZoneParent(rs.getInt("zone_parent"));
					zoneBean.setZoneName(rs.getString("zone_name"));
					list.add(zoneBean);
				}
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}

		return list;

	}
}
