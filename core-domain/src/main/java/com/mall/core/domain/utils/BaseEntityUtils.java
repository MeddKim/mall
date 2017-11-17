package com.mall.core.domain.utils;

import com.mall.core.domain.entity.BaseEntity;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class BaseEntityUtils {

    public static <T extends BaseEntity> T fillCreateInfo(T baseEntity, HttpServletRequest request){
        baseEntity.setCreateUserip(request.getRemoteAddr());
        baseEntity.setCreateTime(LocalDateTime.now());
        return baseEntity;
    }

    public static <T extends BaseEntity> T fillUpdateInfo(T baseEntity,HttpServletRequest request){
        baseEntity.setUpdateUserip(request.getRemoteAddr());
        baseEntity.setUpdateTime(LocalDateTime.now());
        return baseEntity;
    }

    public static <T extends BaseEntity> T fillCreateUserInfo(T baseEntity,Long userId,String username){
        baseEntity.setCreateUserid(userId);
        baseEntity.setCreateUsername(username);
        return baseEntity;
    }

    public static <T extends BaseEntity> T fillUpdateUserInfo(T baseEntity,Long userId,String username){
        baseEntity.setUpdateUserid(userId);
        baseEntity.setUpdateUsername(username);
        return baseEntity;
    }
}
