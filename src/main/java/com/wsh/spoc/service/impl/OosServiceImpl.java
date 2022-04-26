package com.wsh.spoc.service.impl;

import com.wsh.spoc.entity.dto.VideoDto;
import com.wsh.spoc.service.OosService;
import com.wsh.spoc.utils.OosUtil;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wjh
 * @date 2022/1/4 5:42 PM
 */
@Service
public class OosServiceImpl implements OosService {

    @Resource
    private OosUtil oosUtil;

    @Override
    public String uploadAvatar(MultipartFile file) {
        return oosUtil.upload(file);
    }

    @Override
    public VideoDto uploadVideo(MultipartFile file) {
        return oosUtil.uploadVideo(file);
    }

    @Override
    public Boolean deleteFile(String fileName) {
        return oosUtil.delete(fileName);
    }

    @Override
    public Boolean deleteFileBatch(List<String> fileList) {
        return oosUtil.deleteBatch(fileList);
    }
}
