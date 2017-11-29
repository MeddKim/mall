package com.mall.product.interfaces.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Meddkim on 2017/11/18.
 */
@Configuration
public class DataConfig {

    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer(@Value("${spring.from}") String from){
        System.out.println("测试值：  "+from);
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.mall.core.domain.mapper");
        mapperScannerConfigurer.setAnnotationClass(org.springframework.stereotype.Repository.class);
        return mapperScannerConfigurer;
    }


}
