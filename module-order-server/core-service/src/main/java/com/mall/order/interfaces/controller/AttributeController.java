package com.mall.order.interfaces.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mall.order.interfaces.client.AttributeService;
import com.mall.order.interfaces.message.SinkSender;
import com.mall.product.interfaces.exception.ValidateParamException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
@Validated
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @Autowired
    private SinkSender sinkSender;

    @GetMapping("/list")
    public Object findAttValues(@RequestParam Long attNameId){

        log.info("--order-module-service trace--");

        if(null == attNameId){
            throw new ValidateParamException("attNameId不能为空");
        }
        return attributeService.findAttValues(attNameId);
    }

    @GetMapping("/send")
    public void sendTest(){
        sinkSender.ouptput().send(MessageBuilder.withPayload("发送一个消息").build());
    }


    @GetMapping("msg/test")
    private Object msgTest(){
        return "成功";
    }


    @PostMapping("model/test")
    @Validated
    public void modelTest(@RequestBody @Validated List<DemoReq> reqs, BindingResult result){
        if(result.hasErrors()){
            System.out.println(result.getFieldError().getDefaultMessage());
            return;
        }
        System.out.println(reqs);
    }
    @Data
    @Validated
    private static class DemoReq{
//        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
        private Date dateTime;
        private Long id;
        @NotNull(message = "不可为空")
        private Integer age;
        @NotBlank(message = "名称不可为空")
        private String name;
    }

}
