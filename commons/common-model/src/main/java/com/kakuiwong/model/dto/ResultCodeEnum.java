package com.kakuiwong.model.dto;

/**
 * @author: gaoyang
 * @Description:
 */
public enum ResultCodeEnum {
    SUCCESS(1, "成功"),
    FAIL(0, "失败"),
    EXCEPTION(-1, "发生异常");

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
