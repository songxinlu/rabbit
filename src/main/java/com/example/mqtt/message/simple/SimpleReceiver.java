package com.example.mqtt.message.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @Description:简单模式接收者
 * @Author songxl
 * @Date 2021/9/14
 */
@RabbitListener(queues = {"test"})
public class SimpleReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleReceiver.class);

    @RabbitHandler
    public void receive(String in) {
        LOGGER.info(" [x] Received '{}'", in);
    }
}
