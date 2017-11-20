package com.mall.product.interfaces.service;

import com.mall.core.domain.entity.product.AttributeName;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * Created by Meddkim on 2017/11/18.
 */
public interface AttributeService {

    int craeteAttributeName(AttributeName attributeName);

    List<AttributeName> findAttributeNameByParams(Map<String,Object> paramsMap, RowBounds rowBounds);

    default List<AttributeName> findAttributeNameByParams(Map<String,Object> paramsMap){
        return findAttributeNameByParams(paramsMap,null);
    }

}
