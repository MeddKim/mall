package com.mall.core.domain.mapper.product;

import com.mall.core.domain.entity.product.AttributeName;

public interface AttributeNameMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AttributeName record);

    int insertSelective(AttributeName record);

    AttributeName selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AttributeName record);

    int updateByPrimaryKey(AttributeName record);
}