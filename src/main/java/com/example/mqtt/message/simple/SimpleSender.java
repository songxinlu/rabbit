package com.example.mqtt.message.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:简单模式发送方法
 * @Author songxl
 * @Date 2021/9/14
 */
public class SimpleSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    //队列名称
    private static final String queueName="test";

    public void send() {
        String message = "Hello World!";
        rabbitTemplate.convertAndSend(queueName, message);
        LOGGER.info(" [x] Sent '{}'", message);
    }
}
