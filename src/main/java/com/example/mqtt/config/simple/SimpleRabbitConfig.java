package com.example.mqtt.config.simple;

import com.example.mqtt.message.simple.SimpleReceiver;
import com.example.mqtt.message.simple.SimpleSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:创建一个简单模式，一个生产者、一个队列、一个消费者
 * @Author songxl
 * @Date 2021/9/14
 */
@Configuration
public class SimpleRabbitConfig {
    //创建队列
    @Bean
    public Queue test(){
        return new Queue("simple");
    }
    //生产者
    @Bean
    public SimpleSender simpleSender(){
        return new SimpleSender();
    }

    //消费者
    @Bean
    public SimpleReceiver simpleReceiver(){
        return new SimpleReceiver();
    }
}
