package com.mall.core.domain.mapper.message;

import com.mall.core.domain.entity.message.MessageNotify;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageNotifyMapper {

    void insert(MessageNotify message);
}
