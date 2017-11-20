package com.mall.core.domain.mapper.product;

import com.mall.core.domain.entity.product.AttributeName;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AttributeNameMapper {

    int insert(AttributeName record);

    int update(AttributeName record);

    List<AttributeName> findByParams(Map<String,Object> params);

    List<AttributeName> findByParams(Map<String,Object> params, RowBounds rowBounds);
}