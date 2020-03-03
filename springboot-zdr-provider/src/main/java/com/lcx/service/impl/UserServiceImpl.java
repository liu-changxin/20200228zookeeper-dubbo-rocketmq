package com.lcx.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcx.service.IUserService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = IUserService.class)
public class UserServiceImpl implements IUserService {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Value("${my.order.producer.group.name}")
    private String group;
    @Value("${my.order.topic}")
    private String topic;

    @Override
    public String sayHello(String name) {
        rocketMQTemplate.convertAndSend(topic,new String("我是发送的内容啊"+name).getBytes());
        return ""+name;
    }
}
