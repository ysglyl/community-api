package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/18 13:12
 **/
@Data
@Entity(name = "t_statistics")
@TableName("t_statistics")
public class StatisticsModel extends BaseModel {

    @TableField("title_")
    @Column(name = "title_")
    private String title;

    @TableField("content_")
    @Column(name = "content_")
    private String content;

    @TableField("activity_id_")
    @Column(name = "activity_id_")
    private Long activityId;

}
