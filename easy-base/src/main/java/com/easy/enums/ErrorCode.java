package com.easy.enums;

public enum  ErrorCode {
    SYSTEM_ERROR(0, "服务器开小差，请稍后再试");
    private int code;

    private String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
