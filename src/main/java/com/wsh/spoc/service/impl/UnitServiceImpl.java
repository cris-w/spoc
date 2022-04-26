package com.wsh.spoc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.spoc.entity.Video;
import com.wsh.spoc.entity.Vo.UnitVo;
import com.wsh.spoc.service.UnitService;
import com.wsh.spoc.entity.Unit;
import com.wsh.spoc.mapper.UnitMapper;
import com.wsh.spoc.service.VideoService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author wjh
 * @description 针对表【unit(单元表)】的数据库操作Service实现
 * @createDate 2022-04-22 15:45:14
 */
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit>
        implements UnitService {

    @Resource
    private UnitMapper unitMapper;
    @Resource
    private VideoService videoService;

    @Override
    public List<UnitVo> listUnitAndVideo(Integer classroomId) {
        // 通过小组id 获取所有的单元列表 和 小节列表
        List<Unit> units = unitMapper.selectList(
                new LambdaQueryWrapper<Unit>().eq(Unit::getClassroomId, classroomId)
                        .orderByAsc(Unit::getOrder));
        List<Video> videos = videoService.list(
                new LambdaQueryWrapper<Video>().eq(Video::getClassroomId, classroomId)
                        .orderByAsc(Video::getOrder));

        // 遍历获得树状结构
        ArrayList<UnitVo> list = new ArrayList<>();
        units.forEach(unit -> {
            UnitVo vo = new UnitVo();
            BeanUtils.copyProperties(unit, vo);
            ArrayList<Video> vs = new ArrayList<>();
            videos.forEach(video -> {
                if (video.getUnitId().equals(unit.getId())) {
                    vs.add(video);
                }
            });
            vo.setChildren(vs);
            list.add(vo);
        });
        return list;
    }
}




