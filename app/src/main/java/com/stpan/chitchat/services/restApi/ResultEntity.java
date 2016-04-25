package com.stpan.chitchat.services.restApi;

import java.io.Serializable;

/**
 * 功能：
 * 创建时间:2016/1/31 15:04
 * 作者:pst
 */
public class ResultEntity<T> implements Serializable {
    private String code = null;
    private String message = null;
    private T result = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
