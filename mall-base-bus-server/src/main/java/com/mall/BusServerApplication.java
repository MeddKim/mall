package com.mall;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
//@EnableEurekaServer
public class BusServerApplication {

    public static void main(String[] args) {
//        SpringApplication.run(EurekaServerApplication.class,args);
        new SpringApplicationBuilder(BusServerApplication.class).web(true).run(args);
    }
}


