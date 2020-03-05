package com.bzdnet.community.vo;

import lombok.Data;

@Data
public class ResultVO<T> {

    private int code;
    private String msg;
    private T data;

    public ResultVO(int code) {
        this.code = code;
    }

    public ResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
