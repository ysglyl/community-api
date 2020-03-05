package com.bzdnet.community.exception;

import lombok.Data;

@Data
public class UnLoginException extends Exception {

    private int type;

    public UnLoginException() {
    }

    public UnLoginException(int type) {
        this.type = type;
    }
}
