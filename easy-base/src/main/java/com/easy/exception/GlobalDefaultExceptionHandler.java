package com.easy.exception;

import com.easy.utils.BizException;
import com.easy.utils.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public Result resolveBizException(BizException e){
        return Result.error(e.getErrCode(),e.getErrMsg());
    }
}
