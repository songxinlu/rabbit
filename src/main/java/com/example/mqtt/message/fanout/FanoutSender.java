package com.example.mqtt.message.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:发布订阅模式发送接口
 * @Author songxl
 * @Date 2021/9/15
 */
public class FanoutSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutSender.class);
    //发送模板
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(int index) {
        StringBuilder builder = new StringBuilder("fanout");
        int limitIndex = index % 3 + 1;
        for (int i = 0; i < limitIndex; i++) {
            builder.append('.');
        }
        builder.append(index + 1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend("exchange.test", "", message);
        LOGGER.info(" [x] Sent '{}'", message);
    }
}
