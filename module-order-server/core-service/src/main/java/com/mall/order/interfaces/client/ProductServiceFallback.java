package com.mall.order.interfaces.client;

import com.mall.core.domain.utils.BaseResponse;
import com.mall.core.domain.utils.HttpCode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ProductServiceFallback implements AttributeService{
    @Override
    public Object findAttValues(@RequestParam("attNameId") Long attNameId) {
//        return Lists.newArrayList();
        return BaseResponse.failResp(HttpCode.BADREQUEST,"请求失败!");
    }
}
