package com.bzdnet.community.model;


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
    @Column(name = "avatar_url_")
    private Integer avatarUrl;
    @TableField("gender_")
    @Column(name = "gender_")
    private Integer gender;
    @TableField("union_id_")
    @Column(name = "union_id_")
    private String unionId;

    @TableField("birthday_")
    @Column(name = "birthday_")
    private String birthday;

}
