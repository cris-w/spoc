package com.wsh.spoc.entity.Vo;

import com.wsh.spoc.entity.Video;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @author wjh
 * @date 2022/4/23 14:42
 */
@Data
public class UnitVo {

    private Integer id;

    /**
     * 节点名
     */
    private String name;


    /**
     * 课程id
     */
    private Integer classroomId;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 小节列表
     */
    private List<Video> children = new ArrayList<>();
}
