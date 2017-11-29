package com.mall.bus.rabbitmq.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitListener
    public void process(String hello){
        System.out.println("Receiver: "+hello);
    }
}
