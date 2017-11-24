package com.mall.product.interfaces.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mall.core.domain.entity.product.AttributeName;
import com.mall.core.domain.entity.product.AttributeValue;
import com.mall.core.domain.enumeration.product.AttributeTypeEnum;
import com.mall.core.domain.enumeration.product.AttributeValueTypeEnum;
import com.mall.core.domain.utils.*;
import com.mall.product.interfaces.exception.ValidateParamException;
import com.mall.product.interfaces.service.AttributeService;
import io.swagger.annotations.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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

    @ApiOperation(value = "创建名属性",notes = "创建属性名并返属性名ID",response = BaseResponse.class)
    @PostMapping("/attributeName")
    public Object createAttributeName(@Validated @RequestBody  createAttNameReq attNameReq,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidateParamException(bindingResult);
        }
        AttributeName attributeName = new AttributeName();
        BeanUtils.copyProperties(attNameReq,attributeName);
        attributeService.createAttributeName(attributeName);

        return BaseResponse.successResp(HttpCode.CREATEDSUCCESS,attributeName.getId());
    }
    @Data
    @ApiModel("创建属性名称")
    private static class createAttNameReq{
        @ApiModelProperty("属性名")
        @NotBlank(message = "属性名称不能为空")
        private String name;
        @ApiModelProperty("属性名类型")
        @NotNull(message = "属性类型不能为空")
        private AttributeTypeEnum type;
    }

    @ApiOperation(value = "分页查询属性名",notes = "默认分页page为1，limit为10",response = attributeNameResp.class)
    @GetMapping("/attributeName/search")
    public Object findAttributeNames(@RequestParam(name = "page",defaultValue = "1") Integer page,
                                     @RequestParam(name = "limit",defaultValue = "10") Integer limit,
                                     @RequestParam Map<String,Object> paramsMap){

        Map<String,Object> searchMap = Maps.newHashMap();
        searchMap.put("isDeleted",false);
        searchMap.put("createTimeDesc",true);
        searchMap.putAll(paramsMap);

        List<AttributeName> attributeNameList = attributeService.findAttNameByParams(searchMap, PaginationUtils.getRowBounds(page,limit));
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
    @ApiModel("属性名列表Item")
    private static class attributeNameResp{
        @ApiModelProperty("属性名ID")
        private Long id;
        @ApiModelProperty("属性名")
        private String name;
    }

    @ApiOperation(value = "创建属性值或属性值组",notes = "属性值组不需要传parentId")
    @PostMapping("/attributeValue")
    public Object createAttValueGroup(@Validated @RequestBody createAttValueReq createAttValueReq,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ValidateParamException(bindingResult);
        }
        AttributeValue attributeValue = new AttributeValue();
        BeanUtils.copyProperties(createAttValueReq,attributeValue);
        attributeService.createAttributeValue(attributeValue);

        return BaseResponse.successResp(HttpCode.CREATEDSUCCESS);
    }
    @Data
    @ApiModel("属性值（值组）")
    private static class createAttValueReq{
        private Long parentId;
        @NotNull(message = "属性名ID不能为空")
        private Long attributeNameId;
        @NotBlank(message = "属性值不能为空")
        private String value;
        @NotNull(message = "属性值排序信息不能为空")
        private Integer sortValue;

        private AttributeValueTypeEnum type;

        createAttValueReq(){
            this.parentId = 0L;
            this.type = AttributeValueTypeEnum.SELECTVAL;
        }
    }

    @GetMapping("/attributeValue/list")
    public Object findAttValues(@RequestParam Long attNameId){
        if(null == attNameId){
            throw new ValidateParamException("attNameId不能为空");
        }
        List<AttributeValue> attributeValues = attributeService.findAttValueByParams(new ImmutableMap.Builder<String,Object>()
                .put("attributeNameId",attNameId)
                .put("orderBySortValueDesc",true)
                .build());
        List<AttValueResp> attValueResps = Lists.newArrayList();
        attributeValues.forEach(attributeValue -> {
            AttValueResp attValueResp = new AttValueResp();
            BeanUtils.copyProperties(attributeValue,attValueResp);
            attValueResps.add(attValueResp);
        });
        //组装分组数据
        List<AttValueResp> attValueGroupResps = generateAttValeGroup(attValueResps);

        return attValueGroupResps;
    }

    private List<AttValueResp> generateAttValeGroup(List<AttValueResp> attValueResps){
        List<AttValueResp> attValueRespList = Lists.newArrayList();
        attValueResps.forEach(attValueResp -> {
            if(0 == attValueResp.getParentId() || null == attValueResp.getParentId()){
                attValueResps.forEach(attValueChild -> {
                    if(attValueResp.getId().equals(attValueChild.getParentId())){
                        attValueResp.getGroupItems().add(attValueChild);
                    }
                });
                attValueRespList.add(attValueResp);
            }
        });
        return attValueRespList;
    }
    @Data
    public static class AttValueResp{
        private Long id;
        private Long parentId;
        private Long attributeNameId;
        private String value;
        private Integer sortValue;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createTime;
        private List<AttValueResp> GroupItems;
        private AttValueResp(){
            this.GroupItems = Lists.newArrayList();
        }
    }

    @PostMapping("/attributeValue/sort")
    public Object ajustAttValueSort(){
        return null;
    }
}
