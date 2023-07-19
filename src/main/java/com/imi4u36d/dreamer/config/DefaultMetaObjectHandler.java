package com.imi4u36d.dreamer.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class DefaultMetaObjectHandler implements MetaObjectHandler {
    private static final String CREATED_AT = "createdAt";
    private static final String UPDATED_AT = "updatedAt";
    private static final String CREATED_BY = "createdBy";
    private static final String UPDATED_BY = "updatedBy";


    @Override
    public void insertFill(MetaObject metaObject) {
        Object createdAt = getFieldValByName(CREATED_AT, metaObject);
        Object updatedAt = getFieldValByName(UPDATED_AT, metaObject);
        Object createdBy = getFieldValByName(CREATED_BY, metaObject);
        Object updatedBy = getFieldValByName(UPDATED_BY, metaObject);
        if (createdAt == null) {
            setFieldValByName(CREATED_AT, LocalDateTime.now(), metaObject);
        }
        if (updatedAt == null) {
            setFieldValByName(UPDATED_AT, LocalDateTime.now(), metaObject);
        }
//        if (createdBy == null) {
//            setFieldValByName(CREATED_BY, (UserContext.getLoginUser() == null || UserContext.getLoginUser().getId() == null) ? 1L : UserContext.getLoginUser().getId(), metaObject);
//        }
//        if (updatedBy == null) {
//            setFieldValByName(UPDATED_BY, (UserContext.getLoginUser() == null || UserContext.getLoginUser().getId() == null) ? 1L : UserContext.getLoginUser().getId(), metaObject);
//        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updatedAt = getFieldValByName(UPDATED_AT, metaObject);
        Object updatedBy = getFieldValByName(UPDATED_BY, metaObject);
        if (updatedAt == null) {
            setFieldValByName(UPDATED_AT, LocalDateTime.now(), metaObject);
        }
//        if (updatedBy == null) {
//            setFieldValByName(UPDATED_BY, (UserContext.getLoginUser() == null || UserContext.getLoginUser().getId() == null) ? 1L : UserContext.getLoginUser().getId(), metaObject);
//        }
    }
}
