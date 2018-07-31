package com.mall.message.interfaces.service.listener;

import com.mall.core.domain.utils.MQConstant;
import com.mall.message.interfaces.service.impl.MqMessageServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqMessageListener {

    @RabbitListener(queues = MQConstant.MSG_FANOUT_QUEUE)
    public void messageListener(MqMessageServiceImpl.DMessage message){
        System.out.println("打印消息队列");
        System.out.println(message);
//        if(true)
//            throw new AmqpRejectAndDontRequeueException("测试"); //这个异常抛出，消息被消费
    }

    @RabbitListener
    public void delayMessageListener(MqMessageServiceImpl.DMessage message){
        System.out.println("打印延迟消息");
        System.out.println(message);
    }
}
