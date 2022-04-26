package com.wsh.spoc.mapper;

import com.wsh.spoc.entity.Classroom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsh.spoc.entity.Vo.ClassroomVo;
import java.util.List;

/**
* @author wjh
* @description 针对表【classroom(小组表)】的数据库操作Mapper
* @createDate 2022-04-22 15:45:14
* @Entity generator.domain.Classroom
*/
public interface ClassroomMapper extends BaseMapper<Classroom> {

    /**
     * 获取小组列表
     *
     * @param name name
     * @return list
     */
    List<ClassroomVo> selectClassroomList(String name);
}




