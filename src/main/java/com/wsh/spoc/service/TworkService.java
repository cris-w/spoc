package com.wsh.spoc.service;

import com.wsh.spoc.entity.Twork;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
* @author wjh
* @description 针对表【twork(作业表)】的数据库操作Service
* @createDate 2022-04-22 15:45:14
*/
public interface TworkService extends IService<Twork> {

    /**
     * 通过学生id查询作业列表
     *
     * @param userId
     * @return
     */
    List<Twork> listWorkByUserId(Integer userId);
}
