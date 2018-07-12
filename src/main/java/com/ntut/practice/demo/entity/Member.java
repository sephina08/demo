package com.ntut.practice.demo.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
	private BigDecimal sid;
	private String name;
	/**
	 * 0:girl 1:boy
	 */
	private String gender;
	private String email;
	private String address;
	private String phone;
	private String birthday;
	private String workingday;
	private String cityId;
	private String zoneId;
	private String interests;
	

}
