package com.mall.product.interfaces.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding({Sink.class})
@Slf4j
public class OrderInfoReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        System.out.println("你好，接收到一个消息");
        log.info("Receivedddddddssssss: "+payload);
    }
}
