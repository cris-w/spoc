package com.wsh.spoc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.spoc.entity.ClassUser;
import com.wsh.spoc.entity.Classroom;
import com.wsh.spoc.entity.Vo.ClassroomVo;
import com.wsh.spoc.entity.Vo.UserVo;
import com.wsh.spoc.mapper.ClassroomMapper;
import com.wsh.spoc.service.ClassUserService;
import com.wsh.spoc.service.ClassroomService;
import com.wsh.spoc.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author wjh
 * @description 针对表【classroom(小组表)】的数据库操作Service实现
 * @createDate 2022-04-22 15:45:14
 */
@Service
public class ClassroomServiceImpl extends ServiceImpl<ClassroomMapper, Classroom>
        implements ClassroomService {

    @Resource
    private ClassroomMapper classroomMapper;
    @Resource
    private ClassUserService classUserService;
    @Resource
    private UserService userService;

    @Override
    public List<ClassroomVo> listClassroom(String name) {
        return classroomMapper.selectClassroomList(name);
    }

    @Override
    public List<UserVo> listMember(Integer classId) {
        return classUserService.listMemberByClassId(classId);
    }

    @Override
    public boolean removeMemberById(Integer classId, Integer userId) {
        return classUserService.remove(
                new LambdaQueryWrapper<ClassUser>().eq(ClassUser::getClassId, classId)
                        .eq(ClassUser::getUserId, userId));
    }

    @Override
    public List<UserVo> listStudent() {
        return userService.listStudent();
    }

    @Override
    public boolean joinClass(Integer classId, List<Integer> userIds) {
        List<ClassUser> list = new ArrayList<>();
        userIds.forEach(id -> {
            ClassUser user = new ClassUser();
            user.setClassId(classId);
            user.setUserId(id);
            list.add(user);
        });
        return classUserService.saveBatch(list, list.size());
    }
}




