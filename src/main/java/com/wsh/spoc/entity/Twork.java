package com.wsh.spoc.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @TableField("`desc`")
    private String desc;

    /**
     * 作业url
     */
    private String url;

    /**
     * 作业源文件名
     */
    private String originalName;

    /**
     * 截止时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deadline;

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
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}