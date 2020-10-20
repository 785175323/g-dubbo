package com.kakuiwong.model.dto;

/**
 * @author: gaoyang
 * @Description:
 */
public class GException extends RuntimeException {

    private String msg;

    public GException() {
        super();
    }

    public GException(String message) {
        super(message);
        this.msg = message;
    }

    public String getMsg() {
        return msg;
    }
}
