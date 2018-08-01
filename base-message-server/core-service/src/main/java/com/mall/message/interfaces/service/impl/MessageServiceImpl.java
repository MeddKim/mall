package com.mall.message.interfaces.service.impl;

import com.mall.core.domain.entity.message.MessageNotify;
import com.mall.core.domain.mapper.message.MessageNotifyMapper;
import com.mall.message.interfaces.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageNotifyMapper messageNotifyMapper;

    @Override
    public void addMessageNotify(MessageNotify messageNotify) {
        messageNotifyMapper.insert(messageNotify);
    }
}
