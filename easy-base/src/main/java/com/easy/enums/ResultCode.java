package com.easy.enums;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/4 18:39
 * @Version: 1.0
 */
public enum ResultCode {

    UNKNOWN(-9,"未知状态"),
    SYS_ERR(-2,"系统异常"),
    SYS_EXP(-1,"服务异常"),
    SUCCESS(0,"请求成功"),
    PARAM_EXP(1, "参数异常"),
    fail(2, "请求失败"),
    ;

    private int code;

    private String value;

    ResultCode(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode(){
        return code;
    }

    public String getValue(){
        return value;
    }

    public static String getValueByCode(int code){
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.code == code) {
                return resultCode.getValue();
            }
        }
        return UNKNOWN.getValue();
    }

}
