package com.wsh.spoc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.spoc.entity.ClassUser;
import com.wsh.spoc.entity.Vo.ClassroomVo;
import com.wsh.spoc.entity.Vo.UserVo;
import com.wsh.spoc.mapper.ClassUserMapper;
import com.wsh.spoc.service.ClassUserService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author wjh
* @description 针对表【class_user(小组用户关联表)】的数据库操作Service实现
* @createDate 2022-04-22 15:45:14
*/
@Service
public class ClassUserServiceImpl extends ServiceImpl<ClassUserMapper, ClassUser>
    implements ClassUserService {

    @Resource
    private ClassUserMapper classUserMapper;

    @Override
    public List<UserVo> listMemberByClassId(Integer classId) {
        return classUserMapper.selectMember(classId);
    }

    @Override
    public List<ClassroomVo> listClassByStudentId(Integer userId) {
        return classUserMapper.selectClassByStudentId(userId);
    }
}




