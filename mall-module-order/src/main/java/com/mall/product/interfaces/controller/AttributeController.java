package com.mall.product.interfaces.controller;


import com.mall.product.interfaces.client.AttributeService;
import com.mall.product.interfaces.exception.ValidateParamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @GetMapping("/list")
    public Object findAttValues(@RequestParam Long attNameId){
        if(null == attNameId){
            throw new ValidateParamException("attNameId不能为空");
        }
        return attributeService.findAttValues(attNameId);
    }
}
