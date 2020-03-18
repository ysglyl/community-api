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
@Entity(name = "t_topic_discussion")
@TableName("t_topic_discussion")
public class TopicDiscussionModel extends BaseModel {

    @TableField("content_")
    @Column(name = "content_")
    private String content;

    @TableField("topic_id_")
    @Column(name = "topic_id_")
    private Long topicId;

    @TableField("user_id_")
    @Column(name = "user_id_")
    private Long userId;

}
