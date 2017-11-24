package com.mall.core.domain.mapper.product;

import com.mall.core.domain.entity.product.CategoryTree;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryTreeMapper {

    int insert(CategoryTree record);

    CategoryTree selectByPrimaryKey(Long id);

    int update(CategoryTree record);
}