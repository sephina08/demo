package com.ntut.practice.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(Exception.class)//同時導頁和帶參數
	public ModelAndView forwardToErrorPage(Exception e){
		ModelAndView rs = new ModelAndView("error");
		rs.addObject("errorType", e.getClass().getSimpleName());
		rs.addObject("errorMessage", e.getMessage());
		return rs;
	}
}
