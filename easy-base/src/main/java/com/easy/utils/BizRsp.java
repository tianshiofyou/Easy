package com.easy.utils;

import com.easy.enums.BizCode;
import lombok.Builder;
import lombok.Data;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/27 16:48
 * @Version: 1.0
 */
@Data
@Builder
public class BizRsp {

    public static BizRsp SUCCESS(Object obj){
        BizCode success = BizCode.SUCCESS;
        return BizRsp.builder().bizCode(success.getCode()).bizMsg(success.getValue()).data(obj).build();
    }

    public static BizRsp EXCPTION(Throwable obj){
        BizCode exp = BizCode.BIZ_SYS_EXP;
        return BizRsp.builder().bizCode(exp.getCode()).bizMsg(exp.getValue()).data(obj).build();
    }

    private String bizCode;

    private String bizMsg;

    private Object data;

    public BizRsp(String bizCode, String bizMsg, Object data) {
        this.bizCode = bizCode;
        this.bizMsg = bizMsg;
        this.data = data;
    }
}
