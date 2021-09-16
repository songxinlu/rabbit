package com.example.mqtt.message.work;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:工作模式发送者
 * @Author songxl
 * @Date 2021/9/15
 */
public class WorkSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkSender.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * @Description发送方法
     * @param index
     * @Return void
     */
    public void send(int index) {
        StringBuilder builder = new StringBuilder("消息");
        int limitIndex = index % 3+1;
        for (int i = 0; i < limitIndex; i++) {
            builder.append('.');
        }
        builder.append(index+1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend("work", message);
        LOGGER.info(" [x] Sent '{}'", message);
    }
}
