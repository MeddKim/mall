package com.mall.product.interfaces.controller;

import com.mall.core.domain.entity.product.CategoryTree;
import com.mall.core.domain.enumeration.product.CategoryTreeTypeEnum;
import com.mall.core.domain.utils.BaseResponse;
import com.mall.core.domain.utils.HttpCode;
import com.mall.product.interfaces.exception.ValidateParamException;
import com.mall.product.interfaces.service.CategoryTreeService;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RefreshScope
@RestController
@RequestMapping("/categoryTree")
public class CategoryTreeController {

    @Autowired
    private CategoryTreeService categoryTreeService;

    @Value("${spring.demostr}")
    private String url;

    @PostMapping("/tree")
    public Object addCategoryTree(@RequestBody AddTreeReq addTreeReq, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidateParamException(bindingResult);
        }
        CategoryTree categoryTree = new CategoryTree();
        BeanUtils.copyProperties(addTreeReq,categoryTree);
        categoryTreeService.createCategoryTree(categoryTree);

        return BaseResponse.successResp(HttpCode.CREATEDSUCCESS);
    }

    @Data
    private static class AddTreeReq{
        @NotNull(message = "类型不能为空")
        private CategoryTreeTypeEnum type;
        @NotBlank(message = "名称不能为空")
        private String name;
    }

    @GetMapping("/backend/{id}")
    public Object findBackendCategoryTree(@PathVariable Long id){

        return null;
    }

    @GetMapping("/tree/{id}")
    public Object getCategoryTree(@PathVariable Long id){
        return null;
    }

    @GetMapping("/test")
    public Object configFromConfigSever(){
        return  url;
    }
}
