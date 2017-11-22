package com.mall.core.domain.mapper.product;

import com.mall.core.domain.entity.product.AttributeValue;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AttributeValueMapper {

    int insert(AttributeValue record);

    int update(AttributeValue record);

    List<AttributeValue> findByParams(Map<String,Object> paramsMap);
}