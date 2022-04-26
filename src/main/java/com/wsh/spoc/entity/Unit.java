package com.wsh.spoc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 单元表
 * @TableName unit
 */
@TableName(value ="unit")
@Data
public class Unit implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
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
    @TableField("`order`")
    private Integer order;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}