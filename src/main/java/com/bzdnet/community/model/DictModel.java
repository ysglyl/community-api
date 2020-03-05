package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 13:19
 **/
@Data
@Entity(name = "t_dict")
@TableName("t_dict")
public class DictModel extends BaseModel {

    @TableField("key_")
    @Column(name = "key_",unique = true)
    private String key;
    @TableField("name_")
    @Column(name = "name_")
    private String name;
    @TableField("p_key_")
    @Column(name = "p_key_")
    private String pkey;
    @TableField("type_")
    @Column(name = "type_")
    private String type;

}
