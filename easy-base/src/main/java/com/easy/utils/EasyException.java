package com.easy.utils;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/6 15:08
 * @Version: 1.0
 */
public class EasyException extends Exception {

    private String bizCode;

    private String bizMsg;

    public EasyException(String message){
        super(message);
    }

    public EasyException(String message, Throwable ex){
        super(message, ex);
    }

    public EasyException(String bizCode, String bizMsg, String message){
        super(message);
        this.bizCode = bizCode;
        this.bizMsg =bizMsg;
    }

    public EasyException(String bizCode, String bizMsg, String message, Throwable ex){
        super(message, ex);
        this.bizCode = bizCode;
        this.bizMsg =bizMsg;
    }

    public String getBizMsg() {
        return bizMsg;
    }

    public String getBizCode() {
        return bizCode;
    }

    @Override
    public String toString() {
        return bizCode + "\r\n" + bizMsg + "\r\n" + super.toString();
    }
}
