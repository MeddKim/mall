package com.mall.order.interfaces.message;


import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(value = SinkSender.class)
public class OrderInfoSender {

}

