package com.easy.base.ctrl;

import com.alibaba.fastjson.JSON;
import com.easy.context.EasyContext;
import com.easy.context.Platform;
import com.easy.utils.BizRsp;
import com.easy.utils.EasyException;
import com.easy.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/6 14:14
 * @Version: 1.0
 */
@Controller
@Slf4j
public class BaseController {

    @Autowired
    private EasyContext easyContext;

    @Autowired
    private Platform platform;

    /**
     * 捕获处理异常：RestServiceException
     */
    @ResponseBody
    @ExceptionHandler(value = EasyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected BizRsp restExceptionHandler(EasyException ex){
        log.warn("exception", ex);
        BizRsp result = BizRsp.exception(ex);
        log.warn("response:{}", JSON.toJSONString(result));
        return result;
    }
}
