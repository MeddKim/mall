package com.mall.message.interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class,args);
    }
}
