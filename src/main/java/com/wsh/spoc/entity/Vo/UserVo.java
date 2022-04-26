package com.wsh.spoc.entity.Vo;

import lombok.Data;

/**
 * @author wjh
 * @date 2022/4/27 02:17
 */
@Data
public class UserVo {

    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别 1是男 0 是女
     */
    private Integer sex;
}
