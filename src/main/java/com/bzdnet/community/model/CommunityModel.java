package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;


/**
 * 社区 数据模型
 *
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 13:33
 **/
@Data
@Entity(name = "t_community")
@TableName("t_community")
public class CommunityModel extends BaseModel {

    @TableField("name_")
    @Column(name = "name_")
    private String name;
    @TableField("avatar_")
    @Column(name = "avatar_")
    private String avatar;
    @TableField("province_")
    @Column(name = "province_")
    private String province;
    @TableField("city_")
    @Column(name = "city_")
    private String city;
    @TableField("county_")
    @Column(name = "county_")
    private String county;
    @TableField("address_")
    @Column(name = "address_")
    private String address;
    @TableField("type_")
    @Column(name = "type_")
    private int type;
    @TableField("desc_")
    @Column(name = "desc_")
    private String description;
    @TableField("member_count_")
    @Column(name = "member_count_")
    private int memberCount;
    @TableField("cert_member_count_")
    @Column(name = "cert_member_count_")
    private int certMemberCount;

    @TableField(exist = false)
    @Transient
    private int certRate;
    @TableField(exist = false)
    @Transient
    private boolean flagMember;

    public int getCertRate() {
        return this.certMemberCount * 100 / this.memberCount;
    }

}
