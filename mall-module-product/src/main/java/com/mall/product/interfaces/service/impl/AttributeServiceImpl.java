package com.mall.product.interfaces.service.impl;

import com.mall.core.domain.entity.product.AttributeName;
import com.mall.core.domain.mapper.product.AttributeNameMapper;
import com.mall.core.domain.utils.PaginationUtils;
import com.mall.product.interfaces.service.AttributeService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Meddkim on 2017/11/18.
 */
@Service
@Transactional
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeNameMapper attributeNameMapper;

    @Override
    public int craeteAttributeName(AttributeName attributeName) {
        return attributeNameMapper.insert(attributeName);
    }

    @Override
    public List<AttributeName> findAttributeNameByParams(Map<String, Object> paramsMap, RowBounds rowBounds) {
        return PaginationUtils.isPagination(rowBounds)
                ?attributeNameMapper.findByParams(paramsMap,rowBounds)
                :attributeNameMapper.findByParams(paramsMap);
    }
}
