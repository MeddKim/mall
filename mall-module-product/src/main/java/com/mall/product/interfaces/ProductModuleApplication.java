package com.mall.product.interfaces;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Meddkim on 2017/11/18.
 */
//@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2Doc
public class ProductModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductModuleApplication.class, args);
    }
}

