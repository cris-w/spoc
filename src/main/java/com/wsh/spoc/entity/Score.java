package com.wsh.spoc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 成绩表
 * @author wjh
 * @TableName score
 */
@TableName(value ="score")
@Data
public class Score implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 作业url
     */
    private String url;

    /**
     * 作业源文件名
     */
    private String originalName;

    /**
     * 属于的课程id
     */
    private Integer tworkId;

    /**
     * 属于的作业id
     */
    private Integer classroomId;

    /**
     * 分数
     */
    private Integer grade;

    /**
     * 评语
     */
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}