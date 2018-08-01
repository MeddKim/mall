package com.mall.product.interfaces.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "mall-base-message-server")
public interface MessageServerClient {

    @RequestMapping(value = "/message/add",method = RequestMethod.GET)
    Object addTest();
}
