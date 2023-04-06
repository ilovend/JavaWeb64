package com.itheima.day04.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    private static final LocalDate now = LocalDate.now();
    @Override
    public void insertFill(MetaObject metaObject) {

        this.strictInsertFill(metaObject, "createTime", LocalDate.class, now);
        this.strictInsertFill(metaObject, "updateTime", LocalDate.class, now);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDate.class, now);
    }
}
