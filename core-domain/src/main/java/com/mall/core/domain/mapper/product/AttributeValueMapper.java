package com.mall.core.domain.mapper.product;

import com.mall.core.domain.entity.product.AttributeValue;

public interface AttributeValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AttributeValue record);

    int insertSelective(AttributeValue record);

    AttributeValue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AttributeValue record);

    int updateByPrimaryKey(AttributeValue record);
}