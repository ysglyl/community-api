package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 活动实体，分为供应活动和需求活动
 *
 * @author yu.shigui@rongzer.com
 * @date 2020/3/4 13:33
 **/
@Data
@Entity(name = "t_activity")
@TableName("t_activity")
public class ActivityModel extends BaseModel {

    public enum Type {
        ALL, NOTICE, TOPIC, VOTE, STATISTICS, PURCHASE, DEMAND;

        public static Type instance(int type) {
            switch (type) {
                case 1:
                    return NOTICE;
                case 2:
                    return TOPIC;
                case 3:
                    return VOTE;
                case 4:
                    return STATISTICS;
                case 5:
                    return PURCHASE;
                case 6:
                    return DEMAND;
            }
            return ALL;
        }
    }
    //发起人
    @TableField("initiator_")
    @Column(name = "initiator_")
    private Long initiator;
    //当前状态
    @TableField("status_")
    @Column(name = "status_")
    private Integer status;
    //活动类型
    @TableField("type_")
    @Column(name = "type_")
    private Integer type;
    //所属社区
    @TableField("community_id_")
    @Column(name = "community_id_")
    private Long communityId;

    @TableField(exist = false)
    @Transient
    private String communityName;
    @TableField(exist = false)
    @Transient
    private NoticeModel notice;
    @TableField(exist = false)
    @Transient
    private TopicModel topic;
    @TableField(exist = false)
    @Transient
    private VoteModel vote;
    @TableField(exist = false)
    @Transient
    private StatisticsModel statisticsModel;
    @TableField(exist = false)
    @Transient
    private PurchaseModel purchase;
    @TableField(exist = false)
    @Transient
    private DemandModel demand;

}
