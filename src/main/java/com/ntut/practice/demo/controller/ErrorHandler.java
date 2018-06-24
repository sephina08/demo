package com.ntut.practice.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 錯誤控制器
 */
@ControllerAdvice
public class ErrorHandler {

    /**
     * ModelAndView 在建構的時候帶入邏輯名稱
     * 並且透過 addObject 的方法將鍵值對放進 request scope
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Map<String, Object> forwardToErrorPage(Exception e) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("errorType", e.getClass().getSimpleName());
        resultMap.put("errorMessage", e.getMessage());
        return resultMap;
    }
}
