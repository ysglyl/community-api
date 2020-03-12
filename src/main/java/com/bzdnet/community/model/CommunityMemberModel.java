package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 14:12
 **/
@Data
@Entity(name = "t_community_member")
@TableName("t_community_member")
public class CommunityMemberModel extends BaseModel {

    @TableField("community_id_")
    @Column(name = "community_id_")
    private Long communityId;

    @TableField("user_id_")
    @Column(name = "user_id_")
    private Long userId;

    @TableField("flag_cert_")
    @Column(name = "flag_cert_")
    private Integer flagCert;

    @TableField("cert_user_id_")
    @Column(name = "cert_user_id_")
    private Long certUserId;

    @TableField("cert_time_")
    @Column(name = "cert_time_")
    private Date certTime;

}
