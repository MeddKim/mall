package com.mall.core.domain.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Test {
    private Long id;
    private String name;
    private Timestamp createTime;
}
