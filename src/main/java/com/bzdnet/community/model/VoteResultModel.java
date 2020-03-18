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
@Entity(name = "t_vote_result")
@TableName("t_vote_result")
public class VoteResultModel extends BaseModel {

    @TableField("vote_id_")
    @Column(name = "vote_id_")
    private Long voteId;

    @TableField("vote_item_id_")
    @Column(name = "vote_item_id_")
    private Long voteItemId;

    @TableField("user_id_")
    @Column(name = "user_id_")
    private Long userId;

}
