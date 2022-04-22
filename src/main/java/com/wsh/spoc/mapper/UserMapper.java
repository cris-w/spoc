package com.wsh.spoc.mapper;

import com.wsh.spoc.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author wjh
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2022-04-22 15:45:14
* @Entity generator.domain.User
*/
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过用户名名密码查询 用户
     *
     * @param username username
     * @param password pwd
     * @return user
     */
    User selectByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}




