package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Data
@Entity(name = "t_product")
@TableName("t_product")
public class ProductModel extends BaseModel {

    @TableField("name_")
    @Column(name = "name_")
    private String name;

    @TableField("category_")
    @Column(name = "category_")
    private String category_;

    @TableField("specs_")
    @Column(name = "specs_", length = 2048)
    private String specs;

}
