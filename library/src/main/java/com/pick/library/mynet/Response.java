package com.pick.library.mynet;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2016/12/28.
 */
//写泛型T
public class Response<T> {
    private  int code;
    private String message;
    private  T  data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Response() {
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
