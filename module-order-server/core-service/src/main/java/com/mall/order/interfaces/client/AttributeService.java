package com.mall.order.interfaces.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "product-module-service",fallback = ProductServiceFallback.class)
public interface AttributeService {

    @RequestMapping(value = "/attribute/attributeValue/list",method = RequestMethod.GET)
    Object findAttValues(@RequestParam("attNameId") Long attNameId);

}
