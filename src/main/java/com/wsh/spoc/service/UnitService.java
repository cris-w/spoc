package com.wsh.spoc.service;

import com.wsh.spoc.entity.Unit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wsh.spoc.entity.Vo.UnitVo;
import java.util.List;

/**
* @author wjh
* @description 针对表【unit(单元表)】的数据库操作Service
* @createDate 2022-04-22 15:45:14
*/
public interface UnitService extends IService<Unit> {

    /**
     * 获取单元列表
     *
     * @param classroomId 班级id
     * @return
     */
    List<UnitVo> listUnitAndVideo(Integer classroomId);

}
