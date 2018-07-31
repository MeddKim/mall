package com.mall.message.interfaces.service.impl;

import com.mall.core.domain.utils.MQConstant;
import lombok.Data;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class MqMessageServiceImpl {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(DMessage message){
        rabbitTemplate.convertAndSend(MQConstant.MSG_FANOUT_EXCHANGE,"",message);
    }

    @Data
    public static class DMessage{
        private String title;
        private String content;
        private String remark;
        private Timestamp timestamp;
    }
}
