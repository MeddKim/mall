package com.mall.message.interfaces.controller;


import com.mall.core.domain.utils.TimeUtils;
import com.mall.message.interfaces.service.impl.MqMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MqMessageServiceImpl messageService;

    @GetMapping("/message/test")
    public Object message(){
        MqMessageServiceImpl.DMessage message = new MqMessageServiceImpl.DMessage();
        message.setTitle("测试");
        message.setContent("这是一个测试");
        message.setRemark("这是一个备注");
        message.setTimestamp(TimeUtils.now());

        messageService.sendMessage(message);

        return "发送成功";
    }
}
