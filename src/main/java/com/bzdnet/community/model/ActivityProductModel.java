package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 13:57
 **/
@Data
@Entity(name = "t_activity_product")
@TableName("t_activity_product")
public class ActivityProductModel extends BaseModel {

    @TableField("activity_id_")
    @Column(name = "activity_id_")
    private Long activityId;

    @TableField("product_id_")
    @Column(name = "product_id_")
    private Long productId;

    @TableField("price_")
    @Column(name = "price_")
    private double price;

    @TableField("unit_")
    @Column(name = "unit_")
    private String unit;

    @TableField("remark_")
    @Column(name = "remark_")
    private String remark;

}
