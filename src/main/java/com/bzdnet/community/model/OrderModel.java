package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity(name = "t_order")
@TableName("t_order")
public class OrderModel extends BaseModel {

    @TableField("owner_")
    @Column(name = "owner_")
    private String owner;
    @TableField("create_time_")
    @Column(name = "create_time_")
    private Date createTime;
    @TableField("activity_id_")
    @Column(name = "activity_id_")
    private Date activityId;

}
