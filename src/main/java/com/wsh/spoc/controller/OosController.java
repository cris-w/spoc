package com.wsh.spoc.controller;

import cn.hutool.core.util.StrUtil;
import com.wsh.spoc.entity.dto.VideoDto;
import com.wsh.spoc.service.OosService;
import com.wsh.spoc.utils.R;
import io.swagger.annotations.Api;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wjh
 * @date 2022/1/4 5:43 PM
 */
@Api(tags = "对象存储模块模块")
@RestController
@RequestMapping("/oos/fileOos")
public class OosController {

    @Resource
    private OosService oosService;

    /**
     * 上传头像
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> uploadFile(@RequestPart("file") MultipartFile file) {

        String path = oosService.uploadAvatar(file);

        if (StrUtil.isEmpty(path)) {
            return R.error("上传失败", path);
        }

        return R.success("上传成功", path);
    }

    /**
     * 上传视屏
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadVideo")
    public R<VideoDto> uploadVideo(@RequestPart("file") MultipartFile file) {

        VideoDto video = oosService.uploadVideo(file);

        if (StrUtil.isEmpty(video.getUrl()) && StrUtil.isEmpty(
                video.getOriginalName())) {
            return R.error("上传失败", video);
        }

        return R.success("上传成功", video);
    }

    /**
     * 通过文件名删除文件
     *
     * @param fileName
     * @return
     */
    @GetMapping("/delete/{fileName}")
    public R<String> deleteFile(@PathVariable String fileName) {
        if (oosService.deleteFile(fileName)) {
            return R.success("删除成功", fileName);
        }
        return R.success("删除失败", fileName);
    }

    /**
     * 批量删除文件
     *
     * @param fileList
     * @return
     */
    @PostMapping("/deleteBatch")
    public R<List<String>> deleteBatch(@RequestBody List<String> fileList) {
        if (oosService.deleteFileBatch(fileList)) {
            return R.success("删除成功", fileList);
        }
        return R.success("删除失败", fileList);
    }
}
