package com.easy.utils;

import com.easy.enums.ErrorCode;
import lombok.Builder;
import lombok.Data;

@Data
public class BizException  extends Exception {
    private static final long serialVersionUID = -1170501462599127698L;

    final private int errCode;

    final private String errMsg;

    private String apiErrMsg;

    public BizException(ErrorCode errCode) {
        super(errCode.getMessage());
        this.errCode = errCode.getCode();
        this.errMsg = errCode.getMessage();
    }

    public BizException(int code,String errMsg) {
        super(errMsg);
        this.errCode = code;
        this.errMsg = errMsg;
    }

    public BizException(ErrorCode errCode,String apiErrMsg) {
        super(apiErrMsg);
        this.errCode = errCode.getCode();
        this.errMsg = errCode.getMessage();
        this.apiErrMsg = apiErrMsg;
    }
}
