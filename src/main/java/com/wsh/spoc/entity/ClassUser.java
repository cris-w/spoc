package com.wsh.spoc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 小组用户关联表
 * @author wjh
 * @TableName class_user
 */
@TableName(value ="class_user")
@Data
public class ClassUser implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 班级id
     */
    private Integer classId;

    /**
     * 用户id
     */
    private Integer userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}