package com.mall.product.interfaces;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by Meddkim on 2017/11/18.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableSwagger2Doc
public class OrderModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderModuleApplication.class, args);
    }
}

