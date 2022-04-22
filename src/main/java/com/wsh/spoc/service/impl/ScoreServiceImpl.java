package com.wsh.spoc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.spoc.entity.Score;
import com.wsh.spoc.mapper.ScoreMapper;
import com.wsh.spoc.service.ScoreService;
import org.springframework.stereotype.Service;

/**
* @author wjh
* @description 针对表【score(成绩表)】的数据库操作Service实现
* @createDate 2022-04-22 15:45:14
*/
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
    implements ScoreService {

}




