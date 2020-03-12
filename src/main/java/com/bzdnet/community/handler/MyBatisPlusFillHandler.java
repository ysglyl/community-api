package com.bzdnet.community.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.bzdnet.community.holder.SessionContextHolder;
import com.bzdnet.community.model.UserModel;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

public class MyBatisPlusFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasSetter("createById")) {
            UserModel user = SessionContextHolder.get();
            this.setFieldValByName("createById", user.getRowId(), metaObject);
            this.setFieldValByName("createByName", user.getNickName(), metaObject);
            this.setFieldValByName("createTime", new Date(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasSetter("updateById")) {
            UserModel user = SessionContextHolder.get();
            this.setFieldValByName("updateById", user.getRowId(), metaObject);
            this.setFieldValByName("updateByName", user.getNickName(), metaObject);
            this.setFieldValByName("updateTime", new Date(), metaObject);
        }
    }

}
