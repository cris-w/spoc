package com.wsh.spoc.controller;

import com.wsh.spoc.entity.Classroom;
import com.wsh.spoc.entity.Video;
import com.wsh.spoc.service.VideoService;
import com.wsh.spoc.utils.R;
import io.swagger.annotations.Api;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjh
 * @date 2022/4/23 16:52
 */
@Api(tags = "小节管理")
@RestController
@RequestMapping("/video")
public class VideoController {

    @Resource
    private VideoService videoService;

    /**
     * 创建小节
     *
     * @param video video
     * @return ok
     */
    @PostMapping("/save")
    public R<Void> save(@RequestBody Video video) {
        videoService.save(video);
        return R.success("创建成功");
    }

    /**
     * 删除小节
     *
     * @param id id
     * @return ok
     */
    @GetMapping("/removeById/{id}")
    public R<Void> removeById(@PathVariable Integer id) {
        videoService.removeById(id);
        return R.success("删除成功");
    }

    /**
     * 通过id获取小节信息
     *
     * @param id id
     * @return c
     */
    @GetMapping("/getById/{id}")
    public R<Video> getById(@PathVariable Integer id) {
        Video video = videoService.getById(id);
        return R.success(video);
    }

    /**
     * 修改小节信息
     *
     * @param video vi
     * @return
     */
    @PostMapping("/update")
    public R<Void> update(@RequestBody Video video) {
        videoService.updateById(video);
        return R.success("修改成功");
    }
}
