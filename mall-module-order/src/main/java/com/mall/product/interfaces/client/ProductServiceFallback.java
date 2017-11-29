package com.mall.product.interfaces.client;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class ProductServiceFallback implements AttributeService{
    @Override
    public Object findAttValues(@RequestParam("attNameId") Long attNameId) {
        return Lists.newArrayList();
    }
}
