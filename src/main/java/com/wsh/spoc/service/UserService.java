package com.wsh.spoc.service;

import com.wsh.spoc.entity.Bo.LoginBo;
import com.wsh.spoc.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wsh.spoc.entity.Vo.UserVo;
import java.util.List;

/**
* @author wjh
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2022-04-22 15:45:14
*/
public interface UserService extends IService<User> {

    /**
     * 登录
     *
     * @param info
     * @return
     */
    boolean login(LoginBo info);

    /**
     * 判断用户表中是否存在该用户
     *
     * @param username 用户名
     * @return true 存在 false 不存在
     */
    boolean isExist(String username);

    /**
     * 获取所有学生
     *
     * @return
     */
    List<UserVo> listStudent();
}
