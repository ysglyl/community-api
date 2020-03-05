package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 14:12
 **/
@Data
@Entity(name = "t_order_product")
@TableName("t_order_product")
public class OrderProductModel extends BaseModel {

    @TableField("order_id_")
    @Column(name = "order_id_")
    private Long orderId;

    @TableField("product_id_")
    @Column(name = "product_id_")
    private Long productId;

    @TableField("num_")
    @Column(name = "num_")
    private Integer num;

    @TableField("remark_")
    @Column(name = "remark_")
    private String remark;

}
