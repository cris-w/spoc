package com.wsh.spoc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.spoc.entity.Bo.LoginBo;
import com.wsh.spoc.entity.User;
import com.wsh.spoc.exception.MyException;
import com.wsh.spoc.mapper.UserMapper;
import com.wsh.spoc.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author wjh
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2022-04-22 15:45:14
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean login(LoginBo info) {

        boolean exist = this.isExist(info.getUsername());
        if (!exist) {
            throw new MyException(404, "用户不存在");
        }
        return userMapper.selectByUsernameAndPassword(info.getUsername(),
                info.getPassword()) != null;
    }

    @Override
    public boolean isExist(String username) {
        return userMapper.selectCount(
                new LambdaQueryWrapper<User>().eq(User::getUsername, username)) > 0;
    }
}




