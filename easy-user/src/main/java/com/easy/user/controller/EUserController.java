package com.easy.user.controller;


import com.easy.enums.ErrorCode;
import com.easy.user.entity.EUser;
import com.easy.user.service.IEUserService;
import com.easy.utils.BizException;
import com.easy.utils.BizRsp;
import com.easy.utils.Result;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.easy.base.ctrl.BaseController;

import java.util.Objects;

/**
 * <p>
 * 用户表(注册、登录信息) 前端控制器
 * </p>
 *
 * @author jp
 * @since 2018-09-25
 */
@RestController
@RequestMapping("/user/eUser")
public class EUserController extends BaseController {

    @Autowired
    private IEUserService userService;

    @RequestMapping("/{id}")
    public BizRsp getUser(@PathVariable Long id) throws BizException {
        if (Objects.isNull(id)) {
            throw new  BizException(ErrorCode.SYSTEM_ERROR);
        } else {
            EUser user = userService.getById(id);
            return BizRsp.SUCCESS(user);
        }
    }

    public String welcome(){
        return "welcome";
    }

}
