package com.wsh.spoc.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wsh.spoc.entity.Bo.LoginBo;
import com.wsh.spoc.entity.User;
import com.wsh.spoc.service.UserService;
import com.wsh.spoc.utils.R;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjh
 * @date 2022/4/22 15:54
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 登录
     *
     * @param info
     * @return
     */
    @PostMapping("/login")
    public R login(@RequestBody LoginBo info) {
        boolean is = userService.login(info);
        if (is) {
            return R.success("登录成功", info.getUsername());
        }
        return R.error("用户名密码错误", null);
    }

    /**
     * 获取用户信息
     *
     * @param token username
     * @return user
     */
    @GetMapping("/userInfo")
    public R<User> userInfo(String token) {
        User user = userService.getOne(
                new LambdaQueryWrapper<User>().eq(User::getUsername, token));
        return R.success(user);
    }

}
