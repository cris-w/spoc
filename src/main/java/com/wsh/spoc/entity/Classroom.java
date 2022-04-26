package com.wsh.spoc.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 小组表
 * @author wjh
 * @TableName classroom
 */
@TableName(value ="classroom")
@Data
public class Classroom implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 老师id
     */
    private Integer teacherId;

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

    /**
     * 描述
     */
    @TableField("`desc`")
    private String desc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}