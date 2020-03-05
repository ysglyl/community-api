package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * 活动实体，分为供应活动和需求活动
 *
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 13:33
 **/
@Data
@Entity(name = "t_activity")
@TableName("t_activity")
public class ActivityModel extends BaseModel {

    @TableField("name_")
    @Column(name = "name_")
    private String name;
    @TableField("permit_deadline_")
    @Column(name = "permit_deadline_")
    private Date permitDeadline;
    @TableField("start_time_")
    @Column(name = "start_time_")
    private Date startTime;
    @TableField("end_time_")
    @Column(name = "end_time_")
    private Date endTime;
    @TableField("initiator_")
    @Column(name = "initiator_")
    private Long initiator;
    @TableField("status_")
    @Column(name = "status_")
    private Integer status;
    @TableField("type_")
    @Column(name = "type_")
    private Integer type;
    @TableField("remark_")
    @Column(name = "remark_")
    private String remark;

    @TableField("community_id_")
    @Column(name = "community_id_")
    private String communityId;

}
