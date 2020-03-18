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
@Entity(name = "t_demand")
@TableName("t_demand")
public class DemandModel extends BaseModel {

    @TableField("content_")
    @Column(name = "content_")
    private String content;

    @TableField("permit_deadline_")
    @Column(name = "permit_deadline_")
    private Long permitDeadline;

    @TableField("service_time_")
    @Column(name = "service_time_")
    private Long serviceTime;

    @TableField("activity_id_")
    @Column(name = "activity_id_")
    private Long activityId;

}
