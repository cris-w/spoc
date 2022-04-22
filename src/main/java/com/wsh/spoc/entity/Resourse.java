package com.wsh.spoc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 资源表
 * @author wjh
 * @TableName resourse
 */
@TableName(value ="resourse")
@Data
public class Resourse implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 资源名
     */
    private String name;

    /**
     * 
     */
    private String tworkId;

    /**
     * 发布人id
     */
    private Integer userId;

    /**
     * 资源url
     */
    private String url;

    /**
     * 资源描述
     */
    private String desc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}