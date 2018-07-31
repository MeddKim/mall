package com.mall.order.interfaces.controller;


import com.mall.order.interfaces.client.AttributeService;
import com.mall.order.interfaces.message.SinkSender;
import com.mall.product.interfaces.exception.ValidateParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
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
}
