package com.example.mqtt.message.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:通配符发送端
 * @Author songxl
 * @Date 2021/9/15
 */
public class TopicSender {
    @Autowired
    private RabbitTemplate template;

    private static final Logger LOGGER = LoggerFactory.getLogger(TopicSender.class);
    private final String[] keys = {"quick.orange.rabbit", "lazy.orange.elephant", "quick.orange.fox",
            "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox"};

    public void send(int index) {
        StringBuilder builder = new StringBuilder("Hello to ");
        int limitIndex = index%keys.length;
        String key = keys[limitIndex];
        builder.append(key).append(' ');
        builder.append(index+1);
        String message = builder.toString();
        template.convertAndSend("exchange.topic", key, message);
//        LOGGER.info(" [x] Sent '{}'",message);
    }

}
