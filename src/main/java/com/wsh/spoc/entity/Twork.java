package com.wsh.spoc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 作业表
 * @TableName twork
 */
@TableName(value ="twork")
@Data
public class Twork implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 作业名
     */
    private String name;

    /**
     * 作业描述
     */
    private String desc;

    /**
     * 作业url
     */
    private String url;

    /**
     * 截止时间
     */
    private String deadline;

    /**
     * 选择的课程id
     */
    private String classroomId;

    /**
     * 选择的用户id
     */
    private String userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除  1已删除  0未删除
     */
    private String delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}