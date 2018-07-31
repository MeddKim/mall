package com.mall.product.interfaces.service.impl;

import com.mall.core.domain.entity.product.CategoryTree;
import com.mall.core.domain.mapper.product.CategoryTreeMapper;
import com.mall.product.interfaces.service.CategoryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryTreeServiceImpl implements CategoryTreeService {

    @Autowired
    private CategoryTreeMapper categoryTreeMapper;

    @Override
    public int createCategoryTree(CategoryTree categoryTree) {
        return categoryTreeMapper.insert(categoryTree);
    }
}
