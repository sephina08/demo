package com.ntut.practice.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 錯誤控制器
 */
@ControllerAdvice
public class ErrorHandler {

    /**
     * 從 src/main/resources/application.yml 取值, ${} 為 SPEL 表達式。
     * 大部分情境下配合 @Value 比較多
     */
    @Value("${project.page.error}")
    private String ERROR_PAGE;

    /**
     * ModelAndView 在建構的時候帶入邏輯名稱
     * 並且透過 addObject 的方法將鍵值對放進 request scope
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView forwardToErrorPage(Exception e) {
        ModelAndView rs = new ModelAndView(ERROR_PAGE);
        rs.addObject("errorType", e.getClass().getSimpleName());
        rs.addObject("errorMessage", e.getMessage());
        return rs;
    }
}
