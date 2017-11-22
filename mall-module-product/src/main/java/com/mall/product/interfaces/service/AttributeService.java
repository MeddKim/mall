package com.mall.product.interfaces.service;

import com.mall.core.domain.entity.product.AttributeName;
import com.mall.core.domain.entity.product.AttributeValue;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * Created by Meddkim on 2017/11/18.
 */
public interface AttributeService {

    int createAttributeName(AttributeName attributeName);

    List<AttributeName> findAttNameByParams(Map<String,Object> paramsMap, RowBounds rowBounds);

    default List<AttributeName> findAttributeNameByParams(Map<String,Object> paramsMap){
        return findAttNameByParams(paramsMap,null);
    }

    int createAttributeValue(AttributeValue attributeValue);

    List<AttributeValue> findAttValueByParams(Map<String,Object> paramsMap);

}
