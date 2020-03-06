package com.bzdnet.community.model;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

@Data
@Entity(name = "t_user")
@TableName("t_user")
public class UserModel extends BaseModel {

    @TableField("open_id_")
    @Column(name = "open_id_", unique = true, nullable = false, updatable = false, length = 64)
    private String openId;
    @TableField("nick_name_")
    @Column(name = "nick_name_")
    private String nickName;
    @TableField("avatar_url_")
    @Column(name = "avatar_url_",length = 512)
    private String avatarUrl;
    @TableField("gender_")
    @Column(name = "gender_")
    private Integer gender;
    @TableField("country_")
    @Column(name = "country_")
    private String country;
    @TableField("province_")
    @Column(name = "province_")
    private String province;
    @TableField("city_")
    @Column(name = "city_")
    private String city;

    @TableField(value = "birthday_",fill = FieldFill.INSERT)
    @Column(name = "birthday_")
    private String birthday;

}
