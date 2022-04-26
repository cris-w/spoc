package com.wsh.spoc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.spoc.entity.Video;
import com.wsh.spoc.service.VideoService;
import com.wsh.spoc.mapper.VideoMapper;
import org.springframework.stereotype.Service;

/**
* @author wjh
* @description 针对表【video(小节表)】的数据库操作Service实现
* @createDate 2022-04-23 14:39:48
*/
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video>
    implements VideoService{

}




