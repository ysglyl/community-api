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
@Entity(name = "t_purchase_product")
@TableName("t_purchase_product")
public class PurchaseProductModel extends BaseModel {

    @TableField("purchase_id_")
    @Column(name = "purchase_id_")
    private Long purchaseId;

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
