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
@Entity(name = "t_statistics_result")
@TableName("t_statistics_result")
public class StatisticsResultModel extends BaseModel {

    @TableField("result")
    @Column(name = "result")
    private String result;

    @TableField("statistics_id_")
    @Column(name = "statistics_id_")
    private Long statisticsId;

    @TableField("user_id_")
    @Column(name = "user_id_")
    private Long userId;
}
