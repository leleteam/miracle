package com.dream.common.dto.result;

public enum ErrorMessage {
    ;

    public int code;
    public String error;

    ErrorMessage(){}

    ErrorMessage(int code, String error) {
        this.code = code;
        this.error = error;
    }
}
