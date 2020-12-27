package com.example.libweb.api.model.constants;

import lombok.Data;

@Data
public class   ResultDTO {


    private  int code;

    private  String msg;
    private  String system;

    private  Object obj;


    public ResultDTO(int code, String msg, Object obj) {
        this.system="lib";
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public ResultDTO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
