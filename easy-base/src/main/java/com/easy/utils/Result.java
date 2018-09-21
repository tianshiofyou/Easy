package com.easy.utils;

import com.easy.enums.ResultCode;
import lombok.Data;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/4 18:33
 * @Version: 1.0
 */
@Data
public class Result {

    public final static Result EXCPTION = new Result();

    private Result() {
    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private int code = ResultCode.SYS_EXP.getCode();

    private String msg = ResultCode.SYS_EXP.getValue();

    private Object data;

}
