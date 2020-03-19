package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author yu.shigui@rongzer.com
 * @date 2020/3/18 13:12
 **/
@Data
@Entity(name = "t_notice")
@TableName("t_notice")
public class NoticeModel extends BaseModel {

    @TableField("title_")
    @Column(name = "title_")
    private String title;

    @TableField("content_")
    @Column(name = "content_")
    private String content;

    @TableField("effective_date_")
    @Column(name = "effective_date_")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date effectiveDate;

    @TableField("activity_id_")
    @Column(name = "activity_id_")
    private Long activityId;


}
