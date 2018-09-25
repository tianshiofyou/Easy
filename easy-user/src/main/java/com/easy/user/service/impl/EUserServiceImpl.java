package com.easy.user.service.impl;

import com.easy.user.entity.EUser;
import com.easy.user.mapper.EUserMapper;
import com.easy.user.service.IEUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表(注册、登录信息) 服务实现类
 * </p>
 *
 * @author jp
 * @since 2018-09-25
 */
@Service
public class EUserServiceImpl extends ServiceImpl<EUserMapper, EUser> implements IEUserService {

}
