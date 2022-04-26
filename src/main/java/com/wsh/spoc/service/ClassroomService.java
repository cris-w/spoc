package com.wsh.spoc.service;

import com.wsh.spoc.entity.Classroom;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wsh.spoc.entity.Vo.ClassroomVo;
import com.wsh.spoc.entity.Vo.UserVo;
import java.util.List;

/**
* @author wjh
* @description 针对表【classroom(小组表)】的数据库操作Service
* @createDate 2022-04-22 15:45:14
*/
public interface ClassroomService extends IService<Classroom> {

    /**
     * 获取小组列表
     *
     * @param name name
     * @return list
     */
    List<ClassroomVo> listClassroom(String name);

    /**
     * 通过小组id 获取小组成员信息
     *
     * @param classId
     * @return
     */
    List<UserVo> listMember(Integer classId);

    /**
     * 移除小组
     *
     * @param classId
     * @param userId
     * @return
     */
    boolean removeMemberById(Integer classId, Integer userId);

    /**
     * 获取学生列表
     *
     * @return
     */
    List<UserVo> listStudent();

    /**
     * 加入小组
     *
     * @param classId
     * @param userIds
     * @return
     */
    boolean joinClass(Integer classId, List<Integer> userIds);
}
