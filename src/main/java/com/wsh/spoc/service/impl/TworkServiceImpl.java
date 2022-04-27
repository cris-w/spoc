package com.wsh.spoc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.spoc.entity.ClassUser;
import com.wsh.spoc.entity.Twork;
import com.wsh.spoc.mapper.TworkMapper;
import com.wsh.spoc.service.ClassUserService;
import com.wsh.spoc.service.TworkService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author wjh
 * @description 针对表【twork(作业表)】的数据库操作Service实现
 * @createDate 2022-04-22 15:45:14
 */
@Service
public class TworkServiceImpl extends ServiceImpl<TworkMapper, Twork>
        implements TworkService {

    @Resource
    private ClassUserService classUserService;
    @Resource
    private TworkMapper tworkMapper;

    @Override
    public List<Twork> listWorkByUserId(Integer userId) {
        // 通过学生id获取班级id列表
        List<ClassUser> list = classUserService.list(
                new LambdaQueryWrapper<ClassUser>().eq(ClassUser::getUserId, userId));
        List<Integer> classIds = list.stream().map(ClassUser::getClassId)
                .collect(Collectors.toList());
        return tworkMapper.selectWorksByClassIds(classIds);
    }
}




