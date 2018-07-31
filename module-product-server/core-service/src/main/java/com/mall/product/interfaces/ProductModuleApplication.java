package com.mall.product.interfaces;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Meddkim on 2017/11/18.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2Doc
@ComponentScan(basePackages = {"com.mall.product.interfaces"})
public class ProductModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductModuleApplication.class, args);
    }
}

