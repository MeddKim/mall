package com.mall.product.interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
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

