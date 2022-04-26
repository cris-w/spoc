package com.wsh.spoc.entity.Vo;

import lombok.Data;

/**
 * @author wjh
 * @date 2022/4/22 22:11
 */
@Data
public class ClassroomVo {

    /**
     * id
     */
    private Integer id;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 老师名
     */
    private String teacherName;

    /**
     * 描述
     */
    private String desc;
}
