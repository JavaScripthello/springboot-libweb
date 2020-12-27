package com.example.libweb.api.model.constants;

import lombok.Data;

@Data
public class   ResultDTO {


    private  int code;

    private  String msg;
    private  String system;

    private  Object obj;

    ResultDTO(int code, String msg, String system, Object obj) {
        this.code = code;
        this.msg = msg;
        this.system = system;
        this.obj = obj;
    }

    public ResultDTO(int code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public ResultDTO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ResultDTO(int code, Object obj) {
        this.code = code;
        this.obj = obj;
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

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
