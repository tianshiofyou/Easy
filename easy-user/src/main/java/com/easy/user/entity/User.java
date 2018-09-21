package com.easy.user.entity;

import com.easy.base.entity.Model;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model {
    /**
     * 用户名
     */
    private String account;

    /**
     * 手机号码（冗余，仅作登入）
     */
    private String mobile;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 连续登录失败次数
     */
    private Integer passwordContinueFails;

    /**
     * 密码连续错误被锁定
     */
    private Boolean isPasswordLocked;

    /**
     * 密码连续错误被锁定时间
     */
    private Date passwordLockedTime;

    /**
     * 是否允许登录(锁定)
     */
    private Boolean isAllowLogin;

    /**
     * 上次登录时间
     */
    private Date lastLoginTime;

    /**
     * 用户头像路径
     */
    private String photo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 邮箱是否认证
     */
    private Boolean isEmailVerified;
}