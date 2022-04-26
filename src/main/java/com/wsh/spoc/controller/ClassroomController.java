package com.wsh.spoc.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wsh.spoc.entity.Classroom;
import com.wsh.spoc.entity.User;
import com.wsh.spoc.entity.Vo.ClassroomVo;
import com.wsh.spoc.entity.Vo.UserVo;
import com.wsh.spoc.service.ClassroomService;
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
 * @date 2022/4/22 21:48
 */
@Api(tags = "小组管理")
@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Resource
    private ClassroomService classroomService;
    @Resource
    private UserService userService;

    /**
     * 获取小组列表
     *
     * @param name 名称
     * @return list
     */
    @GetMapping("/list")
    public R<List<ClassroomVo>> list(String name) {
        List<ClassroomVo> list = classroomService.listClassroom(name);
        return R.success(list);
    }

    /**
     * 老师获取自己的小组列表
     *
     * @param teacherId 老师id
     * @return list
     */
    @GetMapping("/listByTeacherId/{teacherId}")
    public R<List<Classroom>> listByTeacherId(@PathVariable Integer teacherId) {
        List<Classroom> list = classroomService.list(
                new LambdaQueryWrapper<Classroom>().eq(Classroom::getTeacherId, teacherId));
        return R.success(list);
    }

    /**
     * 获取老师列表
     *
     * @return
     */
    @GetMapping("/getTeacherList")
    public R<List<User>> getTeacherList() {
        List<User> teacher = userService.list(
                new LambdaQueryWrapper<User>().eq(User::getRole, "teacher"));
        return R.success(teacher);
    }

    /**
     * 创建小组
     *
     * @param classroom classroom
     * @return ok
     */
    @PostMapping("/save")
    public R<Void> save(@RequestBody Classroom classroom) {
        classroomService.save(classroom);
        return R.success("创建成功");
    }

    /**
     * 删除小组
     *
     * @param id id
     * @return ok
     */
    @GetMapping("/removeById/{id}")
    public R<Void> removeById(@PathVariable Integer id) {
        classroomService.removeById(id);
        return R.success("删除成功");
    }

    /**
     * 通过id获取小组信息
     *
     * @param id id
     * @return c
     */
    @GetMapping("/getById/{id}")
    public R<Classroom> getById(@PathVariable Integer id) {
        Classroom classroom = classroomService.getById(id);
        return R.success(classroom);
    }

    /**
     * 修改小组信息
     *
     * @param classroom
     * @return
     */
    @PostMapping("/update")
    public R<Void> update(@RequestBody Classroom classroom) {
        classroomService.updateById(classroom);
        return R.success("修改成功");
    }

    /**
     * 通过小组id 获取小组成员
     *
     * @param classId
     * @return
     */
    @GetMapping("/listMemberByClassId/{classId}")
    public R<List<UserVo>> listMemberByClassId(@PathVariable Integer classId) {
        List<UserVo> list = classroomService.listMember(classId);
        return R.success(list);
    }

    /**
     * 移除小组
     *
     * @param classId
     * @param userId
     * @return
     */
    @GetMapping("/removeMemberById/{classId}/{userId}")
    public R<Void> removeMemberById(@PathVariable Integer classId, @PathVariable Integer userId) {
        classroomService.removeMemberById(classId, userId);
        return R.success("移除成功");
    }

    /**
     * 获取所有的学生
     *
     * @return
     */
    @GetMapping("/listStudent")
    public R<List<UserVo>> listStudent() {
        List<UserVo> list = classroomService.listStudent();
        return R.success(list);
    }

    /**
     * 将学生加入小组
     *
     * @param classId
     * @param userIds
     * @return
     */
    @PostMapping("/joinClass/{classId}")
    public R<Void> joinClass(@PathVariable Integer classId, @RequestBody List<Integer> userIds) {
        classroomService.joinClass(classId, userIds);
        return R.success("添加成功");
    }
}
