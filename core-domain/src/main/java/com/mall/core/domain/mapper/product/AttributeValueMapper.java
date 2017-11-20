package com.mall.core.domain.mapper.product;

import com.mall.core.domain.entity.product.AttributeValue;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValueMapper {

    int insert(AttributeValue record);

    int update(AttributeValue record);
}