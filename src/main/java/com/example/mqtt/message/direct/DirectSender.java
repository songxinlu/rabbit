package com.example.mqtt.message.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:路由模式发送端
 * @Author songxl
 * @Date 2021/9/15
 */
public class DirectSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private final String[] keys = {"orange", "black", "green"};

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectSender.class);

    public void send(int index) {
        StringBuilder builder = new StringBuilder("Hello to ");
        int limitIndex = index % 3;
        String key = keys[limitIndex];
        builder.append(key).append(' ');
        builder.append(index+1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend("exchange.direct", key, message);
//        LOGGER.info(" [x] Sent '{}'", message);
    }
}
