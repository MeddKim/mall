package com.mall.api.merchant.interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by Meddkim on 2017/11/18.
 */
@EnableZuulProxy
@SpringCloudApplication
public class MerchantApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MerchantApiApplication.class, args);
    }
}

