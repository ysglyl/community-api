package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

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
    @TableField("country_")
    @Column(name = "country_")
    private String country;
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
    @TableField("member_count_")
    @Column(name = "member_count_")
    private String memberCount;
    @TableField("cert_member_count_")
    @Column(name = "cert_member_count_")
    private String certMemberCount;

}
