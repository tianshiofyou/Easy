package easy.common.controller;

import com.alibaba.fastjson.JSON;
import easy.context.EasyContext;
import easy.context.Platform;
import easy.utils.EasyException;
import easy.utils.Result;
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
    EasyContext easyContext;

    @Autowired
    Platform platform;

    /**
     * 捕获处理异常：RestServiceException
     */
    @ResponseBody
    @ExceptionHandler(value = EasyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected Result restExceptionHandler(EasyException ex){
        log.warn("exception", ex);
        Result result = Result.EXCPTION;
        result.setData(ex);
        log.warn("response:{}", JSON.toJSONString(result));
        return result;
    }
}
