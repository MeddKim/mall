package com.mall.product.interfaces.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding({Sink.class})
@Slf4j
public class OrderInfoReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        log.info("Received: "+payload);
    }
}
