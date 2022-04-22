package com.wsh.spoc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.spoc.entity.Classroom;
import com.wsh.spoc.mapper.ClassroomMapper;
import com.wsh.spoc.service.ClassroomService;
import org.springframework.stereotype.Service;

/**
* @author wjh
* @description 针对表【classroom(小组表)】的数据库操作Service实现
* @createDate 2022-04-22 15:45:14
*/
@Service
public class ClassroomServiceImpl extends ServiceImpl<ClassroomMapper, Classroom>
    implements ClassroomService {

}




