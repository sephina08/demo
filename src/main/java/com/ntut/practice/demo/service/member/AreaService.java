package com.ntut.practice.demo.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntut.practice.demo.dao.member.CityDao;
import com.ntut.practice.demo.dao.member.ZoneDao;
import com.ntut.practice.demo.model.member.CityBean;
import com.ntut.practice.demo.model.member.ZoneBean;

@Service
public class AreaService {
	@Autowired
	CityDao cityDao;
	@Autowired
	ZoneDao zoneDao;

	public List<ZoneBean> getZoneByParentId(String parentId) {
		return zoneDao.getZoneByParentId(parentId);
	}

	public List<CityBean> getAllCity() {
		List<CityBean> allCity = cityDao.getAllCity();
		return allCity;

	}

	public List<ZoneBean> getZone() {
		List<ZoneBean> zone = zoneDao.getZone();
		return zone;

	}

	public List<ZoneBean> getZoneParentByZoneOid(String zoneOid) {
		return zoneDao.getZoneByParentId(zoneOid);

	}
}
