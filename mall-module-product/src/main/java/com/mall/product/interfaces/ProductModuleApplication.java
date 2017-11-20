package com.mall.product.interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Meddkim on 2017/11/18.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProductModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductModuleApplication.class, args);
    }
}

