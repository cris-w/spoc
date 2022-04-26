package com.wsh.spoc.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wsh.spoc.entity.Bo.LoginBo;
import com.wsh.spoc.entity.User;
import com.wsh.spoc.service.UserService;
import com.wsh.spoc.utils.R;
import io.swagger.annotations.Api;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    /**
     * 创建用户(管理员端)
     *
     * @param user user
     * @return ok
     */
    @PostMapping("/save")
    public R<Void> save(@RequestBody User user) {
        if(userService.isExist(user.getUsername())) {
            return R.error("用户名已存在");
        }
        userService.save(user);
        return R.success("创建成功");
    }

    /**
     * 通过id删除用户
     *
     * @param id id
     * @return ok
     */
    @GetMapping("/delete/{id}")
    public R<Void> delete(@PathVariable Long id) {
        userService.removeById(id);
        return R.success("删除成功");
    }

    /**
     * 批量删除
     *
     * @param ids ids
     * @return ok
     */
    @PostMapping("/delBatch")
    public R<Void> delBatch(@RequestBody List<Integer> ids) {
        userService.removeByIds(ids);
        return R.success("删除成功");
    }

    /**
     * 通过id获取用户信息
     *
     * @param id id
     * @return user
     */
    @GetMapping("/getById/{id}")
    public R<User> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return R.success(user);
    }

    /**
     * 查询所有用户信息
     *
     * @return users
     */
    @GetMapping("/list")
    public R<List<User>> list(String username) {
        List<User> users = userService.list(
                new LambdaQueryWrapper<User>().like(StrUtil.isNotBlank(username),
                        User::getUsername, username));
        return R.success(users);
    }

    /**
     * 通过id修改用户信息
     *
     * @param users users
     * @return user
     */
    @PostMapping("/update")
    public R<Void> update(@RequestBody User users) {
        String oldName = userService.getById(users.getId()).getUsername();
        if (!oldName.equals(users.getUsername()) && userService.isExist(users.getUsername())) {
            return R.error("用户名已存在");
        }
        userService.updateById(users);
        return R.success("修改成功");
    }

}
