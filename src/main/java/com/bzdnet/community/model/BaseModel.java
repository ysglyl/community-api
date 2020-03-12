package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseModel {

    @TableId(value = "row_id_", type = IdType.ASSIGN_ID)
    @Id
    @Column(name = "row_id_", length = 20)
    protected Long rowId;

    @TableField(value = "create_by_id_", fill = FieldFill.INSERT)
    @Column(name = "create_by_id_")
    protected Long createById;
    @TableField(value = "create_by_name_", fill = FieldFill.INSERT)
    @Column(name = "create_by_name_")
    protected String createByName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @TableField(value = "create_time_", fill = FieldFill.INSERT)
    @Column(name = "create_time_")
    protected Date createTime;

    @TableField(value = "update_by_id_", fill = FieldFill.UPDATE)
    @Column(name = "update_by_id_")
    protected Long updateById;
    @TableField(value = "update_by_name_", fill = FieldFill.UPDATE)
    @Column(name = "update_by_name_")
    protected String updateByName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @TableField(value = "update_time_", fill = FieldFill.UPDATE)
    @Column(name = "update_time_")
    protected Date updateTime;


}
