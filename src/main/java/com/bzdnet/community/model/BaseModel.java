package com.bzdnet.community.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseModel {

    @TableId(value = "row_id_", type = IdType.INPUT)
    @Id
    @Column(name = "row_id_",length = 20)
    protected Long rowId;


}
