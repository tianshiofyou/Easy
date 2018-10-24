package com.easy.base.dto.log;

import lombok.Data;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/10/19 9:42
 * @Version: 1.0
 */
@Data
public class Log {

    private String message;

    private long userId;

    private String requestIp;

}
