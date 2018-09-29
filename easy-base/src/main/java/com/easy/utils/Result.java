package com.easy.utils;

import com.easy.enums.ResultCode;
import lombok.Builder;
import lombok.Data;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/4 18:33
 * @Version: 1.0
 */
@Data
@Builder
public class Result {

    public static Result SUCCESS(BizRsp obj){
        ResultCode success = ResultCode.SUCCESS;
        return Result.builder().code(success.getCode()).msg(success.getValue()).data(obj).build();
    }

    public static Result build(ResultCode resultCode, BizRsp obj){
        return Result.builder().code(resultCode.getCode()).msg(resultCode.getValue()).data(obj).build();
    }

    public static Result build(int code, String msg, BizRsp obj){
        return Result.builder().code(code).msg(msg).data(obj).build();
    }

    public static Result ERROR(int code,String msg){
        return Result.builder().code(code).msg(msg).build();
    }

    public final static Result EXCPTION = new Result();

    private Result() {
    }

    public Result(int code, String msg, BizRsp data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private int code = ResultCode.SYS_EXP.getCode();

    private String msg = ResultCode.SYS_EXP.getValue();

    private BizRsp data;

}
