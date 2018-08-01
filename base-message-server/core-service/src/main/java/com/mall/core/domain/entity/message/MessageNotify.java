package com.mall.core.domain.entity.message;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MessageNotify {
    private Long id;
    private String content;
    private Timestamp createTime;
}
