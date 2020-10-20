package com.kakuiwong.model.dto;


import java.io.Serializable;

/**
 * @author: gaoyang
 * @Description:
 */
public class ResultDTO<T> implements Serializable {
    //自定义状态码
    private Integer status;
    //响应提示信息
    private String message;
    //响应数据
    private T result;
    //发生异常响应信息
    private String exceptionMessage;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        if (!isSuccess()) {
            throw new GException(this.exceptionMessage);
        }
        return result;
    }

    public boolean isSuccess() {
        return ResultCodeEnum.SUCCESS.getCode().intValue() == this.getStatus();
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public ResultDTO() {
    }

    public ResultDTO(Integer code, String msg) {
        this.status = code;
        this.message = msg;
    }

    public ResultDTO(Integer code, String msg, T data) {
        this.status = code;
        this.message = msg;
        this.result = data;
    }

    public ResultDTO(Integer code, String msg, String exceptionMessage, T data) {
        this.status = code;
        this.message = msg;
        this.result = data;
        this.exceptionMessage = exceptionMessage;
    }

    public static ResultDTO success() {
        return success(null);
    }

    public static ResultDTO success(Object obj) {
        return new ResultDTO(ResultCodeEnum.SUCCESS.getCode(), "success", obj);
    }

    public static ResultDTO success(String msg, Object obj) {
        return new ResultDTO(ResultCodeEnum.SUCCESS.getCode(), msg, obj);
    }

    public static ResultDTO failed(Throwable ex) {
        return new ResultDTO(ResultCodeEnum.FAIL.getCode(), ex.toString());
    }

    public static ResultDTO exception(Throwable ex) {
        return new ResultDTO(ResultCodeEnum.EXCEPTION.getCode(), null, null, ex.getMessage());
    }

    public static ResultDTO failed(String msg) {
        return new ResultDTO(ResultCodeEnum.FAIL.getCode(), msg);
    }

    public static ResultDTO failed(Integer code, String msg, Object object) {
        return new ResultDTO(code, msg, object);
    }

    public static ResultDTO failed(Integer code, String msg) {
        return new ResultDTO(code, msg);
    }

    @Override
    public String toString() {
        return "XResult{" +
                "code=" + status +
                ", msg='" + message + '\'' +
                ", data=" + result +
                '}';
    }
}
