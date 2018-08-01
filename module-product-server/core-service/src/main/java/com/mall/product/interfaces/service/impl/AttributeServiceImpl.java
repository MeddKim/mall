package com.mall.product.interfaces.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.mall.core.domain.entity.Test;
import com.mall.core.domain.entity.product.AttributeName;
import com.mall.core.domain.entity.product.AttributeValue;
import com.mall.core.domain.mapper.TestMapper;
import com.mall.core.domain.mapper.product.AttributeNameMapper;
import com.mall.core.domain.mapper.product.AttributeValueMapper;
import com.mall.core.domain.utils.BaseEntityUtils;
import com.mall.core.domain.utils.PaginationUtils;
import com.mall.product.interfaces.client.MessageServerClient;
import com.mall.product.interfaces.service.AttributeService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Meddkim on 2017/11/18.
 */
@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeNameMapper attributeNameMapper;
    @Autowired
    private AttributeValueMapper attributeValueMapper;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TestMapper testMapper;

    @Autowired
    private MessageServerClient messageServerClient;

    @Override
    public int createAttributeName(AttributeName attributeName) {
        BaseEntityUtils.fillCreateInfo(attributeName,request);
        return attributeNameMapper.insert(attributeName);
    }

    @Override
    public List<AttributeName> findAttNameByParams(Map<String, Object> paramsMap, RowBounds rowBounds) {
        return PaginationUtils.isPagination(rowBounds)
                ?attributeNameMapper.findByParams(paramsMap,rowBounds)
                :attributeNameMapper.findByParams(paramsMap);
    }

    @Override
    public int createAttributeValue(AttributeValue attributeValue) {
        BaseEntityUtils.fillCreateInfo(attributeValue,request);
        return attributeValueMapper.insert(attributeValue);
    }

    @Override
    public List<AttributeValue> findAttValueByParams(Map<String, Object> paramsMap) {
        return attributeValueMapper.findByParams(paramsMap);
    }

    @Override
//    @TxTransaction(isStart = true)
    @Transactional
    public void addTest(Test test) {
        testMapper.insert(test);
        Object result = messageServerClient.addTest();
        System.out.println(result.toString());
    }
}
