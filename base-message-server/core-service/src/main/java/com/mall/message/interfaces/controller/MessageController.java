package com.mall.message.interfaces.controller;


import com.mall.core.domain.entity.message.MessageNotify;
import com.mall.core.domain.utils.TimeUtils;
import com.mall.message.interfaces.service.MessageService;
import com.mall.message.interfaces.service.impl.MqMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MqMessageServiceImpl mqMessageService;
    @Autowired
    private MessageService messageService;

    @GetMapping("/message/test")
    public Object message(){
        MqMessageServiceImpl.DMessage message = new MqMessageServiceImpl.DMessage();
        message.setTitle("测试");
        message.setContent("这是一个测试");
        message.setRemark("这是一个备注");
        message.setTimestamp(TimeUtils.now());

        mqMessageService.sendMessage(message);

        return "发送成功";
    }

    @GetMapping("/message/add")
    public Object addMessage(){
        MessageNotify messageNotify = new MessageNotify();
        messageNotify.setContent("这是一个测试");
        messageNotify.setCreateTime(TimeUtils.now());
        messageService.addMessageNotify(messageNotify);
        return "添加成功";
    }
}
