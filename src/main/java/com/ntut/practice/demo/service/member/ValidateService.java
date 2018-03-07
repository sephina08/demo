package com.ntut.practice.demo.service.member;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.springframework.stereotype.Service;

@Service
public class ValidateService {
	// 信箱格式
	public boolean validateMail(String email) {

		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);

		return matcher.matches();

	}
}
