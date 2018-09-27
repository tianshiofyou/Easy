package com.easy.enums;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/27 16:54
 * @Version: 1.0
 */
public enum BizCode {

    UNKNOWN("xxxx","未知状态"),
    NET_ERR("0xxx","业务服务通讯异常"),
    THIRD_ERR("000x","第三方服务请求异常"),
    SUCCESS("0000","请求成功"),
    BIZ_SYS_EXP("x000","系统状态异常"),
    PARAM_EXP("0001", "参数异常"),
    ;

    private String code;

    private String value;

    BizCode(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode(){
        return code;
    }

    public String getValue(){
        return value;
    }

    public static String getValueByCode(String code){
        for (BizCode bizCode : BizCode.values()) {
            if (bizCode.code.equals(code)) {
                return bizCode.getValue();
            }
        }
        return UNKNOWN.getValue();
    }
}
