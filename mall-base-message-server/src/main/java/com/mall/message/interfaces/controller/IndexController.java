package com.mall.message.interfaces.controller;

import com.mall.message.interfaces.service.KeyValueService;
import com.mall.message.interfaces.service.RedisService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/add")
    public Object add(){
//        keyValueService.put("test","this is test");
//        keyValueService.del("test");
        redisService.putObj("stu",60,Student.builder()
                .name("张三")
                .age(22)
                .sex("男")
                .build());
        Student student = redisService.getObj("stu",Student.class);
        System.out.println(student);
        return "成功";
    }

    @GetMapping("/del/{name}")
    public Object del(@PathVariable String name){
        redisService.del(name);
        return "成功！";
    }

    @GetMapping("/expire")
    public Object expire(){
        if(redisService.setNX("131313","呵呵呵呵",10)){
            return "成功";
        }else {
            return "失败";
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    private static class Student{
        private String name;
        private Integer age;
        private String sex;
    }
}
