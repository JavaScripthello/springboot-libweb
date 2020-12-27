package com.example.libweb.api.model.enums;

public enum  HTTPCode {


    SCUCESS(1,"成功"),
    FAIL(-1,"失败"),
    EXCEPTION(500,"系统错误");



    private  int  code;

    private  String msg;

    HTTPCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
