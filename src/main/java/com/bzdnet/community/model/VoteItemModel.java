package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/18 13:12
 **/
@Data
@Entity(name = "t_vote_item")
@TableName("t_vote_item")
public class VoteItemModel extends BaseModel {

    @TableField("content_")
    @Column(name = "content_")
    private String content;

    @TableField("num_")
    @Column(name = "num_")
    private int num;

    @TableField("vote_id_")
    @Column(name = "vote_id_")
    private Long voteId;

}
