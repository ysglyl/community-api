package com.bzdnet.community.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.bzdnet.community.holder.SessionContextHolder;
import com.bzdnet.community.model.UserModel;
import com.bzdnet.community.util.ID;
import org.apache.ibatis.reflection.MetaObject;

public class MyBatisPlusFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        UserModel user = SessionContextHolder.get();
        if (metaObject.hasSetter("rowId")) {
            this.setFieldValByName("rowId", String.valueOf(ID.getId()), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
    }

}
