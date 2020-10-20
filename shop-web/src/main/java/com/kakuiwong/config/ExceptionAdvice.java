package com.kakuiwong.config;

import com.kakuiwong.model.dto.GException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: gaoyang
 * @Description:
 */

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    public Object gException(GException e) {
        return "自定义异常: " + e.getMessage();
    }

    @ExceptionHandler
    public Object exception(Exception e) {
        return "全局异常: " + e.getMessage();
    }
}
