package com.wsh.spoc.mapper;

import com.wsh.spoc.entity.Twork;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/**
* @author wjh
* @description 针对表【twork(作业表)】的数据库操作Mapper
* @createDate 2022-04-22 15:45:14
* @Entity generator.domain.Twork
*/
public interface TworkMapper extends BaseMapper<Twork> {

    /**
     * 通过班级ids 查询作业
     *
     * @param classIds
     * @return
     */
    List<Twork> selectWorksByClassIds(List<Integer> classIds);
}




