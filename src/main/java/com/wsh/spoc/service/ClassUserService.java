package com.wsh.spoc.service;

import com.wsh.spoc.entity.ClassUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wsh.spoc.entity.Vo.ClassroomVo;
import com.wsh.spoc.entity.Vo.UserVo;
import java.util.List;

/**
* @author wjh
* @description 针对表【class_user(小组用户关联表)】的数据库操作Service
* @createDate 2022-04-22 15:45:14
*/
public interface ClassUserService extends IService<ClassUser> {

    /**
     * 通过小组id 获取成员
     *
     * @param classId
     * @return
     */
    List<UserVo> listMemberByClassId(Integer classId);

    /**
     * 通过学生id查询学生所加入的小组
     *
     * @param userId
     * @return
     */
    List<ClassroomVo> listClassByStudentId(Integer userId);
}
