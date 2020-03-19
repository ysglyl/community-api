package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/18 13:12
 **/
@Data
@Entity(name = "t_vote")
@TableName("t_vote")
public class VoteModel extends BaseModel {

    @TableField("title_")
    @Column(name = "title_")
    private String title;

    @TableField("deadline_")
    @Column(name = "deadline_")
    private String deadline;

    @TableField("activity_id_")
    @Column(name = "activity_id_")
    private Long activityId;

    @TableField(exist = false)
    @Transient
    private List<VoteItemModel> items;

}
