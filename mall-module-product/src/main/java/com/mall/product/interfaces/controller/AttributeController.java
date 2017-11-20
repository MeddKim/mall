package com.mall.product.interfaces.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mall.core.domain.entity.product.AttributeName;
import com.mall.core.domain.enumeration.product.AttributeTypeEnum;
import com.mall.core.domain.utils.BaseEntityUtils;
import com.mall.core.domain.utils.BaseResponse;
import com.mall.core.domain.utils.PageInfo;
import com.mall.core.domain.utils.PaginationUtils;
import com.mall.product.interfaces.service.AttributeService;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.AttributeType;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Meddkim on 2017/11/18.
 */
@RequestMapping("/attribute")
@RestController
public class AttributeController {

    @Autowired
    private AttributeService attributeService;
    @Autowired
    private HttpServletRequest request;

    @PostMapping("/attributeName")
    public Object createAttributeName(@RequestBody createAttributeNameReq attributeNameReq){
        AttributeName attributeName = new AttributeName();
        BeanUtils.copyProperties(attributeNameReq,attributeName);
        BaseEntityUtils.fillCreateInfo(attributeName,request);
        attributeService.craeteAttributeName(attributeName);
        return BaseResponse.successResp("操作成功");
    }

    @Data
    private static class createAttributeNameReq{
        private String name;
        private AttributeTypeEnum type;
        private Long companyId; //权限层需添加字段
    }

    @GetMapping("/attribute/search")
    public Object findAttributeNames(@RequestParam(name = "page",defaultValue = "1") Integer page,
                                     @RequestParam(name = "limit",defaultValue = "10") Integer limit,
                                     @RequestParam Map<String,Object> paramsMap){

        Map<String,Object> searchMap = Maps.newHashMap();
        searchMap.put("isDeleted",false);
        searchMap.put("createTimeDesc",true);
        searchMap.putAll(paramsMap);

        List<AttributeName> attributeNameList = attributeService.findAttributeNameByParams(searchMap, PaginationUtils.getRowBounds(page,limit));
        PageInfo pageInfo = new PageInfo(attributeNameList);

        attributeNameList.forEach(attributeName -> {
            attributeNameResp attributeNameResp = new attributeNameResp();
            attributeNameResp.setId(attributeName.getId());
            attributeNameResp.setName(attributeName.getName());
            pageInfo.add(attributeNameResp);
        });

        return pageInfo;
    }

    @Data
    private static class attributeNameResp{
        private Long id;
        private String name;
    }
}
