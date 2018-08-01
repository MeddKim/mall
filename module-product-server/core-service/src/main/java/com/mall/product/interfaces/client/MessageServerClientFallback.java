package com.mall.product.interfaces.client;

import org.springframework.stereotype.Component;

@Component
public class MessageServerClientFallback implements MessageServerClient{
    @Override
    public Object addTest() {
        return "失败";
    }
}
