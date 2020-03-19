package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 13:57
 **/
@Data
@Entity(name = "t_purchase")
@TableName("t_purchase")
public class PurchaseModel extends BaseModel {

    @TableField("activity_id_")
    @Column(name = "activity_id_")
    private Long activityId;

    @TableField("name")
    @Column(name = "name")
    private Long name;

    @TableField("permit_deadline_")
    @Column(name = "permit_deadline_")
    private Long permitDeadline;

    @TableField("delivery_time_")
    @Column(name = "delivery_time_")
    private Long deliveryTime;

    @TableField("remark_")
    @Column(name = "remark_")
    private String remark;

    @TableField(exist = false)
    @Transient
    private List<PurchaseProductModel> products;

}
