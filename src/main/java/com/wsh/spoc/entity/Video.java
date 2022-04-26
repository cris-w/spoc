package com.wsh.spoc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 小节表
 * @author wjh
 * @TableName video
 */
@TableName(value ="video")
@Data
public class Video implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 单元id
     */
    private Integer unitId;

    /**
     * 小组id
     */
    private Integer classroomId;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    @TableField("`order`")
    private Integer order;

    /**
     * 视屏地址
     */
    private String url;

    /**
     * 视屏源文件名
     */
    private String originalName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}