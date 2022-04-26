package com.wsh.spoc.mapper;

import com.wsh.spoc.entity.ClassUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsh.spoc.entity.Vo.UserVo;
import java.util.List;

/**
* @author wjh
* @description 针对表【class_user(小组用户关联表)】的数据库操作Mapper
* @createDate 2022-04-22 15:45:14
* @Entity generator.domain.ClassUser
*/
public interface ClassUserMapper extends BaseMapper<ClassUser> {

    /**
     * 通过小组id 查询成员列表
     *
     * @param classId
     * @return
     */
    List<UserVo> selectMember(Integer classId);
}




